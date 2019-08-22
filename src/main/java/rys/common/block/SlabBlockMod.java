package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import rys.common.util.BlockType;
import rys.common.util.Reference;

public class SlabBlockMod extends SlabBlock {
	
	public SlabBlockMod(String name, BlockType type) {
		super(Block.Properties.create(type.material).hardnessAndResistance(type.hardness, type.resistance).sound(type.sound).harvestLevel(type.harvestLevel).harvestTool(type.harvestTool));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
}
