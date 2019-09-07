package rys.common.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.block.ModBlocks;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static final BlockItem tough_dirt = null;
	public static final BlockItem dirt_bricks = null;
	public static final BlockItem smooth_dirt = null;
	public static final BlockItem regolith = null;
	public static final BlockItem clay_deposit = null;
	public static final BlockItem peat_deposit = null;
	public static final BlockItem iron_deposit = null;
	public static final BlockItem gold_deposit = null;
	public static final BlockItem tough_dirt_slab = null;
	public static final BlockItem tough_dirt_stairs = null;
	public static final BlockItem tough_dirt_wall = null;
	public static final BlockItem dirt_bricks_slab = null;
	public static final BlockItem dirt_bricks_stairs = null;
	public static final BlockItem dirt_bricks_wall = null;
	public static final BlockItem smooth_dirt_slab = null;
	public static final BlockItem smooth_dirt_stairs = null;
	public static final BlockItem planter_box = null;
	public static final BlockItem apple_fruit_tree = null;
	public static final BlockItem apricot_fruit_tree = null;
	public static final BlockItem orange_fruit_tree = null;
	
	public static final Item peat = null;
	public static Item apricot = create("apricot", new Item(ModItemProperties.apricot));
	public static Item orange = create("orange", new Item(ModItemProperties.orange));
	public static Item rotten_apricot = create("rotten_apricot", new Item(ModItemProperties.rotten_apricot));
	public static Item rotten_orange = create("rotten_orange", new Item(ModItemProperties.rotten_orange));
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(create("tough_dirt", new BlockItem(ModBlocks.tough_dirt, ModItemProperties.item)));
		registry.register(create("dirt_bricks", new BlockItem(ModBlocks.dirt_bricks, ModItemProperties.item)));
		registry.register(create("smooth_dirt", new BlockItem(ModBlocks.smooth_dirt, ModItemProperties.item)));
		registry.register(create("regolith", new BlockItem(ModBlocks.regolith, ModItemProperties.item)));
		registry.register(create("clay_deposit", new BlockItem(ModBlocks.clay_deposit, ModItemProperties.item)));
		registry.register(create("peat_deposit", new BlockItem(ModBlocks.peat_deposit, ModItemProperties.item)));
		registry.register(create("iron_deposit", new BlockItem(ModBlocks.iron_deposit, ModItemProperties.item)));
		registry.register(create("gold_deposit", new BlockItem(ModBlocks.gold_deposit, ModItemProperties.item)));
		registry.register(create("tough_dirt_slab", new BlockItem(ModBlocks.tough_dirt_slab, ModItemProperties.item)));
		registry.register(create("tough_dirt_stairs", new BlockItem(ModBlocks.tough_dirt_stairs, ModItemProperties.item)));
		registry.register(create("tough_dirt_wall", new BlockItem(ModBlocks.tough_dirt_wall, ModItemProperties.item)));
		registry.register(create("dirt_bricks_slab", new BlockItem(ModBlocks.dirt_bricks_slab, ModItemProperties.item)));
		registry.register(create("dirt_bricks_stairs", new BlockItem(ModBlocks.dirt_bricks_stairs, ModItemProperties.item)));
		registry.register(create("dirt_bricks_wall", new BlockItem(ModBlocks.dirt_bricks_wall, ModItemProperties.item)));
		registry.register(create("smooth_dirt_slab", new BlockItem(ModBlocks.smooth_dirt_slab, ModItemProperties.item)));
		registry.register(create("smooth_dirt_stairs", new BlockItem(ModBlocks.smooth_dirt_stairs, ModItemProperties.item)));
		registry.register(create("planter_box", new BlockItem(ModBlocks.planter_box, ModItemProperties.item)));
		registry.register(create("apple_fruit_tree", new BlockItem(ModBlocks.apple_fruit_tree, ModItemProperties.item)));
		registry.register(create("apricot_fruit_tree", new BlockItem(ModBlocks.apricot_fruit_tree, ModItemProperties.item)));
		registry.register(create("orange_fruit_tree", new BlockItem(ModBlocks.orange_fruit_tree, ModItemProperties.item)));
		
		registry.register(create("peat", new Item(ModItemProperties.item)));
		registry.register(apricot);
		registry.register(orange);
		registry.register(rotten_apricot);
		registry.register(rotten_orange);
	}
	
	public static <T extends Item> T create(String name, T item) {
		item.setRegistryName(Reference.MOD_ID, name);
		return item;
	}
	
}
