package christmas.service;

import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;

public class OriginalOrderService {

    public OriginalOrderAmount createOriginalOrderAmount(Menus menus, User user) {
        return OriginalOrderAmount.create(menus, user);
    }
}
