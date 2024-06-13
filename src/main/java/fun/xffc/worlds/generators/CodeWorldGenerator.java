package fun.xffc.worlds.generators;

import org.bukkit.generator.WorldInfo;

import java.util.Random;

public class CodeWorldGenerator extends AbstractGenerator {
    protected final int distBetweenLines;

    public CodeWorldGenerator(int distBetweenLines, int length, int lineLength) {
        super(length, lineLength);

        this.distBetweenLines = distBetweenLines;
    }

    @Override
    public void generate(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        // TODO: Make code world generator

        if (chunkZ == 0) {
            /*
            for (i in range(16 / distBetweenLines)) distBetweenLines must be >=2, 4, 6, 8
             setblock(i*distBetweenLines, eventblock)
             */
        }
    }
}
