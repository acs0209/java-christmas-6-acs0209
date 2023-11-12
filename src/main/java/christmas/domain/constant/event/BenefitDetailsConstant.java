package christmas.domain.constant.event;

import java.util.Map;

public enum BenefitDetailsConstant {

    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인", 0),
    WEEKDAY_DISCOUNT("평일 할인", 0),
    WEEKEND_DISCOUNT("주말 할인", 0),
    SPECIAL_DISCOUNT("특별 할인", 0),
    GIFT_EVENT("증정 이벤트", 0);

    private final String message;
    private final int number;

    BenefitDetailsConstant(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }

    public static void getEvents(Map<String, Integer> benefitDetails) {
        for (BenefitDetailsConstant event : BenefitDetailsConstant.values()) {
            benefitDetails.put(event.getMessage(), event.getNumber());
        }
    }
}