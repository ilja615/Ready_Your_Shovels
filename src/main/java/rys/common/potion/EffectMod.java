package rys.common.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import rys.common.Reference;
import rys.common.init.ModEffects;

public class EffectMod extends Effect {
	
	public EffectMod(String name, EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		entity.getActivePotionEffects().forEach((EffectInstance effect) -> {
			if (this == ModEffects.increase_buff && effect.getPotion().getEffectType() == EffectType.BENEFICIAL) {
				int time = (amplifier + 1) * 80;
				
				entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time));
				entity.removeActivePotionEffect(this);
			}
			
			if (this == ModEffects.decrease_debuff && effect.getPotion().getEffectType() == EffectType.HARMFUL) {
				int time = (amplifier + 1) * 80;
				
				entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time));
				entity.removeActivePotionEffect(this);
			}
			
			if (this == ModEffects.increase_debuff && effect.getPotion().getEffectType() == EffectType.HARMFUL) {
				int time = (amplifier + 1) * 100;
				
				entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() + time));
				entity.removeActivePotionEffect(this);
			}
			
			if (this == ModEffects.decrease_buff && effect.getPotion().getEffectType() == EffectType.BENEFICIAL) {
				int time = (amplifier + 1) * 100;
				
				entity.addPotionEffect(new EffectInstance(effect.getPotion(), effect.getDuration() - time));
				entity.removeActivePotionEffect(this);
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
