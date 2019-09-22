package group.rys.core.registry;

import group.rys.common.block.DayrootBlock;
import group.rys.common.block.FruitTreeBlock;
import group.rys.common.block.PlanterBoxBlock;
import group.rys.common.block.ToughDirtBlock;
import group.rys.core.util.Reference;
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

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	
	public static ToughDirtBlock tough_dirt = create("tough_dirt", new ToughDirtBlock(ModProperties.tough_dirt));
	public static Block dirt_bricks = create("dirt_bricks", new Block(ModProperties.dirt_bricks));
	public static Block smooth_dirt = create("smooth_dirt", new Block(ModProperties.smooth_dirt));
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
		registry.register(create("regolith", new Block(ModProperties.regolith)));
		registry.register(create("clay_deposit", new Block(ModProperties.clay_deposit)));
		registry.register(create("peat_deposit", new Block(ModProperties.peat_deposit)));
		registry.register(create("iron_deposit", new Block(ModProperties.iron_deposit)));
		registry.register(create("gold_deposit", new Block(ModProperties.gold_deposit)));
		registry.register(create("tough_dirt_slab", new SlabBlock(ModProperties.tough_dirt)));
		registry.register(create("tough_dirt_stairs", new StairsBlock(tough_dirt.getDefaultState(), ModProperties.tough_dirt)));
		registry.register(create("tough_dirt_wall", new WallBlock(ModProperties.tough_dirt)));
		registry.register(create("dirt_bricks_slab", new SlabBlock(ModProperties.dirt_bricks)));
		registry.register(create("dirt_bricks_stairs", new StairsBlock(dirt_bricks.getDefaultState(), ModProperties.dirt_bricks)));
		registry.register(create("dirt_bricks_wall", new WallBlock(ModProperties.dirt_bricks)));
		registry.register(create("smooth_dirt_slab", new SlabBlock(ModProperties.smooth_dirt)));
		registry.register(create("smooth_dirt_stairs", new StairsBlock(smooth_dirt.getDefaultState(), ModProperties.smooth_dirt)));
		registry.register(create("planter_box", new PlanterBoxBlock(ModProperties.planter_box)));
		registry.register(create("apple_fruit_tree", new FruitTreeBlock(Items.APPLE, Items.APPLE, ModProperties.fruit_tree)));
		registry.register(create("orange_fruit_tree", new FruitTreeBlock(ModItems.orange, ModItems.rotten_orange, ModProperties.fruit_tree)));
		registry.register(create("apricot_fruit_tree", new FruitTreeBlock(ModItems.apricot, ModItems.rotten_apricot, ModProperties.fruit_tree)));
		registry.register(create("dayroot", new DayrootBlock(ModProperties.dayroot)));
	}
	
	public static <T extends Block> T create(String name, T block) {
		block.setRegistryName(Reference.MOD_ID, name);
		return block;
	}
	
}
