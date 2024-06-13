package fun.xffc.coding.blocks;

import fun.xffc.coding.blocks.types.BlockType;
import lombok.Getter;

@Getter
public abstract class Block {
    private final BlockType type;

    public Block(BlockType type) {
        this.type = type;
    }

}
