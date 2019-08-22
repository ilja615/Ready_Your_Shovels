package rys.common.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rys.common.util.Reference;

public class ModItemGroup extends ItemGroup {
	
	public ModItemGroup() {
		super(Reference.MOD_ID);
	}
	
	public ItemStack createIcon() {
		return new ItemStack(Items.GOLD_NUGGET);
	}
	
}
