package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModBlockProperties {
	
	public static final Block.Properties tough_dirt = Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties dirt_bricks = Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties smooth_dirt = Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties regolith = Block.Properties.create(Material.EARTH).hardnessAndResistance(2.0F, 0.5F).sound(SoundType.GROUND).harvestLevel(3).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties clay_deposit = Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties peat_deposit = Block.Properties.create(Material.EARTH).hardnessAndResistance(3.0F, 0.5F).sound(SoundType.GROUND).harvestLevel(1).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties iron_deposit = Block.Properties.create(Material.EARTH).hardnessAndResistance(3.0F, 0.5F).sound(SoundType.GROUND).harvestLevel(2).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties gold_deposit = Block.Properties.create(Material.EARTH).hardnessAndResistance(3.0F, 0.5F).sound(SoundType.GROUND).harvestLevel(3).harvestTool(ToolType.SHOVEL);
	public static final Block.Properties planter_box = Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.AXE);
	public static final Block.Properties fruit_tree = Block.Properties.create(Material.PLANTS).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.PLANT).harvestLevel(0).harvestTool(ToolType.AXE).doesNotBlockMovement().tickRandomly();
	public static final Block.Properties dayroot = Block.Properties.create(Material.TALL_PLANTS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.PLANT).harvestLevel(0).doesNotBlockMovement().lightValue(7);
	
}
