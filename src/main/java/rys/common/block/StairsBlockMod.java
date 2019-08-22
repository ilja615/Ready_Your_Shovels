package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import rys.common.util.BlockType;
import rys.common.util.Reference;

public class StairsBlockMod extends StairsBlock {
	
	public StairsBlockMod(String name, BlockType type, BlockState state) {
		super(state, Block.Properties.create(type.material).hardnessAndResistance(type.hardness, type.resistance).sound(type.sound).harvestLevel(type.harvestLevel).harvestTool(type.harvestTool));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
}
