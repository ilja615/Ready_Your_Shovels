package rys.common.item;

import net.minecraft.item.Item;
import rys.common.util.Reference;

public class ModItemProperties {
	
	public static final Item.Properties item = new Item.Properties().group(Reference.MOD_ITEM_GROUP);
	public static final Item.Properties orange = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.orange);
	public static final Item.Properties apricot = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.apricot);
	public static final Item.Properties rotten_orange = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.rotten_orange);
	public static final Item.Properties rotten_apricot = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.rotten_apricot);
	
}
