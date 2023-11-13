package christmas.service.event;

import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.DiscountedOrderAmount;

public class DiscountedOrderService {

    public DiscountedOrderAmount createDiscountedOrderAmount(OriginalOrderAmount originalOrderAmount, BenefitDetails benefitDetails) {
        return DiscountedOrderAmount.create(originalOrderAmount, benefitDetails);
    }
}
