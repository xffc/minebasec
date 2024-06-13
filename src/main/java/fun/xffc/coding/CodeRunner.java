package fun.xffc.coding;

import fun.xffc.Main;
import fun.xffc.coding.blocks.Event;
import fun.xffc.coding.blocks.Handler;
import fun.xffc.coding.blocks.Operation;
import fun.xffc.coding.values.Variable;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class CodeRunner extends BukkitRunnable {
    @Getter
    private final Handler handler;
    @Getter
    private final Event event;

    private final List<Variable<?>> localVariables, globalVariables;

    public Entity currentTarget;

    public CodeRunner(Handler handler, Event event, List<Variable<?>> localVariables, List<Variable<?>> globalVariables) {
        this.handler = handler;
        this.event = event;
        this.currentTarget = event.getEventTarget();

        this.localVariables = localVariables;
        this.globalVariables = globalVariables;
    }

    @Override
    public void run() {
        for (Operation operation : this.getHandler().getOperations()) {
            CodeResult operationResult = operation.run(currentTarget, localVariables, globalVariables);

            if (operationResult.isError()) {
                Main.logger.warning("Stopped code. Error message: " + operationResult.getMessage());
                return;
            }

            this.currentTarget = operationResult.getCurrentTarget();
            this.localVariables.addAll(operationResult.getLocalVariables());
            this.globalVariables.addAll(operationResult.getGlobalVariables());
        }
    }
}
