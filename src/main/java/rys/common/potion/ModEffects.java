package rys.common.potion;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModEffects {
	
	public static Effect decrease_debuff = create("decrease_debuff", new EffectMod(EffectType.NEUTRAL, 16544256));
	public static Effect increase_buff = create("increase_buff", new EffectMod(EffectType.NEUTRAL, 16756506));
	public static Effect increase_debuff = create("increase_debuff", new EffectMod(EffectType.NEUTRAL, 13340727));
	public static Effect decrease_buff = create("decrease_buff", new EffectMod(EffectType.NEUTRAL, 15976297));
	
	@SubscribeEvent
	public static void registerEffects(RegistryEvent.Register<Effect> event) {
		IForgeRegistry<Effect> registry = event.getRegistry();
		
		registry.register(decrease_debuff);
		registry.register(increase_buff);
		registry.register(increase_debuff);
		registry.register(decrease_buff);
	}
	
	public static <T extends Effect> T create(String name, T effect) {
		effect.setRegistryName(Reference.MOD_ID, name);
		return effect;
	}
	
}
