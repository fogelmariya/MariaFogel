package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.ColorsEnum.COLOR;
import static enums.MetalsColorsEnum.*;

@AllArgsConstructor
public class MetalsColorsData extends DataClass {
    public List<Integer> summary;
    // TODO it will be better with List
    public String[] elements;

    public String colors;

    public String metals;

    // TODO and this will be better with List too
    public String[] vegetables;

    // TODO i told you that it was not really good approach to hardcode values in the constructor
    public MetalsColorsData() {
        summary = Arrays.asList(3, 8);
        //elements = Arrays.asList("Water", "Fire");
        elements = new String[]{"Water", "Fire"};
        colors = "Red";
        metals = "Selen";
        //vegetables = Arrays.asList("Cucumber", "Tomato");
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public List<String> dataToListString() {
        List<String> result = new ArrayList<>();
        // TODO this will be better with String.format x2
        // TODO 1. Arrays.asList("1", "2").stream().mapToInt(Integer::parseInt).sum() 2x
        // TODO 2. summary should be List<Integer> instead of List<String> 2x
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
