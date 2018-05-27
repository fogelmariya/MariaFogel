package enums;

import java.util.Arrays;
import java.util.List;

public enum Services {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFOMANSE("PERFORMANCE");

    public String text;

    Services(String text) {
        this.text = text;
    }
    public static List<String> getServices() {
        return Arrays.asList(SUPPORT.text, DATES.text, COMPLEX_TABLE.text, SIMPLE_TABLE.text, USER_TABLE.text,
                TABLE_WITH_PAGES.text, DIFFERENT_ELEMENTS.text, PERFOMANSE.text);
    }
}
