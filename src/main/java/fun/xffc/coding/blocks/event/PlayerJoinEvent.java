package fun.xffc.coding.blocks.event;

import fun.xffc.coding.blocks.EventBlock;
import fun.xffc.coding.blocks.Operation;
import fun.xffc.coding.blocks.types.Event;

import java.util.List;

public class PlayerJoinEvent extends EventBlock {
    public PlayerJoinEvent(List<Operation> operations, int position) {
        super(Event.PLAYER_JOIN, operations, position);
    }
}
