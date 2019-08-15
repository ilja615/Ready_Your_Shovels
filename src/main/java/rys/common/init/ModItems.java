package rys.common.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.Reference;
import rys.common.item.BlockItemMod;
import rys.common.item.FoodItem;
import rys.common.item.ItemMod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
	
	public static final ItemMod peat = new ItemMod("peat");
	
	public static final FoodItem orange = new FoodItem("orange", ModFoods.orange);
	public static final FoodItem apricot = new FoodItem("apricot", ModFoods.apricot);
	public static final FoodItem rotten_orange = new FoodItem("rotten_orange", ModFoods.rotten_orange);
	public static final FoodItem rotten_apricot = new FoodItem("rotten_apricot", ModFoods.rotten_apricot);
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(new BlockItemMod(ModBlocks.tough_dirt));
		registry.register(new BlockItemMod(ModBlocks.dirt_bricks));
		registry.register(new BlockItemMod(ModBlocks.smooth_dirt));
		registry.register(new BlockItemMod(ModBlocks.regolith));
		registry.register(new BlockItemMod(ModBlocks.clay_deposit));
		registry.register(new BlockItemMod(ModBlocks.peat_deposit));
		registry.register(new BlockItemMod(ModBlocks.iron_deposit));
		registry.register(new BlockItemMod(ModBlocks.gold_deposit));
		registry.register(new BlockItemMod(ModBlocks.tough_dirt_slab));
		registry.register(new BlockItemMod(ModBlocks.tough_dirt_stairs));
		registry.register(new BlockItemMod(ModBlocks.tough_dirt_wall));
		registry.register(new BlockItemMod(ModBlocks.dirt_bricks_slab));
		registry.register(new BlockItemMod(ModBlocks.dirt_bricks_stairs));
		registry.register(new BlockItemMod(ModBlocks.dirt_bricks_wall));
		registry.register(new BlockItemMod(ModBlocks.smooth_dirt_slab));
		registry.register(new BlockItemMod(ModBlocks.smooth_dirt_stairs));
		
		registry.register(peat);
		registry.register(orange);
		registry.register(apricot);
		registry.register(rotten_orange);
		registry.register(rotten_apricot);
	}
	
}
