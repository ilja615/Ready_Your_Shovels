package rys.common;

import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rys.common.init.ModEvents;
import rys.common.potion.ModPotions;
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
		ModFeatures.registerFeatures();
		ModPotions.registerRecipes();
		LootConditionManager.registerCondition(new MatchHarvestLevel.Serializer());
	}
	
}
