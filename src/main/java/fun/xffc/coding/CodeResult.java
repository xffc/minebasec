package fun.xffc.coding;

import fun.xffc.coding.values.Variable;
import fun.xffc.utils.Result;
import lombok.Getter;
import org.bukkit.entity.Entity;

import java.util.List;

@Getter
public class CodeResult extends Result {
    private final Entity currentTarget;
    private final List<Variable<?>> localVariables, globalVariables;

    public CodeResult(String message, boolean isError, Entity currentTarget, List<Variable<?>> localVariables, List<Variable<?>> globalVariables) {
        super(message, isError);
        this.currentTarget = currentTarget;
        this.localVariables = localVariables;
        this.globalVariables = globalVariables;
    }

}
