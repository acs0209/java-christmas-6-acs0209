package christmas.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String COMMA_DELIMITER = ",";
    private static final String HYPHEN_DELIMITER = "-";

    private Parser() {
    }

    public static List<String> stringToList(String input) {
        return Arrays.asList(input.split(COMMA_DELIMITER));
    }

    public static void extractMenuNamesFromMenus(List<String> menus, List<String> menuNames) {
        menus.stream()
                .map(menuItem -> menuItem.split(HYPHEN_DELIMITER))
                .forEach(menu -> menuNames.add(menu[0]));
    }
}
