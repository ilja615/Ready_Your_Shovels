package rys.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import rys.common.item.ModItemGroup;

public class Reference {
	
	public static final String MOD_ID = "rys";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup();
	
}
