package fun.xffc.utils;

import lombok.Getter;

public class Result {
    @Getter
    private final String message;
    private final boolean isError;

    public Result(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }

    public boolean isError() {
        return isError;
    }
}
