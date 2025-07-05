package com.portfolio.ecomdm.checkout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutItem {
    // Getters and setters
    private String title;
    private int quantity;
    private double price;

}
