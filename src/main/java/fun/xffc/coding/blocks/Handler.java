package fun.xffc.coding.blocks;

import fun.xffc.coding.blocks.types.BlockType;
import lombok.Getter;

import java.util.List;

public abstract class Handler extends Block {
    @Getter
    private final List<Operation> operations;
    public int position;

    public Handler(BlockType type, List<Operation> operations, int position) {
        super(type);
        this.operations = operations;
        this.position = position;
    }
}
