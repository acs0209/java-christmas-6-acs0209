package christmas.service.event;

import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.EventBadge;

public class EventBadgeService {

    public EventBadge createEventBadge(BenefitDetails benefitDetails) {
        return EventBadge.create(benefitDetails);
    }
}
