package fun.xffc.coding;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;

public class GsonParser {
    private static final Gson gson = new Gson();

    public static <T> T fromJson(String json, Class<? extends T> clazz) {
        return gson.fromJson(json, clazz);
    }

    @lombok.SneakyThrows
    public static <T> T fromJson(File file, Class<? extends T> clazz) {
        return gson.fromJson(new FileReader(file), clazz);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
