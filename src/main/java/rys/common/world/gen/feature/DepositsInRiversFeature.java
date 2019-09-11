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

public class DepositsInRiversFeature extends Feature<ReplaceBlockConfig> {
	
	private static BlockPos[] arrayOfPos = new BlockPos[] { new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 0), new BlockPos(-1, -1, 1), new BlockPos(0, -1, -1), new BlockPos(0, -1, 0), new BlockPos(0, -1, 1), new BlockPos(1, -1, -1), new BlockPos(1, -1, 0), new BlockPos(1, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 0), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, 1, 0), new BlockPos(0, 1, 1), new BlockPos(1, 1, -1), new BlockPos(1, 1, 0), new BlockPos(1, 1, 1) };
	
	public DepositsInRiversFeature(Function<Dynamic<?>, ? extends ReplaceBlockConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, ReplaceBlockConfig config) {
		int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY();
		
		if (rand.nextFloat() < 0.5F) {
			for (int n = 0; n < 16; n++) {
				int x = rand.nextInt(16);
				int z = rand.nextInt(16);
				int y = rand.nextInt(20);
				
				this.tryPlace(worldIn, rand, pos.add(x, surfaceY - y, z), config.state, config.target);
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, Random random, BlockPos pos, BlockState state, BlockState target) {
		for (int x = 0; x < 4; x++) {
			for (int z = 0; z < 4; z++) {
				for (int y = 0; y < 4; y++) {
					BlockPos pos_n = pos.add(x - 2, y - 2, z - 2);
					
					if (random.nextFloat() < 0.5F) {
						if (pos.distanceSq(pos_n) < 16) {
							if (world.getBlockState(pos_n).getBlock() == target.getBlock()) {
								this.trySetBlockState(world, pos_n, state);
							}
						}
					}
				}
			}
		}
	}
	
	private void trySetBlockState(IWorld world, BlockPos pos, BlockState state) {
		for (BlockPos posInArray : arrayOfPos) {
			if (world.hasWater(pos.add(posInArray))) {
				this.setBlockState(world, pos, state);
			}
		}
	}
	
}
