package fun.xffc.worlds.generators;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

// thanks to @mrartur4ik (developer of artgame)
public abstract class AbstractGenerator extends ChunkGenerator {
    protected final int sizeX, sizeZ;

    public AbstractGenerator(int sizeX, int sizeZ) {
        this.sizeX = sizeX;
        this.sizeZ = sizeZ;
    }

    @Override
    public Location getFixedSpawnLocation(World world, @NotNull Random random) {
        if (world.isChunkLoaded(0, 0)) {
            world.loadChunk(0, 0);
        }

        int highestBlock = world.getHighestBlockYAt(0, 0);
        int minHeight = world.getMinHeight();

        if (highestBlock <= minHeight && world.getBlockAt(0, minHeight, 0).getType() == Material.AIR) {
            return new Location(world, 0.0, -60.0, 0.0);
        }

        return new Location(world, 0.0, (highestBlock + 1), 0.0);
    }

    @Override
    public void generateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
        if ((chunkX >= 0 && chunkX <= sizeX) && (chunkZ >= 0 && chunkZ <= sizeZ)) {
            generate(worldInfo, random, chunkX, chunkZ, chunkData);
        }
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return new BiomeProvider() {
            @Override
            public @NotNull Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
                return Biome.THE_VOID;
            }

            @Override
            public @NotNull List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
                return List.of(Biome.THE_VOID);
            }
        };
    }

    public abstract void generate(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunk);
}