package christmas.service.event;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.BenefitDetails;

public class BenefitDetailsService {

    public BenefitDetails createBenefitDetails(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        BenefitDetails benefitDetails = BenefitDetails.create();
        benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);
        return benefitDetails;
    }
}
