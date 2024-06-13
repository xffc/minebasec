package fun.xffc.worlds;

import fun.xffc.coding.Code;
import fun.xffc.coding.GsonParser;
import fun.xffc.coding.values.Variable;
import fun.xffc.worlds.generators.VoidGenerator;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.WorldCreator;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Getter
public class WorldManager {
    protected List<World> loadedWorlds;

    @SneakyThrows
    public World loadWorld(UUID uuid) {
        org.bukkit.World mcWorld = WorldCreator
                .name(uuid.toString())
                .generator(new VoidGenerator(1))
                .createWorld();
        assert mcWorld != null;

        File folder = mcWorld.getWorldFolder();
        File codeFile = new File(folder, "code.json");
        File globalVariables = new File(folder, "globalvars.json");

        Code code;
        List<Variable<?>> variables = List.of();

        if (globalVariables.exists()) GsonParser.fromJson(globalVariables, variables.getClass());
        else globalVariables.createNewFile();

        if (!codeFile.exists()) {
            code = new Code(List.of(), variables);
            codeFile.createNewFile();
        }
        else code = GsonParser.fromJson(codeFile, Code.class);

        World world = new World(code, mcWorld);
        loadedWorlds.add(world);
        return world;
    }
}
