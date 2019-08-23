package rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import rys.common.block.ModBlocks;

public class CaveFeature extends Feature<NoFeatureConfig> {
	
	public CaveFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49914_1_) {
		super(p_i49914_1_);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				
				int surfaceY = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
				
				for (int y = (surfaceY - 32); y < (surfaceY + 32); y++) {
					this.tryPlace(worldIn, new BlockPos(x + pos.getX(), y, z + pos.getZ()));
				}
				
				this.tryPlaceLayer(worldIn, rand, new BlockPos(x + pos.getX(), surfaceY - 32, z + pos.getZ()));
				
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		BlockPos[] arrayOfPos = new BlockPos[] { new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 0), new BlockPos(-1, -1, 1), new BlockPos(0, -1, -1), new BlockPos(0, -1, 0), new BlockPos(0, -1, 1), new BlockPos(1, -1, -1), new BlockPos(1, -1, 0), new BlockPos(1, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 0), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, 1, 0), new BlockPos(0, 1, 1), new BlockPos(1, 1, -1), new BlockPos(1, 1, 0), new BlockPos(1, 1, 1) };
		
		for (BlockPos posInArray : arrayOfPos) {
			if (world.isAirBlock(pos.add(posInArray))) {
				if (this.isStone(state)) {
					this.setBlockState(world, pos, ModBlocks.tough_dirt.getDefaultState());
				}
				if (state.getBlock() == Blocks.COBBLESTONE) {
					this.setBlockState(world, pos, ModBlocks.regolith.getDefaultState());
				}
				if (state.getBlock() == Blocks.COAL_ORE) {
					this.setBlockState(world, pos, ModBlocks.peat_deposit.getDefaultState());
				}
				if (state.getBlock() == Blocks.IRON_ORE) {
					this.setBlockState(world, pos, ModBlocks.iron_deposit.getDefaultState());
				}
				if (state.getBlock() == Blocks.GOLD_ORE) {
					this.setBlockState(world, pos, ModBlocks.gold_deposit.getDefaultState());
				}
			}
		}
	}
	
	private void tryPlaceLayer(IWorld world, Random random, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		
		if (state.getBlock() == ModBlocks.tough_dirt) {
			this.setBlockState(world, pos.add(0, (random.nextInt(2) - random.nextInt(2)), 0), ModBlocks.regolith.getDefaultState());
			this.setBlockState(world, pos.add(0, (random.nextInt(2) - random.nextInt(2) + 1), 0), ModBlocks.regolith.getDefaultState());
			this.setBlockState(world, pos.add(0, (random.nextInt(2) - random.nextInt(2) + 2), 0), ModBlocks.regolith.getDefaultState());
		}
	}
	
	private boolean isStone(BlockState state) {
		Block block = state.getBlock();
		return block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
	}
	
}
