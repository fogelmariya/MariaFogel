package entities;

import com.epam.commons.DataClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.ColorsEnum.COLOR;
import static enums.MetalsColorsEnum.*;

// TODO Lombok ?
public class MetalsColorsData extends DataClass {
    // TODO it will be better with List
    public String[] summary;
    public String[] elements;

    public String colors;

    public String metals;

    public String[] vegetables;

    public MetalsColorsData() {
        summary = new String[]{"3", "8"};
        elements = new String[]{"Water", "Fire"};
        colors = "Red";
        metals = "Selen";
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public MetalsColorsData(String[] summary, String[] elements, String colors, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    // TODO method name does not match with return data type...
    public List<String> dataToString() {
        // TODO do you hear smth about diamond operator ?
        List<String> result = new ArrayList<String>();
        // TODO this will be better with String.format
        // TODO 1. Arrays.asList("1", "2").stream().mapToInt(Integer::parseInt).sum()
        // TODO 2. summary should be List<Integer> instead of List<String>
        result.add(SUMMARY.text + ": " + Integer.toString(Integer.parseInt(summary[0]) + Integer.parseInt(summary[1])));
        result.add(ELEMENTS.text + ": " + String.join(", ", elements));
        result.add(COLOR.text + ": " + colors);

        result.add(METAL.text + ": " + metals);
        result.add(VEGETABLES.text + ": " + String.join(", ", vegetables));
        // !TODO
        return result;
    }

}