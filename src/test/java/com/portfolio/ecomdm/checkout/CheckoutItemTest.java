package com.portfolio.ecomdm.checkout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutItemTest {

    @Test
    void getQuantity() {
        CheckoutItem item = new CheckoutItem("title 1", 2, 0.6);
        assertEquals(item.getQuantity(), 2);
    }
}