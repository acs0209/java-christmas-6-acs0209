package christmas.controller.event;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.BenefitDetails;
import christmas.service.event.BenefitDetailsService;

public class BenefitDetailsController {

    private final BenefitDetailsService benefitDetailsService;

    public BenefitDetailsController() {
        this.benefitDetailsService = new BenefitDetailsService();
    }

    public BenefitDetails getBenefitDetails(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        return benefitDetailsService.createBenefitDetails(originalOrderAmount, eventPlanDto);
    }
}