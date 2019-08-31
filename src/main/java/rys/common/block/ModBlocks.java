package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
	
	public static final ToughDirtBlock tough_dirt = create("tough_dirt", new ToughDirtBlock(Properties.tough_dirt));
	public static final Block dirt_bricks = create("dirt_bricks", new Block(Properties.tough_dirt));
	public static final Block smooth_dirt = create("smooth_dirt", new Block(Properties.tough_dirt));
	public static final Block regolith = create("regolith", new Block(Properties.tough_dirt));
	public static final Block clay_deposit = create("clay_deposit", new Block(Properties.tough_dirt));
	public static final Block peat_deposit = create("peat_deposit", new Block(Properties.tough_dirt));
	public static final Block iron_deposit = create("iron_deposit", new Block(Properties.tough_dirt));
	public static final Block gold_deposit = create("gold_deposit", new Block(Properties.tough_dirt));
	
	public static final SlabBlock tough_dirt_slab = create("tough_dirt_slab", new SlabBlock(Properties.tough_dirt));
	public static final StairsBlockMod tough_dirt_stairs = create("tough_dirt_stairs", new StairsBlockMod(tough_dirt.getDefaultState()));
	public static final WallBlock tough_dirt_wall = create("tough_dirt_wall", new WallBlock(Properties.tough_dirt));
	
	public static final SlabBlock dirt_bricks_slab = create("dirt_bricks_slab", new SlabBlock(Properties.tough_dirt));
	public static final StairsBlockMod dirt_bricks_stairs = create("dirt_bricks_stairs", new StairsBlockMod(tough_dirt.getDefaultState()));
	public static final WallBlock dirt_bricks_wall = create("dirt_bricks_wall", new WallBlock(Properties.tough_dirt));
	
	public static final SlabBlock smooth_dirt_slab = create("smooth_dirt_slab", new SlabBlock(Properties.tough_dirt));
	public static final StairsBlockMod smooth_dirt_stairs = create("smooth_dirt_stairs", new StairsBlockMod(tough_dirt.getDefaultState()));
	
	public static final PlanterBoxBlock planter_box = create("planter_box", new PlanterBoxBlock(Properties.planter_box));
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
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
	}
	
	public static <T extends Block> T create(String name, T block) {
		block.setRegistryName(Reference.MOD_ID, name);
		return block;
	}
	
	public static class Properties {
		
		public static final Block.Properties tough_dirt = Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
		public static final Block.Properties planter_box = Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE);
		
	}
	
}
