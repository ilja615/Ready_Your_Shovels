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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;

public class CaveDiversityFeature extends Feature<ReplaceBlockConfig> {
	
	public CaveDiversityFeature(Function<Dynamic<?>, ? extends ReplaceBlockConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, ReplaceBlockConfig config) {
		int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY();
		
		for (int n = 0; n < 4; n++) {
			int x = rand.nextInt(16);
			int z = rand.nextInt(16);
			int y = rand.nextInt(20);
			
			this.tryPlace(worldIn, rand, pos.add(x, surfaceY - y, z), config.state, config.target);
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, Random random, BlockPos pos, BlockState state, BlockState target) {
		for (int x = 0; x < 8; x++) {
			for (int z = 0; z < 8; z++) {
				for (int y = 0; y < 8; y++) {
					BlockPos pos_n = pos.add(x - 4, y - 4, z - 4);
					
					if (random.nextFloat() < 0.5F && pos.distanceSq(pos_n) < 16 && world.getBlockState(pos_n).getBlock() == target.getBlock()) {
						this.setBlockState(world, pos_n, state);
					}
				}
			}
		}
	}
}
