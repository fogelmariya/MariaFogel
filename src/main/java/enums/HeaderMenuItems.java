package enums;

public enum HeaderMenuItems {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    public String item;

    HeaderMenuItems(String item){
        this.item = item;
    }
}
