package group.rys.common.item;

import group.rys.core.util.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroup extends ItemGroup {
	
	public ModItemGroup() {
		super(Reference.MOD_ID);
	}
	
	public ItemStack createIcon() {
		return new ItemStack(Items.GOLD_NUGGET);
	}
	
}
