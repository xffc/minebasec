package fun.xffc.coding;

import fun.xffc.Main;
import fun.xffc.coding.blocks.Event;
import fun.xffc.coding.blocks.Handler;
import fun.xffc.coding.values.Variable;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Code {
    @Getter
    private final List<Handler> handlers;

    private transient final List<Variable<?>> globalVariables;

    public Code(List<Handler> handlers, List<Variable<?>> globalVariables) {
        this.handlers = handlers;
        this.globalVariables = globalVariables;
    }

    public void run(int id, Event event, Plugin plugin) {
        if (handlers.get(id) == null) {
            Main.logger.warning("Can't run code with id " + id + " because there's no handler with that id!");
            return;
        }

        new CodeRunner(handlers.get(id), event, List.of(), globalVariables).runTaskAsynchronously(plugin);
    }
}
