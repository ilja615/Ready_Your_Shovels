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
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import rys.common.block.ModBlocks;

public class GradientFeature extends Feature<NoFeatureConfig> {
	
	private static BlockPos[] arrayOfPos = new BlockPos[] { new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 0), new BlockPos(-1, -1, 1), new BlockPos(0, -1, -1), new BlockPos(0, -1, 0), new BlockPos(0, -1, 1), new BlockPos(1, -1, -1), new BlockPos(1, -1, 0), new BlockPos(1, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 0), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, 1, 0), new BlockPos(0, 1, 1), new BlockPos(1, 1, -1), new BlockPos(1, 1, 0), new BlockPos(1, 1, 1) };
	
	public GradientFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos.add(x, 0, z)).getY();
				
				Biome biome = worldIn.getBiome(pos.add(x, 0, z));
				String name = biome.getRegistryName().toString();
				
				if (name.contains("mountains") || name.contains("stone")) {
					this.tryPlace(worldIn, pos.add(x, surfaceY - 1, z));
				}
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		
		if (state.getBlock() == Blocks.GRASS_BLOCK) {
			for (int y = 0; y < pos.getY(); y++) {
				if (world.getBlockState(pos.down(y)).isIn(Tags.Blocks.STONE)) {
					this.trySetBlockState(world, pos.down(y), ModBlocks.tough_dirt.getDefaultState());
					
					if (world.getBlockState(pos.down(y + 1)).isIn(Tags.Blocks.STONE)) {
						this.trySetBlockState(world, pos.down(y + 1), ModBlocks.regolith.getDefaultState());
					}
					
					break;
				}
				
				if (world.isAirBlock(pos.down(y))) {
					break;
				}
			}
		}
	}
	
	private void trySetBlockState(IWorld world, BlockPos pos, BlockState state) {
		for (BlockPos posInArray : arrayOfPos) {
			if (world.isAirBlock(pos.add(posInArray))) {
				this.setBlockState(world, pos, state);
			}
		}
	}
	
}
