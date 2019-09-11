package rys.common.world.storage.loot.functions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootFunction;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import rys.common.util.Reference;

public class ApplyFortuneEnchantment extends LootFunction {
	
	private int bonus;
	
	protected ApplyFortuneEnchantment(ILootCondition[] conditionsIn, int bonusIn) {
		super(conditionsIn);
		this.bonus = bonusIn;
	}
	
	protected ItemStack doApply(ItemStack stack, LootContext context) {
		ItemStack itemstack = context.get(LootParameters.TOOL);
		
		int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack);
		
//		stack.setCount(context.getRandom().nextInt(this.bonus + 1) + (level * this.bonus + 1));
		stack.setCount(context.getRandom().nextInt(3) + (level * this.bonus) + 1);
		
		return stack;
	}
	
	public static class Serializer extends LootFunction.Serializer<ApplyFortuneEnchantment> {
		
		public Serializer() {
			super(new ResourceLocation(Reference.MOD_ID, "apply_fortune_enchantment"), ApplyFortuneEnchantment.class);
		}
		
		public void serialize(JsonObject object, ApplyFortuneEnchantment functionClazz, JsonSerializationContext serializationContext) {
			super.serialize(object, functionClazz, serializationContext);
			object.addProperty("bonus", functionClazz.bonus);
		}
		
		public ApplyFortuneEnchantment deserialize(JsonObject object, JsonDeserializationContext deserializationContext, ILootCondition[] conditionsIn) {
			int bonusIn = object.get("bonus").getAsInt();
			return new ApplyFortuneEnchantment(conditionsIn, bonusIn);
		}
		
	}
	
}
