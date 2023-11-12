package christmas.controller;

import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import christmas.service.OriginalOrderService;

public class OriginalOrderController {

    private final OriginalOrderService originalOrderService;

    public OriginalOrderController() {
        originalOrderService = new OriginalOrderService();
    }

    public OriginalOrderAmount getOriginalOrderAmount(Menus menus, User user) {
        return originalOrderService.createOriginalOrderAmount(menus, user);
    }
}
