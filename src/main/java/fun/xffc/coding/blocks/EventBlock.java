package fun.xffc.coding.blocks;

import fun.xffc.coding.blocks.types.BlockType;
import fun.xffc.coding.blocks.types.Event;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class EventBlock extends Handler {
    private final Event event;

    public EventBlock(Event event, List<Operation> operations, int position) {
        super(BlockType.EVENT, operations, position);
        this.event = event;
    }
}
