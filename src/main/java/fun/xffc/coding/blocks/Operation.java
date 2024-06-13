package fun.xffc.coding.blocks;

import fun.xffc.coding.CodeResult;
import fun.xffc.coding.blocks.types.BlockType;
import fun.xffc.coding.values.Variable;
import lombok.Getter;
import org.bukkit.entity.Entity;

import java.util.List;

@Getter
public abstract class Operation extends Block {
    private List<? extends Variable<?>> values;

    public Operation(BlockType type, List<? extends Variable<?>> variables) {
        super(type);
        this.values = variables;
    }

    public void setValues(List<Variable<?>> values) {
        this.values = values;
    }

    public abstract CodeResult run(Entity target, List<Variable<?>> localVariables, List<Variable<?>> globalVariables);
}
