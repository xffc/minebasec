package fun.xffc.worlds.generators;

import org.bukkit.Material;
import org.bukkit.generator.WorldInfo;

import java.util.Random;

public class VoidGenerator extends AbstractGenerator {
    public VoidGenerator(int radius) {
        super(radius, radius);
    }

    @Override
    public void generate(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        if (chunkX == 0 && chunkZ == 0) {
            int minHeight = 0;

            chunkData.setBlock(0, minHeight, 0, Material.STONE);
            chunkData.setBlock(0, minHeight, -1, Material.STONE);
            chunkData.setBlock(-1, minHeight, 0, Material.STONE);
            chunkData.setBlock(-1, minHeight, -1, Material.STONE);
        }
    }
}