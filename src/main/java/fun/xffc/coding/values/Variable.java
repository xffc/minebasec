package fun.xffc.coding.values;

import lombok.Getter;
import lombok.Setter;

public abstract class Variable <T> {
    @Setter
    @Getter
    private T value;
    public final String type;

    public Variable(T value, String type) {
        this.value = value;
        this.type = type;
    }
}
