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
import rys.common.init.ModBlocks;
import rys.common.util.EntryList;

public class CaveFeature extends Feature<NoFeatureConfig> {
	
	private EntryList<Block> blockList = new EntryList<Block>()
			.addEntry(ModBlocks.tough_dirt, 120)
			.addEntry(ModBlocks.regolith, 57)
			.addEntry(ModBlocks.clay_deposit, 26)
			.addEntry(ModBlocks.peat_deposit, 11)
			.addEntry(ModBlocks.iron_deposit, 4)
			.addEntry(ModBlocks.gold_deposit, 1);
	
	public CaveFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49914_1_) {
		super(p_i49914_1_);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int j = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
		
		for (int x = pos.getX(); x < pos.getX() + 16; x++) {
			for (int z = pos.getZ(); z < pos.getZ() + 16; z++) {
				for (int y = (j - 16); y < (j + 16); y++) {
					this.tryPlace(worldIn, new BlockPos(x, y, z));
				}
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		
		if (this.isStone(state)) {
			this.setBlockState(worldIn, pos, this.getRandomBlock());
		}
	}
	
	private boolean isStone(BlockState stateIn) {
		Block block = stateIn.getBlock();
		return block == Blocks.COBBLESTONE || block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
	}
	
	private BlockState getRandomBlock() {
		return this.blockList.getRandom().getDefaultState();
	}
	
}
