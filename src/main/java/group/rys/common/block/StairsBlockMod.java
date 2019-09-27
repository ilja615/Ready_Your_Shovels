package group.rys.common.block;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class StairsBlockMod extends StairsBlock {
	
	public StairsBlockMod(Supplier<BlockState> state, Properties properties) {
		super(state, properties);
	}
	
}
