package rys.common.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import rys.common.util.Reference;

public class EffectMod extends Effect {
	
	public EffectMod(String name, EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		entity.getActivePotionEffects().forEach((EffectInstance effect) -> {
			if (!effect.isAmbient()) {
				int time = (amplifier + 1) * 200;
				EffectType type = effect.getPotion().getEffectType();
				
				if (this == ModEffects.decrease_debuff && type == EffectType.HARMFUL) {
					entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time, effect.getAmplifier()));
					entity.removePotionEffect(this);
				}
				
				if (this == ModEffects.increase_buff && type == EffectType.BENEFICIAL) {
					entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time, effect.getAmplifier()));
					entity.removePotionEffect(this);
				}
				
				if (this == ModEffects.increase_debuff && type == EffectType.HARMFUL) {
					entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time, effect.getAmplifier()));
					entity.removePotionEffect(this);
				}
				
				if (this == ModEffects.decrease_buff && type == EffectType.BENEFICIAL) {
					entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time, effect.getAmplifier()));
					entity.removePotionEffect(this);
				}
			}
		});
	}
	
}
