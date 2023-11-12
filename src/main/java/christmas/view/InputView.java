package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.model.Menus;
import christmas.validation.CommonErrorValidator;
import christmas.validation.OrderMenuInputValidator;
import christmas.validation.VisitDateInputValidator;

public class InputView {

    private final CommonErrorValidator commonErrorValidator;
    private final VisitDateInputValidator visitDateInputValidator;
    private final OrderMenuInputValidator orderMenuInputValidator;

    public InputView() {
        this.commonErrorValidator = new CommonErrorValidator();
        this.visitDateInputValidator = new VisitDateInputValidator();
        this.orderMenuInputValidator = new OrderMenuInputValidator();
    }

    public String readDate() {
        while (true) {
            try {
                String input = Console.readLine();
                commonErrorValidator.validateCommonError(input);
                visitDateInputValidator.validateInputDate(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readMenu(Menus menus) {
        while (true) {
            try {
                String input = Console.readLine();
                commonErrorValidator.validateCommonError(input);
                orderMenuInputValidator.validateMenuInput(input);
                menus.validateMenuExist(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}