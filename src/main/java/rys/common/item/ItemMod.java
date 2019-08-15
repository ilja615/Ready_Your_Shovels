package rys.common.item;

import net.minecraft.item.Item;
import rys.common.Reference;

public class ItemMod extends Item {
	
	public ItemMod(String name) {
		super(new Item.Properties().group(Reference.MOD_ITEM_GROUP));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
}
