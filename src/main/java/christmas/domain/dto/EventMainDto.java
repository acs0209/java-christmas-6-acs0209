package christmas.domain.dto;

import christmas.domain.model.Menus;
import christmas.domain.model.User;

public class EventMainDto {
    private final Menus menus;
    private final User user;

    private EventMainDto(Menus menus, User user) {
        this.menus = menus;
        this.user = user;
    }

    public static EventMainDto create(Menus menus, User user) {
        return new EventMainDto(menus, user);
    }

    public Menus getMenus() {
        return menus;
    }

    public User getUser() {
        return user;
    }
}
