package rys.common;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rys.common.block.ModBlocks;
import rys.common.init.ModEvents;
import rys.common.util.Reference;
import rys.common.world.gen.feature.ModFeatures;
import rys.common.world.storage.loot.conditions.MatchHarvestLevel;

@Mod(Reference.MOD_ID)
public class ReadyYourShovels {
	
	public ReadyYourShovels() {
		MinecraftForge.EVENT_BUS.register(ModEvents.class);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
	}
	
	public void commonSetup(FMLCommonSetupEvent event) {
		LootConditionManager.registerCondition(new MatchHarvestLevel.Serializer());
		registerFeatures();
	}
	
	public static void registerFeatures() {
		Biome.BIOMES.forEach((Biome biome) -> {
			String name = biome.getRegistryName().toString();
			if (!name.contains("ocean") && !name.contains("mountains")) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.clay_deposit.getDefaultState(), 32), Placement.COUNT_RANGE, new CountRangeConfig(32, 32, 0, 64)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.peat_deposit.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 32, 0, 128)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.iron_deposit.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(20, 32, 0, 64)));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.gold_deposit.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(2, 32, 0, 64)));
				
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(ModFeatures.cave, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		});
	}
	
}
