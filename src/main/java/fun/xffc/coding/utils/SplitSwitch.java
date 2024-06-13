package fun.xffc.coding.utils;

import java.util.Map;

public class SplitSwitch extends Switch<String> {
    public SplitSwitch() {
        super(Map.of(
                "No split", "",
                "Space split", " ",
                "New line split", "\n"
        ), "No split");
    }
}
