package com.sunday;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaceOrderCommandTest {
    @Mock
    Orders orders;

    @InjectMocks
    PlaceOrderCommand.Handler handler;

    OrderableProduct ouicheLorraine = new OrderableProduct("Ouiche Lorraine", 500);

    @Test
    void should_place_an_order_and_save() {
        var orderNumber = new OrderNumber("123");
        var pendingOrder = new Order(orderNumber);
        pendingOrder.addProduct(ouicheLorraine, 1);

        when(orders.get(orderNumber)).thenReturn(pendingOrder);

        var command = new PlaceOrderCommand(orderNumber);

        handler.handle(command);

        var orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orders).save(orderCaptor.capture());

        var savedOrder = orderCaptor.getValue();
        assertEquals(Order.OrderStatus.PLACED, savedOrder.status());
    }

    @Test
    void should_not_place_an_order_with_no_items() {
        var orderNumber = new OrderNumber("123");
        var pendingOrder = new Order(orderNumber);

        when(orders.get(orderNumber)).thenReturn(pendingOrder);

        var command = new PlaceOrderCommand(orderNumber);
        assertThrows(IllegalStateException.class, () -> handler.handle(command));
    }

    @Test
    void should_not_place_an_order_already_placed() {
        var orderNumber = new OrderNumber("123");
        var orderToPlace = new Order(orderNumber);
        orderToPlace.addProduct(ouicheLorraine, 1);
        orderToPlace.place();

        when(orders.get(orderNumber)).thenReturn(orderToPlace);

        var command = new PlaceOrderCommand(orderNumber);
        assertThrows(IllegalStateException.class, () -> handler.handle(command));
    }
}