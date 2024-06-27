package dev.practice.shop.order.command.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderNumber implements Serializable {

    @Column(name = "order_number")
    private String number;

    @Builder
    private OrderNumber(String number) {
        this.number = number;
    }

    public static OrderNumber of(String number) {
        return OrderNumber.builder()
                .number(number)
                .build();
    }
}
