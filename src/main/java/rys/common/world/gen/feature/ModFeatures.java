package rys.common.world.gen.feature;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.block.ModBlocks;
import rys.common.util.Reference;
import rys.common.world.gen.placement.CountChanceDepthConfig;
import rys.common.world.gen.placement.ModPlacements;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModFeatures {
	
	public static final DirtCaveFeature dirt_cave = create("dirt_cave", new DirtCaveFeature(NoFeatureConfig::deserialize));
	public static final DirtGradientFeature dirt_gradient = create("dirt_gradient", new DirtGradientFeature(NoFeatureConfig::deserialize));
	public static final DepositsInCavesFeature deposits_in_caves = create("deposits_in_caves", new DepositsInCavesFeature(SphereConfig::deserialize));
	public static final DepositsInRiversFeature deposits_in_rivers = create("deposits_in_rivers", new DepositsInRiversFeature(SphereConfig::deserialize));
	public static final DayrootFeature dayroot = create("dayroot", new DayrootFeature(SphereConfig::deserialize));
	public static final DirtCaveDecorationFeature dirt_cave_decoration = create("dirt_cave_decoration", new DirtCaveDecorationFeature(SphereConfig::deserialize));
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		registry.register(dirt_cave);
		registry.register(dirt_gradient);
		registry.register(deposits_in_caves);
		registry.register(deposits_in_rivers);
		registry.register(dayroot);
		registry.register(dirt_cave_decoration);
	}
	
	public static <T extends Feature<?>> T create(String name, T feature) {
		feature.setRegistryName(Reference.MOD_ID, name);
		return feature;
	}
	
	public static void registerFeatures() {
		Biome.BIOMES.forEach((Biome biome) -> {
			String name = biome.getRegistryName().toString();
			
			// Dirt Cave
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dirt_cave, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			
			// Dirt Gradient
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dirt_gradient, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			
			if (!name.contains("ocean") && !name.contains("mountains") && !name.contains("river") && !name.contains("stone")) {
				
				// Cave Diversity
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.DIRT.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(16, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(16, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(16, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.GRAVEL.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(16, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), Blocks.MOSSY_COBBLESTONE.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(16, 1.0F, 20)));
				
				// Deposits In Caves
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.clay_deposit.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(8, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.peat_deposit.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(8, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.iron_deposit.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(4, 1.0F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_caves, new SphereConfig(ModBlocks.tough_dirt.getDefaultState(), ModBlocks.gold_deposit.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(4, 1.0F, 20)));
				
				// Dayroot
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dayroot, new SphereConfig(Blocks.AIR.getDefaultState(), ModBlocks.dayroot.getDefaultState(), 2, 0.25F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(32, 1.0F, 20)));
				
				// Cave Decoration
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dirt_cave_decoration, new SphereConfig(Blocks.AIR.getDefaultState(), Blocks.BROWN_MUSHROOM.getDefaultState(), 2, 0.25F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(32, 0.5F, 20)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(dirt_cave_decoration, new SphereConfig(Blocks.AIR.getDefaultState(), Blocks.RED_MUSHROOM.getDefaultState(), 2, 0.25F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(32, 0.5F, 20)));
				
			}
			
			// Deposits In Rivers
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(deposits_in_rivers, new SphereConfig(Blocks.DIRT.getDefaultState(), ModBlocks.gold_deposit.getDefaultState(), 2, 1.0F), ModPlacements.count_chance_depth, new CountChanceDepthConfig(32, 0.5F, 20)));
			
		});
	}
	
}
