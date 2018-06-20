package enums;

public enum VegetablesEnum {
    ONION("Onion"),
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad");

    public String text;

    VegetablesEnum(String text) {
        this.text = text;
    }
}
