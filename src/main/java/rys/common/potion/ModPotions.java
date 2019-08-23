package rys.common.potion;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModPotions {
	
	public static final Potion decrease_debuff = register("decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 0)));
	public static final Potion strong_decrease_debuff = register("strong_decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 1)));
	public static final Potion increase_buff = register("increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 0)));
	public static final Potion strong_increase_buff = register("strong_increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 1)));
	public static final Potion increase_debuff = register("increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 0)));
	public static final Potion strong_increase_debuff = register("strong_increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 1)));
	public static final Potion decrease_buff = register("decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 0)));
	public static final Potion strong_decrease_buff = register("strong_decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 1)));
	
	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		IForgeRegistry<Potion> registry = event.getRegistry();
		
		registry.register(decrease_debuff);
		registry.register(strong_decrease_debuff);
		registry.register(increase_buff);
		registry.register(strong_increase_buff);
		registry.register(increase_debuff);
		registry.register(strong_increase_debuff);
		registry.register(decrease_buff);
		registry.register(strong_decrease_buff);
	}
	
//	@SubscribeEvent
//	public static void registerMixes(RegistryEvent.Register<PotionBrewing.MixPredicate<?>> event) {
//		
//	}
	
	public static Potion register(String name, Potion potion) {
		potion.setRegistryName(Reference.MOD_ID, name);
		return potion;
	}
	
}
