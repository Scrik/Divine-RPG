package net.divinerpg.overworld.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOverworld implements IWorldGenerator {
	@Override
	public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6) {
		switch(var4.provider.dimensionId) {
		case 0:
			this.generateSurface(var4, var1, var2 * 16, var3 * 16);
		default:
		}
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
		WorldGenDivineTrees tree = new WorldGenDivineTrees();

		if((biome instanceof BiomeGenForest)) {
			for(int x = 0; x < 3; x++) {
				int i = chunkX + rand.nextInt(16);
				int k = chunkZ + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				tree.generate(world, rand, i, j, k);
			}
		}

		for(int k = 0; k < 3; k++) {

			int Xcoord = chunkX + rand.nextInt(16);
			int Ycoord = rand.nextInt(80);
			int Zcoord = chunkZ + rand.nextInt(16);

			(new WorldGenSpawner()).generate(world, rand, Xcoord, Ycoord, Zcoord);
		}
	}
}
