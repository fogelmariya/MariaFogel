package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.ColorsEnum.COLOR;
import static enums.ColorsEnum.RED;
import static enums.ElementsEnum.FIRE;
import static enums.ElementsEnum.WATER;
import static enums.MetalsColorsEnum.*;
import static enums.MetalsEnum.SELEN;
import static enums.VegetablesEnum.CUCUMBER;
import static enums.VegetablesEnum.TOMATO;

// TODO Lombok ?
@AllArgsConstructor
@NoArgsConstructor
public class MetalsColorsData extends DataClass {

    public static MetalsColorsData DEFAULT = new MetalsColorsData(Arrays.asList(3, 8), new String[]{WATER.text, FIRE.text}, RED.text,
            SELEN.text, new String[]{CUCUMBER.text, TOMATO.text});

    // TODO it will be better with List
    public List<Integer> summary;
    public String[] elements;

    public String colors;

    public String metals;

    public String[] vegetables;

//    public MetalsColorsData() {
//        //summary = Arrays.asList(3, 8);
//        //elements = Arrays.asList("Water", "Fire");
//        //elements = new String[]{"Water", "Fire"};
//
//        //vegetables = Arrays.asList("Cucumber", "Tomato");
//        //vegetables = new String[]{"Cucumber", "Tomato"};
//    }

    // TODO method name does not match with return data type...
    public List<String> dataToListString() {
        // TODO do you hear smth about diamond operator ?
        List<String> result = new ArrayList<>();
        // TODO this will be better with String.format
        // TODO 1. Arrays.asList("1", "2").stream().mapToInt(Integer::parseInt).sum()
        // TODO 2. summary should be List<Integer> instead of List<String>
        Integer sum = summary.get(0) + summary.get(1);
        result.add(SUMMARY.text + ": " + sum);
        // result.add(SUMMARY.text + ": " + Integer.toString(Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])));
        result.add(ELEMENTS.text + ": " + String.join(", ", elements));
        result.add(COLOR.text + ": " + colors);

        result.add(METAL.text + ": " + metals);
        result.add(VEGETABLES.text + ": " + String.join(", ", vegetables));
        // !TODO
        return result;
    }

}
