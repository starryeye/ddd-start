package dev.practice.shop.order.domain;

public class Order {

    /**
     * 도메인
     *  소프트웨어로 해결하고자 하는 문제 영역, 구현해야할 소프트웨어 대상
     *
     * 도메인은 하위 도메인이 존재할 수 있다.
     *  온라인 쇼핑 도메인은 "주문", "회원", "배송", "결제" 등의 하위 도메인으로 다시 나뉠 수 있다.
     *
     * domain model pattern
     *  아키텍처 상의 도메인 계층을 객체 지향 기법으로 구현하는 패턴을 의미한다.
     * 도메인 계층
     *  시스템이 제공할 도메인의 핵심 규칙을 구현하는 계층이다.
     *
     *
     * 해당 코드는 주문 도메인의 기능을 도메인 모델 패턴으로 구현한 코드이다.
     * 주문과 관련된 핵심 비즈니스 규칙을 주문 도메인 모델인 Order 로 구현하고 있다.
     *  "결제 대기중, 상품 준비중 상태에서는 배송지 정보를 변경할 수 있다." 를 Order(도메인 모델) 에서 구현하였다.
     *  핵심 비즈니스 규칙은 도메인 모델에만 존재하도록하면 규칙이 변경되거나 확장될 때, 다른 코드에 영향을 최소화 할 수 있다.
     *
     */

    private OrderState state; // 주문 상태
    private ShippingInfo shippingInfo; // 배송지 정보

    public void changeShippingInfo(ShippingInfo newShippingInfo) {

        if(!isShippingChangeable()) { // 배송지 정보 변경 가능 여부
            throw new IllegalStateException("can't change shipping in " + state + " state..");
        }
        this.shippingInfo = newShippingInfo;
    }

    private boolean isShippingChangeable() {
        // 핵심 비즈니스 규칙을 주문 도메인 모델(Order) 에서 구현하였다.
        // 결제 대기중, 상품 준비중 상태에서는 배송지 정보를 변경할 수 있다.
        return state == OrderState.PAYMENT_WAITING
                || state == OrderState.PREPARING;
    }

}
