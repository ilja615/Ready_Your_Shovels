package rys.common.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import rys.common.init.ModEffects;
import rys.common.util.Reference;

public class EffectMod extends Effect {
	
	public EffectMod(String name, EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		entity.getActivePotionEffects().forEach((EffectInstance effect) -> {
			if (!effect.isAmbient()) {
				int time = (amplifier + 1) * 160;
				
				if (effect.getPotion().getEffectType() == EffectType.BENEFICIAL) {
					if (this == ModEffects.increase_buff) {
						entity.removePotionEffect(this);
						entity.removePotionEffect(effect.getPotion());
						entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time));
					}
					
					if (this == ModEffects.decrease_buff) {
						entity.removePotionEffect(this);
						entity.removePotionEffect(effect.getPotion());
						entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time));
					}
				}
				
				if (effect.getPotion().getEffectType() == EffectType.HARMFUL) {
					if (this == ModEffects.increase_debuff) {
						entity.removePotionEffect(this);
						entity.removePotionEffect(effect.getPotion());
						entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time));
					}
					
					if (this == ModEffects.decrease_debuff) {
						entity.removePotionEffect(this);
						entity.removePotionEffect(effect.getPotion());
						entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time));
					}
				}
			}
		});
	}
	
	public boolean isInstant() {
		if (this == ModEffects.increase_buff || this == ModEffects.decrease_buff || this == ModEffects.increase_debuff || this == ModEffects.decrease_debuff) {
			return true;
		}
		
		return super.isInstant();
	}
	
	public boolean isReady(int duration, int amplifier) {
		if (this == ModEffects.increase_buff || this == ModEffects.decrease_buff || this == ModEffects.increase_debuff || this == ModEffects.decrease_debuff) {
			return duration >= 1;
		}
		
		return super.isReady(duration, amplifier);
	}
	
}
