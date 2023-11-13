package christmas.controller.event;

import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.EventBadge;
import christmas.service.event.EventBadgeService;

public class EventBadgeController {

    private final EventBadgeService eventBadgeService;

    public EventBadgeController() {
        this.eventBadgeService = new EventBadgeService();
    }

    public EventBadge getEventBadge(BenefitDetails benefitDetails) {
        return eventBadgeService.createEventBadge(benefitDetails);
    }
}
