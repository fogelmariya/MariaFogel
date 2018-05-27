package enums;

public enum MetalsEnum {
    METALS("metal"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String text;

    MetalsEnum(String text) {
        this.text = text;
    }
}
