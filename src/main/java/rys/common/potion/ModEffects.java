package rys.common.potion;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEffects {
	
	public static final Effect decrease_debuff = new EffectMod("decrease_debuff", EffectType.BENEFICIAL, 16544256);
	public static final Effect increase_buff = new EffectMod("increase_buff", EffectType.BENEFICIAL, 16756506);
	public static final Effect increase_debuff = new EffectMod("increase_debuff", EffectType.HARMFUL, 13340727);
	public static final Effect decrease_buff = new EffectMod("decrease_buff", EffectType.HARMFUL, 15976297);
	
	@SubscribeEvent
	public static void registerEffects(RegistryEvent.Register<Effect> event) {
		IForgeRegistry<Effect> registry = event.getRegistry();
		
		registry.register(decrease_debuff);
		registry.register(increase_buff);
		registry.register(increase_debuff);
		registry.register(decrease_buff);
	}
	
}
