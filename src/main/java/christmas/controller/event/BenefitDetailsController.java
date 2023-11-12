package christmas.controller.event;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.service.event.BenefitDetailsService;

public class BenefitDetailsController {

    private final BenefitDetailsService benefitDetailsService;

    public BenefitDetailsController() {
        this.benefitDetailsService = new BenefitDetailsService();
    }

    public void getBenefitDetails(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        benefitDetailsService.createBenefitDetails(originalOrderAmount, eventPlanDto);
    }
}