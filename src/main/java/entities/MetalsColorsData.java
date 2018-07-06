package entities;

import com.epam.commons.DataClass;

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

public class MetalsColorsData extends DataClass {

    public List<Integer> summary;

    public List<String> elements;

    public String colors;

    public String metals;

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

    public List<String> dataToListString() {
        List<String> result = new ArrayList<>();
        //Integer sum = summary.get(0) + summary.get(1);
        result.add(SUMMARY.text + ": " + summary.stream().mapToInt(Integer::intValue).sum());
        result.add(ELEMENTS.text + ": " + String.join(", ", elements));
        result.add(COLOR.text + ": " + colors);

        result.add(METAL.text + ": " + metals);
        result.add(VEGETABLES.text + ": " + String.join(", ", vegetables));
        return result;
    }

}
