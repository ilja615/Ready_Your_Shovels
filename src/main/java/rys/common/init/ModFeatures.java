package rys.common.init;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.util.Reference;
import rys.common.world.gen.feature.CaveFeature;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {
	
	public static final Feature<NoFeatureConfig> cave = create("cave", new CaveFeature(NoFeatureConfig::deserialize));
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		
		registry.register(cave);
	}
	
	public static <T extends Feature<?>> T create(String name, T feature) {
		feature.setRegistryName(Reference.MOD_ID, name);
		return feature;
	}
	
}
