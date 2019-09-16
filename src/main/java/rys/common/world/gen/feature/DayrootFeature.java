package rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import rys.common.block.DayrootBlock;

public class DayrootFeature extends Feature<BushConfig> {
	
	public DayrootFeature(Function<Dynamic<?>, ? extends BushConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BushConfig config) {
		int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY();
		
		if (rand.nextFloat() < 0.5F) {
			for (int n = 0; n < 64; n++) {
				int x = rand.nextInt(16);
				int z = rand.nextInt(16);
				int y = rand.nextInt(20);
				
				this.tryPlace(worldIn, rand, pos.add(x, surfaceY - y, z), config.state);
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, Random random, BlockPos pos, BlockState state) {
		for (int x = 0; x < 2; x++) {
			for (int z = 0; z < 2; z++) {
				for (int y = 0; y < 2; y++) {
					BlockPos pos_n = pos.add(x, y, z);
					
					if (random.nextFloat() < 0.5F) {
						if (world.isAirBlock(pos_n) && world.isAirBlock(pos_n.down()) && state.isValidPosition(world, pos_n)) {
							((DayrootBlock) state.getBlock()).placeAt(world, pos_n, 2);
						}
					}
				}
			}
		}
	}
	
}
