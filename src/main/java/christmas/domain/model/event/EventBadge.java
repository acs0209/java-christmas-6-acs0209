package christmas.domain.model.event;

import static christmas.domain.constant.event.EventBadgeConstant.NO_EVENT_BADGE;
import static christmas.domain.constant.event.EventBadgeConstant.SANTA;
import static christmas.domain.constant.event.EventBadgeConstant.STAR;
import static christmas.domain.constant.event.EventBadgeConstant.TREE;

public class EventBadge {

    private final String eventBadge;

    private EventBadge(BenefitDetails benefitDetails) {
        eventBadge = createEventBadge(benefitDetails);
    }

    public static EventBadge create(BenefitDetails benefitDetails) {
        return new EventBadge(benefitDetails);
    }

    private String createEventBadge(BenefitDetails benefitDetails) {
        int totalBenefitAmount = benefitDetails.getTotalBenefitAmount();
        if (totalBenefitAmount >= SANTA.getNumber()) {
            return SANTA.getMessage();
        }
        if (totalBenefitAmount >= TREE.getNumber()) {
            return TREE.getMessage();
        }
        if (totalBenefitAmount >= STAR.getNumber()) {
            return STAR.getMessage();
        }
        return NO_EVENT_BADGE.getMessage();
    }

    public String getEventBadge() {
        return eventBadge;
    }
}
