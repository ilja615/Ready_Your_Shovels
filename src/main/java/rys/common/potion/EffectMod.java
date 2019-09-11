package rys.common.potion;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class EffectMod extends Effect {
	
	public EffectMod(EffectType typeIn, int colorIn) {
		super(typeIn, colorIn);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		Map<Effect, EffectInstance> map = new HashMap<>();
		
		int time = (amplifier + 1) * 200;
		
		if (this == ModEffects.decrease_debuff) {
			entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
				if (effect.getEffectType() == EffectType.HARMFUL) {
					map.put(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
				} else {
					map.put(effect, effectInstance);
				}
			});
			
			entity.getActivePotionMap().clear();
			
			map.forEach((Effect effect, EffectInstance effectInstance) -> {
				entity.getActivePotionMap().put(effect, effectInstance);
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
