package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class StairsBlockMod extends StairsBlock {
	
	public StairsBlockMod(BlockState state) {
		super(state, Block.Properties.from(state.getBlock()));
	}
	
}
