package group.rys.common.world.gen.storage.loot.functions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import group.rys.core.util.Reference;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootFunction;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;

public class ApplyFortune extends LootFunction {
	
	private int bonus;
	
	protected ApplyFortune(ILootCondition[] conditionsIn, int bonusIn) {
		super(conditionsIn);
		this.bonus = bonusIn;
	}
	
	protected ItemStack doApply(ItemStack stack, LootContext context) {
		ItemStack itemstack = context.get(LootParameters.TOOL);
		
		int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemstack);
		
		stack.setCount(context.getRandom().nextInt(3) + (level * this.bonus) + 1);
		
		return stack;
	}
	
	public static class Serializer extends LootFunction.Serializer<ApplyFortune> {
		
		public Serializer() {
			super(new ResourceLocation(Reference.MOD_ID, "apply_fortune"), ApplyFortune.class);
		}
		
		public void serialize(JsonObject object, ApplyFortune functionClazz, JsonSerializationContext serializationContext) {
			super.serialize(object, functionClazz, serializationContext);
			object.addProperty("bonus", functionClazz.bonus);
		}
		
		public ApplyFortune deserialize(JsonObject object, JsonDeserializationContext deserializationContext, ILootCondition[] conditionsIn) {
			int bonusIn = object.get("bonus").getAsInt();
			return new ApplyFortune(conditionsIn, bonusIn);
		}
		
	}
	
}
