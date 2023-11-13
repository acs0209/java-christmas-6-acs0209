package christmas.domain.model.event;

import static christmas.domain.constant.event.BenefitDetailsConstant.GIFT_EVENT;

import christmas.domain.model.OriginalOrderAmount;

public class DiscountedOrderAmount {

    private final int discountedOrderAmount;

    private DiscountedOrderAmount(OriginalOrderAmount originalOrderAmount, BenefitDetails benefitDetails) {
        discountedOrderAmount = createDiscountedOrderAmount(originalOrderAmount, benefitDetails);
    }

    public static DiscountedOrderAmount create(OriginalOrderAmount originalOrderAmount, BenefitDetails benefitDetails) {
        return new DiscountedOrderAmount(originalOrderAmount, benefitDetails);
    }

    private int createDiscountedOrderAmount(OriginalOrderAmount originalOrder, BenefitDetails benefitDetails) {
        int originalOrderAmount = originalOrder.getOrderAmount();
        int totalDiscountAmount = benefitDetails.getTotalBenefitAmount() - benefitDetails.getBenefitDetails()
                .get(GIFT_EVENT.getMessage());
        return originalOrderAmount - totalDiscountAmount;
    }

    public int getDiscountedOrderAmount() {
        return discountedOrderAmount;
    }
}
