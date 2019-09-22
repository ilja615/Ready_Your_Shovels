package group.rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import group.rys.common.block.DayrootBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

public class DayrootFeature extends Feature<SphereConfig> {
	
	public DayrootFeature(Function<Dynamic<?>, ? extends SphereConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, SphereConfig config) {
		for (int x = 0; x < config.radius * 2; x++) {
			for (int z = 0; z < config.radius * 2; z++) {
				for (int y = 0; y < config.radius * 2; y++) {
					BlockPos pos_1 = pos.add(x - config.radius, y - config.radius, z - config.radius);
					
					if (rand.nextFloat() < config.integrity && pos.distanceSq(pos_1) < config.radius * config.radius && config.state.isValidPosition(worldIn, pos_1) && worldIn.isAirBlock(pos_1) && worldIn.isAirBlock(pos_1.down())) {
						((DayrootBlock) config.state.getBlock()).placeAt(worldIn, pos_1, 2);
					}
				}
			}
		}
		
		return true;
	}
	
}
