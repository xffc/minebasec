package fun.xffc.coding.blocks.action;

import fun.xffc.coding.CodeResult;
import fun.xffc.coding.blocks.Operation;
import fun.xffc.coding.utils.SplitSwitch;
import fun.xffc.coding.blocks.types.BlockType;
import fun.xffc.coding.values.Text;
import fun.xffc.coding.values.Variable;
import org.bukkit.entity.Entity;

import java.util.List;

public class SendMessage extends Operation {
    public SplitSwitch splitter;

    public SendMessage(List<Text> texts) {
        super(BlockType.OPERATION, texts);
    }

    @Override
    public CodeResult run(Entity target, List<Variable<?>> codeVariables, List<Variable<?>> localVariables) {
        splitter.getValues().get(splitter.getKey());
        return new CodeResult("ok", false, target, List.of(), List.of());
    }
}
