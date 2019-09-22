package group.rys.core.registry;

import group.rys.core.util.Reference;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

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
	public static final BlockItem orange_fruit_tree = null;
	public static final BlockItem apricot_fruit_tree = null;
	public static final BlockItem dayroot = null;
	
	public static final Item peat = null;
	public static Item orange = create("orange", new Item(ModProperties.orange));
	public static Item apricot = create("apricot", new Item(ModProperties.apricot));
	public static Item rotten_orange = create("rotten_orange", new Item(ModProperties.rotten_orange));
	public static Item rotten_apricot = create("rotten_apricot", new Item(ModProperties.rotten_apricot));
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(create("tough_dirt", new BlockItem(ModBlocks.tough_dirt, ModProperties.item)));
		registry.register(create("dirt_bricks", new BlockItem(ModBlocks.dirt_bricks, ModProperties.item)));
		registry.register(create("smooth_dirt", new BlockItem(ModBlocks.smooth_dirt, ModProperties.item)));
		registry.register(create("regolith", new BlockItem(ModBlocks.regolith, ModProperties.item)));
		registry.register(create("clay_deposit", new BlockItem(ModBlocks.clay_deposit, ModProperties.item)));
		registry.register(create("peat_deposit", new BlockItem(ModBlocks.peat_deposit, ModProperties.item)));
		registry.register(create("iron_deposit", new BlockItem(ModBlocks.iron_deposit, ModProperties.item)));
		registry.register(create("gold_deposit", new BlockItem(ModBlocks.gold_deposit, ModProperties.item)));
		registry.register(create("tough_dirt_slab", new BlockItem(ModBlocks.tough_dirt_slab, ModProperties.item)));
		registry.register(create("tough_dirt_stairs", new BlockItem(ModBlocks.tough_dirt_stairs, ModProperties.item)));
		registry.register(create("tough_dirt_wall", new BlockItem(ModBlocks.tough_dirt_wall, ModProperties.item)));
		registry.register(create("dirt_bricks_slab", new BlockItem(ModBlocks.dirt_bricks_slab, ModProperties.item)));
		registry.register(create("dirt_bricks_stairs", new BlockItem(ModBlocks.dirt_bricks_stairs, ModProperties.item)));
		registry.register(create("dirt_bricks_wall", new BlockItem(ModBlocks.dirt_bricks_wall, ModProperties.item)));
		registry.register(create("smooth_dirt_slab", new BlockItem(ModBlocks.smooth_dirt_slab, ModProperties.item)));
		registry.register(create("smooth_dirt_stairs", new BlockItem(ModBlocks.smooth_dirt_stairs, ModProperties.item)));
		registry.register(create("planter_box", new BlockItem(ModBlocks.planter_box, ModProperties.item)));
		registry.register(create("apple_fruit_tree", new BlockItem(ModBlocks.apple_fruit_tree, ModProperties.item)));
		registry.register(create("orange_fruit_tree", new BlockItem(ModBlocks.orange_fruit_tree, ModProperties.item)));
		registry.register(create("apricot_fruit_tree", new BlockItem(ModBlocks.apricot_fruit_tree, ModProperties.item)));
		registry.register(create("dayroot", new BlockItem(ModBlocks.dayroot, ModProperties.item)));
		
		registry.register(create("peat", new Item(ModProperties.item)));
		registry.register(orange);
		registry.register(apricot);
		registry.register(rotten_orange);
		registry.register(rotten_apricot);
	}
	
	public static <T extends Item> T create(String name, T item) {
		item.setRegistryName(Reference.MOD_ID, name);
		return item;
	}
	
}
