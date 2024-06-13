package fun.xffc.coding.blocks;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

@Getter
public class Event {
    private final Entity eventTarget;
    private Entity killerTarget, victimTarget;

    public Event(Entity eventTarget, @Nullable Entity killerTarget, @Nullable Entity victimTarget) {
        this.eventTarget = eventTarget;
        if (killerTarget != null) this.killerTarget = killerTarget;
        if (victimTarget != null) this.victimTarget = victimTarget;
    }

}
