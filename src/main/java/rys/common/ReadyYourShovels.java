package rys.common;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import rys.common.init.ModEvents;
import rys.common.init.ModFeatures;
import rys.common.util.Reference;
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
		ForgeRegistries.BIOMES.forEach((Biome biome) -> {
			biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, Biome.createDecoratedFeature(ModFeatures.cave, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
		});
	}
	
}
