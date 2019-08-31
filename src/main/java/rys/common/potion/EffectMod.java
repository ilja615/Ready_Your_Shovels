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
		int time = (amplifier + 1) * 200;
		
		entity.getActivePotionEffects().forEach((EffectInstance effectInstance) -> {
			if (this != effectInstance.getPotion()) {
				
				if (effectInstance.getPotion().getEffectType() == EffectType.HARMFUL) {
					
					if (this == ModEffects.decrease_debuff) {
						entity.addPotionEffect(new EffectInstance(effectInstance.getPotion(), effectInstance.getDuration() - time, effectInstance.getAmplifier()));
						entity.removePotionEffect(this);
					}
					
					if (this == ModEffects.increase_debuff) {
						entity.addPotionEffect(new EffectInstance(effectInstance.getPotion(), effectInstance.getDuration() + time, effectInstance.getAmplifier()));
						entity.removePotionEffect(this);
					}
					
				}
				
				if (effectInstance.getPotion().getEffectType() == EffectType.BENEFICIAL) {
					
					if (this == ModEffects.increase_buff) {
						entity.addPotionEffect(new EffectInstance(effectInstance.getPotion(), effectInstance.getDuration() + time, effectInstance.getAmplifier()));
						entity.removePotionEffect(this);
					}
					
					if (this == ModEffects.decrease_buff) {
						entity.addPotionEffect(new EffectInstance(effectInstance.getPotion(), effectInstance.getDuration() - time, effectInstance.getAmplifier()));
						entity.removePotionEffect(this);
					}
					
				}
			}
		});
	}
	
	public boolean isInstant() {
		if (this == ModEffects.decrease_debuff || this == ModEffects.increase_buff || this == ModEffects.increase_debuff || this == ModEffects.increase_debuff) {
			return true;
		}
		
		return super.isInstant();
	}
	
	public boolean isReady(int duration, int amplifier) {
		if (this == ModEffects.decrease_debuff || this == ModEffects.increase_buff || this == ModEffects.increase_debuff || this == ModEffects.increase_debuff) {
			return duration >= 1;
		}
		
		return super.isReady(duration, amplifier);
	}
	
}
