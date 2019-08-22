package rys.common.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import rys.common.util.Reference;

public class FoodItem extends Item {
	
	public FoodItem(String name, Food food) {
		super(new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(food));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
}
