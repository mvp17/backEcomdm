package com.portfolio.ecomdm.checkout;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    @PostMapping
    public ResponseEntity<?> createCheckoutSession(@RequestBody List<CheckoutItem> items, HttpServletRequest request) {
        try {
            List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

            for (CheckoutItem item : items) {
                lineItems.add(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity((long) item.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")
                                                .setUnitAmount((long) (item.getPrice() * 100)) // in cents
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName(item.getTitle())
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                );
            }

            String origin = request.getHeader("Origin");

            SessionCreateParams params = SessionCreateParams.builder()
                    .addAllLineItem(lineItems)
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(origin + "/success")
                    .setCancelUrl(origin + "/cancel")
                    .build();

            Session session = Session.create(params);
            Map<String, String> response = new HashMap<>();
            response.put("checkoutUrl", session.getUrl());

            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Stripe Error: " + e.getMessage());
        }
    }
}
