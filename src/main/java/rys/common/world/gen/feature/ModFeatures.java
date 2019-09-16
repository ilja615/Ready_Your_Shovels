package rys.common.world.gen.feature;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.block.ModBlocks;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModFeatures {
	
	public static final CaveFeature cave = create("cave", new CaveFeature(NoFeatureConfig::deserialize));
	public static final GradientFeature gradient = create("gradient", new GradientFeature(NoFeatureConfig::deserialize));
	public static final CaveDecorationFeature cave_decoration = create("cave_decoration", new CaveDecorationFeature(BushConfig::deserialize));
	public static final CaveDiversityFeature cave_diversity = create("cave_diversity", new CaveDiversityFeature(ReplaceBlockConfig::deserialize));
	public static final DepositsInCavesFeature deposits_in_caves = create("deposits_in_caves", new DepositsInCavesFeature(ReplaceBlockConfig::deserialize));
	public static final DepositsInRiversFeature deposits_in_rivers = create("deposits_in_rivers", new DepositsInRiversFeature(ReplaceBlockConfig::deserialize));
	public static final DayrootFeature dayroot = create("dayroot", new DayrootFeature(BushConfig::deserialize));
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		registry.register(cave);
		registry.register(gradient);
		registry.register(cave_decoration);
		registry.register(cave_diversity);
		registry.register(deposits_in_caves);
		registry.register(deposits_in_rivers);
		registry.register(dayroot);
	}
	
	public static <T extends Feature<?>> T create(String name, T feature) {
		feature.setRegistryName(Reference.MOD_ID, name);
		return feature;
	}
	
	public static void registerFeatures() {
		Biome.BIOMES.forEach((Biome biome) -> {
			String name = biome.getRegistryName().toString();
			// CaveFeature
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			
			// GradientFeature
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(gradient, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			
			if (!name.contains("ocean") && !name.contains("mountains") && !name.contains("river") && !name.contains("stone")) {
				
				// CaveDecorationFeature
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_decoration, new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_decoration, new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				
				// CaveDiversityFeature
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_diversity, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.DIRT.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_diversity, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_diversity, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.COBBLESTONE.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_diversity, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.GRAVEL.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(cave_diversity, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.MOSSY_COBBLESTONE.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				
				// DepositsInCavesFeature
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.clay_deposit.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.peat_deposit.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new ReplaceBlockConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.iron_deposit.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				
				// DayrootFeature
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dayroot, new BushConfig(ModBlocks.dayroot.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
			
			if (name.contains("river")) {
				
				// DepositsInRiversFeature
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_rivers, new ReplaceBlockConfig(Blocks.DIRT.getDefaultState(), ModBlocks.gold_deposit.getDefaultState()), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				
			}
		});
	}
	
}
