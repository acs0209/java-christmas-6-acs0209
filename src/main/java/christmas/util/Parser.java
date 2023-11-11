package christmas.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<String> stringToList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
