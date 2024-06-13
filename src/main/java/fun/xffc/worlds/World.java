package fun.xffc.worlds;

import fun.xffc.coding.Code;
import lombok.Getter;

@Getter
public class World {
    protected org.bukkit.World world;
    protected Code code;

    public World(Code code, org.bukkit.World world) {
        this.code = code;
        this.world = world;
    }

}
