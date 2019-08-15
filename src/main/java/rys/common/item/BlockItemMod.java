package rys.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import rys.common.Reference;

public class BlockItemMod extends BlockItem {
	
	public BlockItemMod(Block block) {
		super(block, new Item.Properties().group(Reference.MOD_ITEM_GROUP));
		this.setRegistryName(block.getRegistryName());
	}
	
}
