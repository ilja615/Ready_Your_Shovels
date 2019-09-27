package group.rys.common.effect;

import javax.annotation.Nullable;

import group.rys.core.registry.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class DurationEffect extends Effect {
	
	public DurationEffect(EffectType typeIn, int colorIn) {
		super(typeIn, colorIn);
	}
	
	public void performEffect(LivingEntity entity, int amplifier) {
		this.affectEntity(null, null, entity, amplifier, 0);
	}
	
	public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		int time = (amplifier + 1) * 200;
		
		entity.getActivePotionMap().forEach((Effect effect, EffectInstance effectInstance) -> {
			if (!effectInstance.isAmbient() && effect != this) {
				if (effect.getEffectType() == EffectType.HARMFUL) {
					if (this == ModEffects.decrease_debuff) {
						entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
					}
					if (this == ModEffects.increase_debuff) {
						entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
					}
				}
				
				if (effect.getEffectType() == EffectType.BENEFICIAL) {
					if (this == ModEffects.increase_buff) {
						entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() + time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
					}
					
					if (this == ModEffects.decrease_buff) {
						entity.getActivePotionMap().replace(effect, new EffectInstance(effect, effectInstance.getDuration() - time, effectInstance.getAmplifier(), effectInstance.isAmbient(), effectInstance.isShowIcon()));
					}
				}
			}
		});
	}
	
	public boolean isReady(int duration, int amplifier) {
		return duration >= 1;
	}
	
	public boolean isInstant() {
		return true;
	}
	
}
