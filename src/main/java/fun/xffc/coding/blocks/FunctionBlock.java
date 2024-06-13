package fun.xffc.coding.blocks;

import fun.xffc.coding.blocks.types.BlockType;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class FunctionBlock extends Handler {
    private final String name;

    public FunctionBlock(String name, List<Operation> operations, int position) {
        super(BlockType.FUNCTION, operations, position);
        this.name = name;
    }

}
