package rys.common.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.Reference;
import rys.common.potion.EffectMod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEffects {
	
	public static final Effect increase_buff = new EffectMod("increase_buff", EffectType.NEUTRAL, 16756506);
	public static final Effect increase_debuff = new EffectMod("increase_debuff", EffectType.NEUTRAL, 13340727);
	public static final Effect decrease_buff = new EffectMod("decrease_buff", EffectType.NEUTRAL, 15976297);
	public static final Effect decrease_debuff = new EffectMod("decrease_debuff", EffectType.NEUTRAL, 16544256);
	
	@SubscribeEvent
	public static void registerEffects(RegistryEvent.Register<Effect> event) {
		IForgeRegistry<Effect> registry = event.getRegistry();
		
		registry.register(increase_buff);
		registry.register(increase_debuff);
		registry.register(decrease_buff);
		registry.register(decrease_debuff);
	}
	
}
