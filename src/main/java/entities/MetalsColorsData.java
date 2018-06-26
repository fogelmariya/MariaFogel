package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

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

//@AllArgsConstructor
public class MetalsColorsData extends DataClass {

    public List<Integer> summary;
    // TODO it will be better with List
    public List<String> elements;

    public String colors;

    public String metals;

    // TODO and this will be better with List too
    public List<String> vegetables;

    public static MetalsColorsData DEFAULT_DATA = new MetalsColorsData(new Integer[]{3, 8}, new String[]{WATER.text, FIRE.text},
            new String[]{RED.text}, new String[]{SELEN.text}, new String[]{CUCUMBER.text, TOMATO.text});

    public MetalsColorsData(Integer[] summary, String[] elements, String[] color, String[] metals, String[] vegetables) {
        this.summary = Arrays.asList(summary);
        this.elements = Arrays.asList(elements);
        this.colors = color[0];
        this.metals = metals[0];
        this.vegetables = Arrays.asList(vegetables);
    }

    // TODO i told you that it was not really good approach to hardcode values in the constructor

    public List<String> dataToListString() {
        List<String> result = new ArrayList<>();
        // TODO this will be better with String.format x2
        // TODO 1. Arrays.asList("1", "2").stream().mapToInt(Integer::parseInt).sum() 2x
        // TODO 2. summary should be List<Integer> instead of List<String> 2x
        Integer sum = summary.get(0) + summary.get(1);
        result.add(SUMMARY.text + ": " + sum);
        result.add(ELEMENTS.text + ": " + String.join(", ", elements));
        result.add(COLOR.text + ": " + colors);

        result.add(METAL.text + ": " + metals);
        result.add(VEGETABLES.text + ": " + String.join(", ", vegetables));
        // !TODO
        return result;
    }

}
