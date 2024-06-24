package dev.practice.shop.order.command.domain;

import dev.practice.shop.common.model.Money;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @EmbeddedId
    private OrderNumber orderNumber;

    @Embedded
    private Orderer orderer; // 주문자

    private List<OrderLine> orderLines; // 주문 목록

    private Money totalAmounts; // 총 금액

    @Embedded
    private ShippingInfo shippingInfo; // 배송지 정보

    @Enumerated(value = EnumType.STRING)
    private OrderState state; // 주문 상태

    private LocalDateTime orderedAt;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {

        if(!isShippingChangeable()) { // 배송지 정보 변경 가능 여부
            throw new IllegalStateException("can't change shipping in " + state + " state..");
        }
        this.shippingInfo = newShippingInfo;
    }

    private boolean isShippingChangeable() {
        // 핵심 비즈니스 규칙을 주문 도메인 모델(Order) 에서 구현하였다.
        // [BIZ] 결제 대기중, 상품 준비중 상태에서는 배송지 정보를 변경할 수 있다.
        return state == OrderState.PAYMENT_WAITING
                || state == OrderState.PREPARING;
    }

}
