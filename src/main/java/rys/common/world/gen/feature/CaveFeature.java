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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import rys.common.init.ModBlocks;
import rys.common.util.EntryList;
import rys.common.util.Reference;

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
		Reference.LOGGER.info("CaveFeature.place()");
		
		if (pos.getY() > 56 && pos.getY() < 72) {
			this.tryPlace(worldIn, pos);
		}
		
		return true;
	}
	
	private void tryPlace(IWorld worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		
		Reference.LOGGER.info("CaveFeature.tryPlace()");
		
		if (this.isStone(state)) {
			this.setBlockState(worldIn, pos, this.getRandomBlock(worldIn));
			Reference.LOGGER.info("CaveFeature.setBlockState() " + state.getBlock().getRegistryName().toString());
		}
	}
	
	private boolean isStone(BlockState stateIn) {
		Block block = stateIn.getBlock();
		return block == Blocks.COBBLESTONE || block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
	}
	
	private BlockState getRandomBlock(IWorld worldIn) {
		return this.blockList.getRandom().getDefaultState();
	}
	
}
