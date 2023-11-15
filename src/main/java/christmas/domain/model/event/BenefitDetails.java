package christmas.domain.model.event;

import static christmas.domain.constant.event.BenefitDetailsConstant.CHRISTMAS_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.GIFT_EVENT;
import static christmas.domain.constant.event.BenefitDetailsConstant.SPECIAL_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.WEEKDAY_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.WEEKEND_DISCOUNT;
import static christmas.domain.constant.event.DiscountEventConstant.CHRISTMAS_DAY;
import static christmas.domain.constant.event.DiscountEventConstant.CHRISTMAS_EVENT_LAST_DAY;
import static christmas.domain.constant.event.DiscountEventConstant.CHRISTMAS_EVENT_START_DAY;
import static christmas.domain.constant.event.DiscountEventConstant.DAYS_IN_WEEK;
import static christmas.domain.constant.event.DiscountEventConstant.DESSERT;
import static christmas.domain.constant.event.DiscountEventConstant.CHRISTMAS_DISCOUNT_AMOUNT;
import static christmas.domain.constant.event.DiscountEventConstant.DISCOUNT_AMOUNT;
import static christmas.domain.constant.event.DiscountEventConstant.FIRST_DAY;
import static christmas.domain.constant.event.DiscountEventConstant.GIFT_EVENT_AMOUNT;
import static christmas.domain.constant.event.DiscountEventConstant.GIFT_EVENT_CHECK;
import static christmas.domain.constant.event.DiscountEventConstant.MAIN;
import static christmas.domain.constant.event.DiscountEventConstant.SPECIAL_DAY;
import static christmas.domain.constant.event.DiscountEventConstant.SPECIAL_DISCOUNT_AMOUNT;
import static christmas.domain.constant.event.DiscountEventConstant.START_VALUE;
import static christmas.domain.constant.event.DiscountEventConstant.WEEKEND_DAY_1;
import static christmas.domain.constant.event.DiscountEventConstant.WEEKEND_DAY_2;

import christmas.domain.constant.event.BenefitDetailsConstant;
import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menu;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import java.util.HashMap;
import java.util.Map;

public class BenefitDetails {

    private final Map<String, Integer> benefitDetails = new HashMap<>();
    private int totalBenefitAmount;

    private BenefitDetails() {
        initBenefitDetails();
        totalBenefitAmount = 0;
    }

    public static BenefitDetails create() {
        return new BenefitDetails();
    }

    private void initBenefitDetails() {
        BenefitDetailsConstant.getEvents(benefitDetails);
    }

    public void createEventPlan(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        updateChristmasDiscount(eventPlanDto.getUser());
        updateWeekdayDiscount(eventPlanDto);
        updateWeekendDiscount(eventPlanDto);
        updateSpecialDiscount(eventPlanDto.getUser());
        updateGiftEvent(originalOrderAmount);
        updateTotalBenefitAmount();
    }

    private void updateChristmasDiscount(User user) {
        int visitDate = user.getVisitDate();
        if (isChristmasEventDay(visitDate)) {
            int benefit = createChristmasDiscount(visitDate);
            benefitDetails.put(CHRISTMAS_DISCOUNT.getMessage(), benefit);
        }
    }

    private boolean isChristmasEventDay(int visitDate) {
        return CHRISTMAS_EVENT_START_DAY.getNumber() <= visitDate && visitDate <= CHRISTMAS_EVENT_LAST_DAY.getNumber();
    }

    private int createChristmasDiscount(int visitDate) {
        return (visitDate - FIRST_DAY.getNumber()) * CHRISTMAS_DISCOUNT_AMOUNT.getNumber() + START_VALUE.getNumber();
    }

    private void updateWeekdayDiscount(EventPlanDto eventPlanDto) {
        int visitDate = eventPlanDto.getUser().getVisitDate();
        if (isWeekday(visitDate)) {
            int weekdayDiscount = createWeekdayDiscount(eventPlanDto);
            benefitDetails.put(WEEKDAY_DISCOUNT.getMessage(), weekdayDiscount);
        }
    }

    private boolean isWeekday(int visitDate) {
        return visitDate % DAYS_IN_WEEK.getNumber() != WEEKEND_DAY_1.getNumber() && visitDate % DAYS_IN_WEEK.getNumber() != WEEKEND_DAY_2.getNumber();
    }

    private int createWeekdayDiscount(EventPlanDto eventPlanDto) {
        Map<String, Integer> orderMenu = eventPlanDto.getUser().getOrderMenu();
        Map<String, Menu> menus = eventPlanDto.getMenus().getMenus();
        int menuCount = orderMenu.entrySet()
                .stream()
                .filter(entry -> DESSERT.getMessage().equals(menus.get(entry.getKey()).getCategory()))
                .mapToInt(Map.Entry::getValue)
                .sum();

        return menuCount * DISCOUNT_AMOUNT.getNumber();
    }

    private void updateWeekendDiscount(EventPlanDto eventPlanDto) {
        int visitDate = eventPlanDto.getUser().getVisitDate();
        if (isWeekend(visitDate)) {
            int weekendDiscount = createWeekendDiscount(eventPlanDto);
            benefitDetails.put(WEEKEND_DISCOUNT.getMessage(), weekendDiscount);
        }
    }

    private boolean isWeekend(int visitDate) {
        return visitDate % DAYS_IN_WEEK.getNumber() == WEEKEND_DAY_1.getNumber() || visitDate % DAYS_IN_WEEK.getNumber() == WEEKEND_DAY_2.getNumber();
    }

    private int createWeekendDiscount(EventPlanDto eventPlanDto) {
        Map<String, Integer> orderMenu = eventPlanDto.getUser().getOrderMenu();
        Map<String, Menu> menus = eventPlanDto.getMenus().getMenus();
        int menuCount = orderMenu.entrySet()
                .stream()
                .filter(entry -> MAIN.getMessage().equals(menus.get(entry.getKey()).getCategory()))
                .mapToInt(Map.Entry::getValue)
                .sum();

        return menuCount * DISCOUNT_AMOUNT.getNumber();
    }

    private void updateSpecialDiscount(User user) {
        int visitDate = user.getVisitDate();
        if (isSpecialDay(visitDate)) {
            benefitDetails.put(SPECIAL_DISCOUNT.getMessage(), SPECIAL_DISCOUNT_AMOUNT.getNumber());
        }
    }

    private boolean isSpecialDay(int visitDate) {
        return visitDate % DAYS_IN_WEEK.getNumber() == SPECIAL_DAY.getNumber() || visitDate == CHRISTMAS_DAY.getNumber();
    }

    private void updateGiftEvent(OriginalOrderAmount originalOrderAmount) {
        if (originalOrderAmount.getOrderAmount() > GIFT_EVENT_CHECK.getNumber()) {
            benefitDetails.put(GIFT_EVENT.getMessage(), GIFT_EVENT_AMOUNT.getNumber());
        }
    }

    private void updateTotalBenefitAmount() {
        this.totalBenefitAmount = benefitDetails.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Map<String, Integer> getBenefitDetails() {
        return benefitDetails;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }
}