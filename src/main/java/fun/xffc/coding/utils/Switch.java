package fun.xffc.coding.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class Switch <T> {
    @Setter
    private String key;
    private final Map<String, T> values;

    public Switch(Map<String, T> values, String key) {
        this.values = values;
        this.key = key;
    }
}
