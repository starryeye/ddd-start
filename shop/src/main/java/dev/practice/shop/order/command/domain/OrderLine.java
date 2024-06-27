package dev.practice.shop.order.command.domain;

import dev.practice.shop.catalog.command.domain.ProductId;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class OrderLine {

    @Embedded
    private ProductId productId;
}
