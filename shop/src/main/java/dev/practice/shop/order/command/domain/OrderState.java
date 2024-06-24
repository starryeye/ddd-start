package dev.practice.shop.order.command.domain;

public enum OrderState {

    PAYMENT_WAITING, // 결제 대기중
    PREPARING, // 상품 준비중
    SHIPPED, // 상품 출고 완료
    DELIVERING, // 배송중
    DELIVERY_COMPLETED // 배송 완료
}
