package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.item.ModItems;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	
	public static ToughDirtBlock tough_dirt = create("tough_dirt", new ToughDirtBlock(ModBlockProperties.tough_dirt));
	public static Block dirt_bricks = create("dirt_bricks", new Block(ModBlockProperties.dirt_bricks));
	public static Block smooth_dirt = create("smooth_dirt", new Block(ModBlockProperties.smooth_dirt));
	public static final Block regolith = null;
	public static final Block clay_deposit = null;
	public static final Block peat_deposit = null;
	public static final Block iron_deposit = null;
	public static final Block gold_deposit = null;
	public static final SlabBlock tough_dirt_slab = null;
	public static final StairsBlock tough_dirt_stairs = null;
	public static final WallBlock tough_dirt_wall = null;
	public static final SlabBlock dirt_bricks_slab = null;
	public static final StairsBlock dirt_bricks_stairs = null;
	public static final WallBlock dirt_bricks_wall = null;
	public static final SlabBlock smooth_dirt_slab = null;
	public static final StairsBlock smooth_dirt_stairs = null;
	public static final PlanterBoxBlock planter_box = null;
	public static final FruitTreeBlock apple_fruit_tree = null;
	public static final FruitTreeBlock orange_fruit_tree = null;
	public static final FruitTreeBlock apricot_fruit_tree = null;
	public static final DayrootBlock dayroot = null;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		registry.register(tough_dirt);
		registry.register(dirt_bricks);
		registry.register(smooth_dirt);
		registry.register(create("regolith", new Block(ModBlockProperties.regolith)));
		registry.register(create("clay_deposit", new Block(ModBlockProperties.clay_deposit)));
		registry.register(create("peat_deposit", new Block(ModBlockProperties.peat_deposit)));
		registry.register(create("iron_deposit", new Block(ModBlockProperties.iron_deposit)));
		registry.register(create("gold_deposit", new Block(ModBlockProperties.gold_deposit)));
		registry.register(create("tough_dirt_slab", new SlabBlock(ModBlockProperties.tough_dirt)));
		registry.register(create("tough_dirt_stairs", new StairsBlock(tough_dirt.getDefaultState(), ModBlockProperties.tough_dirt)));
		registry.register(create("tough_dirt_wall", new WallBlock(ModBlockProperties.tough_dirt)));
		registry.register(create("dirt_bricks_slab", new SlabBlock(ModBlockProperties.dirt_bricks)));
		registry.register(create("dirt_bricks_stairs", new StairsBlock(dirt_bricks.getDefaultState(), ModBlockProperties.dirt_bricks)));
		registry.register(create("dirt_bricks_wall", new WallBlock(ModBlockProperties.dirt_bricks)));
		registry.register(create("smooth_dirt_slab", new SlabBlock(ModBlockProperties.smooth_dirt)));
		registry.register(create("smooth_dirt_stairs", new StairsBlock(smooth_dirt.getDefaultState(), ModBlockProperties.smooth_dirt)));
		registry.register(create("planter_box", new PlanterBoxBlock(ModBlockProperties.planter_box)));
		registry.register(create("apple_fruit_tree", new FruitTreeBlock(Items.APPLE, Items.APPLE, ModBlockProperties.fruit_tree)));
		registry.register(create("orange_fruit_tree", new FruitTreeBlock(ModItems.orange, ModItems.rotten_orange, ModBlockProperties.fruit_tree)));
		registry.register(create("apricot_fruit_tree", new FruitTreeBlock(ModItems.apricot, ModItems.rotten_apricot, ModBlockProperties.fruit_tree)));
		registry.register(create("dayroot", new DayrootBlock(ModBlockProperties.dayroot)));
	}
	
	public static <T extends Block> T create(String name, T block) {
		block.setRegistryName(Reference.MOD_ID, name);
		return block;
	}
	
}
