package rys.common.init;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.Reference;
import rys.common.block.BlockMod;
import rys.common.block.SlabBlockMod;
import rys.common.block.StairsBlockMod;
import rys.common.block.WallBlockMod;
import rys.common.util.BlockType;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
	
	public static final BlockMod tough_dirt = new BlockMod("tough_dirt", BlockType.tough_dirt);
	public static final BlockMod dirt_bricks = new BlockMod("dirt_bricks", BlockType.tough_dirt);
	public static final BlockMod smooth_dirt = new BlockMod("smooth_dirt", BlockType.tough_dirt);
	public static final BlockMod regolith = new BlockMod("regolith", BlockType.tough_dirt);
	public static final BlockMod clay_deposit = new BlockMod("clay_deposit", BlockType.tough_dirt);
	public static final BlockMod peat_deposit = new BlockMod("peat_deposit", BlockType.tough_dirt);
	public static final BlockMod iron_deposit = new BlockMod("iron_deposit", BlockType.tough_dirt);
	public static final BlockMod gold_deposit = new BlockMod("gold_deposit", BlockType.tough_dirt);
	
	public static final SlabBlockMod tough_dirt_slab = new SlabBlockMod("tough_dirt_slab", BlockType.tough_dirt);
	public static final StairsBlockMod tough_dirt_stairs = new StairsBlockMod("tough_dirt_stairs", BlockType.tough_dirt, tough_dirt.getDefaultState());
	public static final WallBlockMod tough_dirt_wall = new WallBlockMod("tough_dirt_wall", BlockType.tough_dirt);
	
	public static final SlabBlockMod dirt_bricks_slab = new SlabBlockMod("dirt_bricks_slab", BlockType.tough_dirt);
	public static final StairsBlockMod dirt_bricks_stairs = new StairsBlockMod("dirt_bricks_stairs", BlockType.tough_dirt, tough_dirt.getDefaultState());
	public static final WallBlockMod dirt_bricks_wall = new WallBlockMod("dirt_bricks_wall", BlockType.tough_dirt);
	
	public static final SlabBlockMod smooth_dirt_slab = new SlabBlockMod("smooth_dirt_slab", BlockType.tough_dirt);
	public static final StairsBlockMod smooth_dirt_stairs = new StairsBlockMod("smooth_dirt_stairs", BlockType.tough_dirt, tough_dirt.getDefaultState());
	
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
	}
	
}
