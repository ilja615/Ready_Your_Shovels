package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import rys.common.Reference;
import rys.common.util.BlockType;

public class WallBlockMod extends WallBlock {
	
	public WallBlockMod(String name, BlockType type) {
		super(Block.Properties.create(type.material).hardnessAndResistance(type.hardness, type.resistance).sound(type.sound).harvestLevel(type.harvestLevel).harvestTool(type.harvestTool));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
}
