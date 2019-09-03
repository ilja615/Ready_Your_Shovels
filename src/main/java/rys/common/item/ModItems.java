package rys.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.block.ModBlocks;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
	
	public static final BlockItem tough_dirt = create(ModBlocks.tough_dirt);
	public static final BlockItem dirt_bricks = create(ModBlocks.dirt_bricks);
	public static final BlockItem smooth_dirt = create(ModBlocks.smooth_dirt);
	public static final BlockItem regolith = create(ModBlocks.regolith);
	public static final BlockItem clay_deposit = create(ModBlocks.clay_deposit);
	public static final BlockItem peat_deposit = create(ModBlocks.peat_deposit);
	public static final BlockItem iron_deposit = create(ModBlocks.iron_deposit);
	public static final BlockItem gold_deposit = create(ModBlocks.gold_deposit);
	public static final BlockItem tough_dirt_slab = create(ModBlocks.tough_dirt_slab);
	public static final BlockItem tough_dirt_stairs = create(ModBlocks.tough_dirt_stairs);
	public static final BlockItem tough_dirt_wall = create(ModBlocks.tough_dirt_wall);
	public static final BlockItem dirt_bricks_slab = create(ModBlocks.dirt_bricks_slab);
	public static final BlockItem dirt_bricks_stairs = create(ModBlocks.dirt_bricks_stairs);
	public static final BlockItem dirt_bricks_wall = create(ModBlocks.dirt_bricks_wall);
	public static final BlockItem smooth_dirt_slab = create(ModBlocks.smooth_dirt_slab);
	public static final BlockItem smooth_dirt_stairs = create(ModBlocks.smooth_dirt_stairs);
	public static final BlockItem planter_box = create(ModBlocks.planter_box);
//	public static final BlockItem apple_fruit_tree = create(ModBlocks.apple_fruit_tree);
//	public static final BlockItem apricot_fruit_tree = create(ModBlocks.apricot_fruit_tree);
//	public static final BlockItem orange_fruit_tree = create(ModBlocks.orange_fruit_tree);
	
	public static final Item peat = create("peat", new Item(Properties.item));
	public static final Item orange = create("orange", new Item(Properties.orange));
	public static final Item apricot = create("apricot", new Item(Properties.apricot));
	public static final Item rotten_orange = create("rotten_orange", new Item(Properties.rotten_orange));
	public static final Item rotten_apricot = create("rotten_apricot", new Item(Properties.rotten_apricot));
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(tough_dirt);
		registry.register(dirt_bricks);
		registry.register(smooth_dirt);
		registry.register(regolith);
		registry.register(clay_deposit);
		registry.register(peat_deposit);
		registry.register(iron_deposit);
		registry.register(gold_deposit);
		registry.register(tough_dirt_slab);
		registry.register(tough_dirt_stairs);
		registry.register(tough_dirt_wall);
		registry.register(dirt_bricks_slab);
		registry.register(dirt_bricks_stairs);
		registry.register(dirt_bricks_wall);
		registry.register(smooth_dirt_slab);
		registry.register(smooth_dirt_stairs);
		registry.register(planter_box);
//		registry.register(apple_fruit_tree);
//		registry.register(apricot_fruit_tree);
//		registry.register(orange_fruit_tree);
		
		registry.register(peat);
		registry.register(orange);
		registry.register(apricot);
		registry.register(rotten_orange);
		registry.register(rotten_apricot);
	}
	
	public static BlockItem create(Block block) {
		BlockItem item = new BlockItem(block, Properties.item);
		item.setRegistryName(block.getRegistryName());
		return item;
	}
	
	public static <T extends Item> T create(String name, T item) {
		item.setRegistryName(Reference.MOD_ID, name);
		return item;
	}
	
	public static class Properties {
		
		public static final Item.Properties item = new Item.Properties().group(Reference.MOD_ITEM_GROUP);
		public static final Item.Properties orange = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.orange);
		public static final Item.Properties apricot = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.apricot);
		public static final Item.Properties rotten_orange = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.rotten_orange);
		public static final Item.Properties rotten_apricot = new Item.Properties().group(Reference.MOD_ITEM_GROUP).food(ModFoods.rotten_apricot);
		
	}
	
}
