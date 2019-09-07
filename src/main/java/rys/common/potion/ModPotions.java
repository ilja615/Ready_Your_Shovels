package rys.common.potion;

import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import rys.common.item.ModItems;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MOD_ID)
public class ModPotions {
	
	public static final Potion decrease_debuff = create("decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 1)));
	public static final Potion strong_decrease_debuff = create("strong_decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 3)));
	public static final Potion increase_buff = create("increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 1)));
	public static final Potion strong_increase_buff = create("strong_increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 3)));
	public static final Potion increase_debuff = create("increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 1)));
	public static final Potion strong_increase_debuff = create("strong_increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 3)));
	public static final Potion decrease_buff = create("decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 1)));
	public static final Potion strong_decrease_buff = create("strong_decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 3)));
	
	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		IForgeRegistry<Potion> registry = event.getRegistry();
		
		registry.register(decrease_debuff);
		registry.register(strong_decrease_debuff);
		registry.register(increase_buff);
		registry.register(strong_increase_buff);
		registry.register(increase_debuff);
		registry.register(strong_increase_debuff);
		registry.register(decrease_buff);
		registry.register(strong_decrease_buff);
	}
	
	public static Potion create(String name, Potion potion) {
		potion.setRegistryName(Reference.MOD_ID, name);
		return potion;
	}
	
	public static void registerPotionRecipes() {
		createAllPotionRecipes(ModItems.orange, decrease_debuff, null, strong_decrease_debuff);
		createAllPotionRecipes(ModItems.apricot, increase_buff, null, strong_increase_buff);
		createAllPotionRecipes(ModItems.rotten_orange, increase_debuff, null, strong_increase_debuff);
		createAllPotionRecipes(ModItems.rotten_apricot, decrease_buff, null, strong_decrease_buff);
	}
	
	public static void createAllPotionRecipes(Item item, Potion potion, @Nullable Potion long_potion, @Nullable Potion strong_potion) {
		createPotionRecipe(item, potion, long_potion, strong_potion);
		createSplashPotionRecipe(item, potion, long_potion, strong_potion);
		createLingeringPotionRecipe(item, potion, long_potion, strong_potion);
	}
	
	public static void createPotionRecipe(Item item, Potion potion, @Nullable Potion long_potion, @Nullable Potion strong_potion) {
		Ingredient input_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.AWKWARD));
		Ingredient input_2 = Ingredient.fromStacks(new ItemStack(item));
		ItemStack output = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion);
		
		BrewingRecipeRegistry.addRecipe(input_1, input_2, output);
		
		if (long_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.REDSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), long_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
		
		if (strong_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), strong_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
	}
	
	public static void createSplashPotionRecipe(Item item, Potion potion, @Nullable Potion long_potion, @Nullable Potion strong_potion) {
		Ingredient input_0_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.AWKWARD));
		Ingredient input_0_2 = Ingredient.fromStacks(new ItemStack(item));
		
		Ingredient input_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion));
		Ingredient input_2 = Ingredient.fromStacks(new ItemStack(Items.GUNPOWDER));
		
		ItemStack output = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion);
		
		BrewingRecipeRegistry.addRecipe(input_0_1, input_0_2, output);
		BrewingRecipeRegistry.addRecipe(input_1, input_2, output);
		
		if (long_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.REDSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), long_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
		
		if (strong_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), strong_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
	}
	
	public static void createLingeringPotionRecipe(Item item, Potion potion, @Nullable Potion long_potion, @Nullable Potion strong_potion) {
		Ingredient input_0_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), Potions.AWKWARD));
		Ingredient input_0_2 = Ingredient.fromStacks(new ItemStack(item));
		
		Ingredient input_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
		Ingredient input_2 = Ingredient.fromStacks(new ItemStack(Items.DRAGON_BREATH));
		
		ItemStack output = PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), potion);
		
		BrewingRecipeRegistry.addRecipe(input_0_1, input_0_2, output);
		BrewingRecipeRegistry.addRecipe(input_1, input_2, output);
		
		if (long_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.REDSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), long_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
		
		if (strong_potion != null) {
			Ingredient i_1 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), potion));
			Ingredient i_2 = Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE));
			ItemStack o = PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), strong_potion);
			
			BrewingRecipeRegistry.addRecipe(i_1, i_2, o);
		}
	}
	
}
