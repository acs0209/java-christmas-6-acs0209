package christmas.domain.dto;

import christmas.domain.model.Menus;
import christmas.domain.model.User;

public class EventPlanDto {
    private final Menus menus;
    private final User user;

    private EventPlanDto(Menus menus, User user) {
        this.menus = menus;
        this.user = user;
    }

    public static EventPlanDto create(Menus menus, User user) {
        return new EventPlanDto(menus, user);
    }

    public Menus getMenus() {
        return menus;
    }

    public User getUser() {
        return user;
    }
}
