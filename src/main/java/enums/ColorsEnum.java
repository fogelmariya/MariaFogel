package enums;

public enum ColorsEnum {

    YELLOW("Yellow"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    COLOR("Colors");

    public String text;

    ColorsEnum(String text) {
        this.text = text;
    }
}
