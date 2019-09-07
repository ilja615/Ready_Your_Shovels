package rys.common.potion;

import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class EffectMod extends Effect {
	
	public EffectMod(EffectType typeIn, int colorIn) {
		super(typeIn, colorIn);
	}
	
	public void affectEntity(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		int time = (amplifier + 1) * 200;
		
		for (Map.Entry<Effect, EffectInstance> entry : entity.getActivePotionMap().entrySet()) {
			Effect effect = entry.getKey();
			EffectInstance effectInstance = entry.getValue();
			
			if (effect != this && !effectInstance.isAmbient()) {
				
				if (effect.getEffectType() == EffectType.HARMFUL) {
					
					if (this == ModEffects.decrease_debuff) {
						entity.getActivePotionMap().remove(effect);
						entity.livingTick();
						entity.getActivePotionMap().put(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
						break;
					}
					
					if (this == ModEffects.increase_debuff) {
						entity.getActivePotionMap().remove(effect);
						entity.livingTick();
						entity.getActivePotionMap().put(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
						break;
					}
					
				}
				
				if (effect.getEffectType() == EffectType.BENEFICIAL) {
					
					if (this == ModEffects.increase_buff) {
						entity.getActivePotionMap().remove(effect);
						entity.livingTick();
						entity.getActivePotionMap().put(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
						break;
					}
					
					if (this == ModEffects.decrease_buff) {
						entity.getActivePotionMap().remove(effect);
						entity.livingTick();
						entity.getActivePotionMap().put(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
						break;
					}
					
				}
				
			}
		}
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
