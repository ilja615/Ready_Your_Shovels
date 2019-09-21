package rys.common.util;

import net.minecraft.block.ComposterBlock;
import rys.common.item.ModItems;

public class ModRegistry {
	
	public static void registerComposterItems() {
		ComposterBlock.registerCompostable(0.5F, ModItems.dayroot);
		ComposterBlock.registerCompostable(0.65F, ModItems.orange);
		ComposterBlock.registerCompostable(0.65F, ModItems.apricot);
		ComposterBlock.registerCompostable(0.65F, ModItems.rotten_orange);
		ComposterBlock.registerCompostable(0.65F, ModItems.rotten_apricot);
	}
	
}
