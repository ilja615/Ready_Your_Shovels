package rys.common.world.storage.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import rys.common.util.Reference;

public class MatchHarvestLevel implements ILootCondition {
	
	private int harvestLevel;
	
	public MatchHarvestLevel(int harvestLevelIn) {
		this.harvestLevel = harvestLevelIn;
	}
	
	public boolean test(LootContext context) {
		ItemStack stack = context.get(LootParameters.TOOL);
		return stack != null && getLevel(stack) >= this.harvestLevel;
	}
	
	private static int getLevel(ItemStack stack) {
		Tag<Item> tier_1 = ItemTags.getCollection().get(new ResourceLocation("rys", "tier_1"));
		Tag<Item> tier_2 = ItemTags.getCollection().get(new ResourceLocation("rys", "tier_2"));
		Tag<Item> tier_3 = ItemTags.getCollection().get(new ResourceLocation("rys", "tier_3"));
		Tag<Item> tier_4 = ItemTags.getCollection().get(new ResourceLocation("rys", "tier_4"));
		
		if (tier_1.contains(stack.getItem())) {
			return 1;
		}
		if (tier_2.contains(stack.getItem())) {
			return 2;
		}
		if (tier_3.contains(stack.getItem())) {
			return 3;
		}
		if (tier_4.contains(stack.getItem())) {
			return 4;
		}
		
		return 0;
	}
	
	public static class Serializer extends ILootCondition.AbstractSerializer<MatchHarvestLevel> {
		
		public Serializer() {
			super(new ResourceLocation(Reference.MOD_ID, "match_harvest_level"), MatchHarvestLevel.class);
		}
		
		public void serialize(JsonObject json, MatchHarvestLevel value, JsonSerializationContext context) {
			json.addProperty("harvest_level", value.harvestLevel);
		}
		
		public MatchHarvestLevel deserialize(JsonObject json, JsonDeserializationContext context) {
			int harvestLevelIn = json.get("harvest_level").getAsInt();
			return new MatchHarvestLevel(harvestLevelIn);
		}
		
	}
	
}
