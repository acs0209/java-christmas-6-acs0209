package christmas.controller.event;

import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.DiscountedOrderAmount;
import christmas.service.event.DiscountedOrderService;

public class DiscountedOrderController {

    private final DiscountedOrderService discountedOrderService;

    public DiscountedOrderController() {
        this.discountedOrderService = new DiscountedOrderService();
    }

    public DiscountedOrderAmount getDiscountedOrderAmount(OriginalOrderAmount originalOrderAmount, BenefitDetails benefitDetails) {
        return discountedOrderService.createDiscountedOrderAmount(originalOrderAmount, benefitDetails);
    }
}
