package rys.common.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class EffectMod extends Effect {
	
	public EffectMod(EffectType typeIn, int colorIn) {
		super(typeIn, colorIn);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		int time = (amplifier + 1) * 200;
		
		if (this == ModEffects.decrease_debuff) {
			entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
				if (effect.getEffectType() == EffectType.HARMFUL && !effectInstance.isAmbient()) {
					entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
				}
			});
		}
		
		if (this == ModEffects.increase_buff) {
			entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
				if (effect.getEffectType() == EffectType.BENEFICIAL && !effectInstance.isAmbient()) {
					entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
				}
			});
		}
		
		if (this == ModEffects.increase_debuff) {
			entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
				if (effect.getEffectType() == EffectType.HARMFUL && !effectInstance.isAmbient()) {
					entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
				}
			});
		}
		
		if (this == ModEffects.decrease_buff) {
			entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
				if (effect.getEffectType() == EffectType.BENEFICIAL && !effectInstance.isAmbient()) {
					entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
				}
			});
		}
	}
	
	public boolean isReady(int duration, int amplifier) {
		if (this == ModEffects.decrease_debuff || this == ModEffects.increase_buff || this == ModEffects.increase_debuff || this == ModEffects.decrease_buff) {
			return true;
		}
		
		return false;
	}
	
	public boolean isInstant() {
		if (this == ModEffects.decrease_debuff || this == ModEffects.increase_buff || this == ModEffects.increase_debuff || this == ModEffects.decrease_buff) {
			return true;
		}
		
		return false;
	}
	
}
