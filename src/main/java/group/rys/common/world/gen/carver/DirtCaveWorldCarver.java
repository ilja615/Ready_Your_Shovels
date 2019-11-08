package group.rys.common.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import group.rys.core.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.common.BiomeDictionary;

public class DirtCaveWorldCarver extends WorldCarver<ProbabilityConfig> {
	
	public DirtCaveWorldCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49921_1_, int p_i49921_2_) {
		super(p_i49921_1_, p_i49921_2_);
	}
	
	public boolean carve(IChunk chunkIn, Random rand, int seaLevel, int chunkX, int chunkZ, int p_212867_6_, int p_212867_7_, BitSet carvingMask, ProbabilityConfig config) {
		BlockPos pos = new BlockPos(chunkX, 0, chunkZ);
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				
				Biome biome = chunkIn.getBiome(pos.add(x, 0, z));
				
				if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLATEAU) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) {
					int surfaceY = chunkIn.getTopBlockY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, chunkX + x, chunkZ + z) - 1;
					
					for (int y = surfaceY - 20; y < surfaceY; y++) {
						this.tryPlace(chunkIn, pos.add(x, y, z));
					}
				}
				
			}
		}
		
		return true;
	}
	
	public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
		return true;
	}
	
	protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
		return true;
	}
	
	private void tryPlace(IChunk chunkIn, BlockPos pos) {
		BlockState state = chunkIn.getBlockState(pos);
		Block block = state.getBlock();
		
		if (Block.isRock(block)) {
			chunkIn.setBlockState(pos, ModBlocks.tough_dirt.getDefaultState(), false);
		}
		if (block == Blocks.COAL_ORE) {
			chunkIn.setBlockState(pos, ModBlocks.peat_deposit.getDefaultState(), false);
		}
		if (block == Blocks.IRON_ORE) {
			chunkIn.setBlockState(pos, ModBlocks.iron_deposit.getDefaultState(), false);
		}
		if (block == Blocks.GOLD_ORE) {
			chunkIn.setBlockState(pos, ModBlocks.gold_deposit.getDefaultState(), false);
		}
	}
	
}
