package rys.common.util;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockType {
	
	public Material material;
	public float hardness;
	public float resistance;
	public SoundType sound;
	public int harvestLevel;
	public ToolType harvestTool;
	
	public BlockType(Material material, float hardness, float resistance, SoundType sound, int harvestLevel, ToolType harvestTool) {
		this.material = material;
		this.hardness = hardness;
		this.resistance = resistance;
		this.sound = sound;
		this.harvestLevel = harvestLevel;
		this.harvestTool = harvestTool;
	}
	
	public static final BlockType tough_dirt = new BlockType(Material.EARTH, 1.5F, 0.5F, SoundType.GROUND, 1, ToolType.SHOVEL);
	
}
