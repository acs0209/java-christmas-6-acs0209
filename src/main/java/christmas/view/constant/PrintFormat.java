package christmas.view.constant;

import java.text.DecimalFormat;

public enum PrintFormat {
    SEPARATOR_FORMAT(new DecimalFormat("#,##0"));

    private final DecimalFormat format;

    PrintFormat(DecimalFormat format) {
        this.format = format;
    }

    public DecimalFormat getFormat() {
        return format;
    }
}
