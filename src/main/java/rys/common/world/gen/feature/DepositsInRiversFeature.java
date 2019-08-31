package rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class DepositsInRiversFeature extends Feature<OreFeatureConfig> {
	
	public DepositsInRiversFeature(Function<Dynamic<?>, ? extends OreFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, OreFeatureConfig config) {
		int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY();
		
		Biome biome = worldIn.getBiome(pos);
		String name = biome.getRegistryName().toString();
		
		if (name.contains("river")) {
			if (rand.nextFloat() < 0.5F) {
				for (int n = 0; n < 64; n++) {
					int x = rand.nextInt(16);
					int z = rand.nextInt(16);
					int y = rand.nextInt(32);
					
					this.tryPlace(worldIn, rand, pos.add(x, surfaceY - y, z), config.state);
				}
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, Random random, BlockPos pos, BlockState state) {
		for (int x = 0; x < 4; x++) {
			for (int z = 0; z < 4; z++) {
				BlockPos pos_n = pos.add(x, 0, z);
				
				if (random.nextFloat() < 0.5F) {
					if (world.getBlockState(pos_n).getBlock() == Blocks.DIRT && world.hasWater(pos_n.up())) {
						this.setBlockState(world, pos_n, state);
					}
				}
			}
		}
	}
	
}
