package site.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;

public class MyMenu<T extends Enum> extends Menu<T> {
    @SafeVarargs
    public final void selects(T... items) {
        for (T t : items) {
            select(t);
        }
    }
}
