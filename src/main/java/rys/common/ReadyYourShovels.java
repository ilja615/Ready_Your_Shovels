package rys.common;

import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rys.common.world.storage.loot.conditions.MatchHarvestLevel;

@Mod(Reference.MOD_ID)
public class ReadyYourShovels {
	
	public ReadyYourShovels() {
//		MinecraftForge.EVENT_BUS.register(ModEvents.class);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
	}
	
	public void commonSetup(FMLCommonSetupEvent event) {
		LootConditionManager.registerCondition(new MatchHarvestLevel.Serializer());
	}
	
}
