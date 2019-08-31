package rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class DepositsInCavesFeature extends Feature<NoFeatureConfig> {
	
	public DepositsInCavesFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos.add(x, 0, z)).getY();
				
				Biome biome = worldIn.getBiome(pos.add(x, 0, z));
				String name = biome.getRegistryName().toString();
				
				if (!name.contains("river")) {
					for (int y = surfaceY - 32; y < surfaceY; y++) {
						this.tryPlace(worldIn, pos.add(x, y, z));
					}
				}
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		
	}
}
