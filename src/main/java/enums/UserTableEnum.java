package enums;

import java.util.Arrays;
import java.util.List;

public enum UserTableEnum {

    ROMAN("Roman"),
    SERGEY_IVAN("Sergey Ivan"),
    VLADZIMIR("Vladzimir"),
    HELEN_BENETT("Helen Bennett"),
    YOSHI("Yoshi Tannamuri"),
    GIOVANNI("Giovanni Rovelli"),
    LOREM("Lorem ipsum"),
    LOREM_DESC("Lorem ipsum some description"),
    ADMIN("Admin"),
    USER("User"),
    MANAGER("Manager");

    public String name;

    UserTableEnum (String text){
        this.name = text;
    }

    public static List<String> getUsers(){
        return Arrays.asList(ROMAN.name, SERGEY_IVAN.name, VLADZIMIR.name, HELEN_BENETT.name,
                YOSHI.name,GIOVANNI.name);
    }

    public static List<String> getDescriptions(){
        return Arrays.asList(LOREM.name, LOREM.name, LOREM.name, LOREM_DESC.name, LOREM_DESC.name, LOREM_DESC.name);
    }

    public static List<String> getStatus(){
        return Arrays.asList(ADMIN.name, USER.name, MANAGER.name);
    }

}
