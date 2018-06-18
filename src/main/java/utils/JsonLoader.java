package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.MetalsColorsData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonLoader {

    public Object[][] data;

    public static Object[] getData(String json) throws FileNotFoundException {
        JsonObject jsonObject = new JsonParser().parse(new FileReader(json)).getAsJsonObject();
        Map<String, MetalsColorsData> metalsColorsData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, MetalsColorsData>>() {
        }.getType());
        return metalsColorsData.values().toArray();
    }
}
