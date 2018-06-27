package enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum HeaderMenuItems {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    public String item;

    @Override
    public String toString() {
        return item;
    }
}
