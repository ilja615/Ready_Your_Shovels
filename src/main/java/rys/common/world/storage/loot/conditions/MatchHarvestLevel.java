package rys.common.world.storage.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import rys.common.util.Reference;

public class MatchHarvestLevel implements ILootCondition {
	
	private int harvestLevel;
	private String harvestTool;
	
	public MatchHarvestLevel(int harvestLevelIn, String harvestToolIn) {
		this.harvestLevel = harvestLevelIn;
		this.harvestTool = harvestToolIn;
	}
	
	public boolean test(LootContext context) {
		ItemStack stack = context.get(LootParameters.TOOL);
		String name = stack.getItem().getRegistryName().toString();
		return stack != null && getLevel(name) >= this.harvestLevel && name.contains(this.harvestTool) && stack.getItem() instanceof ToolItem;
	}
	
	private static int getLevel(String name) {
		if (name.contains("wooden") || name.contains("golden")) {
			return 1;
		}
		if (name.contains("stone")) {
			return 2;
		}
		if (name.contains("iron")) {
			return 3;
		}
		if (name.contains("diamond")) {
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
			json.addProperty("harvest_tool", value.harvestTool);
		}
		
		public MatchHarvestLevel deserialize(JsonObject json, JsonDeserializationContext context) {
			int harvestLevelIn = json.get("harvest_level").getAsInt();
			String harvestToolIn = json.get("harvest_tool").getAsString();
			return new MatchHarvestLevel(harvestLevelIn, harvestToolIn);
		}
		
	}
	
}
