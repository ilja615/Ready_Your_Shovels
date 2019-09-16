package rys.common.potion;

import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
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
	
	public static final Potion decrease_debuff = create("decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 0)));
	public static final Potion strong_decrease_debuff = create("strong_decrease_debuff", new Potion(new EffectInstance(ModEffects.decrease_debuff, 1, 1)));
	public static final Potion increase_buff = create("increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 0)));
	public static final Potion strong_increase_buff = create("strong_increase_buff", new Potion(new EffectInstance(ModEffects.increase_buff, 1, 1)));
	public static final Potion increase_debuff = create("increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 0)));
	public static final Potion strong_increase_debuff = create("strong_increase_debuff", new Potion(new EffectInstance(ModEffects.increase_debuff, 1, 1)));
	public static final Potion decrease_buff = create("decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 0)));
	public static final Potion strong_decrease_buff = create("strong_decrease_buff", new Potion(new EffectInstance(ModEffects.decrease_buff, 1, 1)));
	
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
	
	public static <T extends Potion> T create(String name, T potion) {
		potion.setRegistryName(Reference.MOD_ID, name);
		return potion;
	}
	
	public static void registerPotionRecipes() {
		PotionBrewing.addMix(Potions.AWKWARD, ModItems.orange, ModPotions.decrease_debuff);
		PotionBrewing.addMix(ModPotions.decrease_debuff, Items.GLOWSTONE_DUST, ModPotions.strong_decrease_debuff);
		
		PotionBrewing.addMix(Potions.AWKWARD, ModItems.apricot, ModPotions.increase_buff);
		PotionBrewing.addMix(ModPotions.increase_buff, Items.GLOWSTONE_DUST, ModPotions.strong_increase_buff);
		
		PotionBrewing.addMix(Potions.AWKWARD, ModItems.rotten_orange, ModPotions.increase_debuff);
		PotionBrewing.addMix(ModPotions.increase_debuff, Items.GLOWSTONE_DUST, ModPotions.strong_increase_debuff);
		
		PotionBrewing.addMix(Potions.AWKWARD, ModItems.rotten_apricot, ModPotions.decrease_buff);
		PotionBrewing.addMix(ModPotions.decrease_buff, Items.GLOWSTONE_DUST, ModPotions.strong_decrease_buff);
		
//		createPotionRecipes(ModItems.orange, ModPotions.decrease_debuff);
//		createStrongPotionRecipes(ModPotions.decrease_debuff, ModPotions.strong_decrease_debuff);
//		
//		createPotionRecipes(ModItems.apricot, ModPotions.increase_buff);
//		createStrongPotionRecipes(ModPotions.increase_buff, ModPotions.strong_increase_buff);
//		
//		createPotionRecipes(ModItems.rotten_orange, ModPotions.increase_debuff);
//		createStrongPotionRecipes(ModPotions.increase_debuff, ModPotions.strong_increase_debuff);
//		
//		createPotionRecipes(ModItems.rotten_apricot, ModPotions.decrease_buff);
//		createStrongPotionRecipes(ModPotions.decrease_buff, ModPotions.strong_decrease_buff);
	}
	
//	public static void createPotionRecipe(Item item, Item type_1, Potion potion_1, Item type_2, Potion potion_2) {
//		Ingredient input_1 = Ingredient.fromStacks(new ItemStack(item));
//		Ingredient input_2 = Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(type_1), potion_1));
//		ItemStack output = PotionUtils.addPotionToItemStack(new ItemStack(type_2), potion_2);
//		
//		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(input_2, input_1, output));
//	}
//	
//	public static void createPotionRecipes(Item item, Potion potion) {
//		createPotionRecipe(item, Items.POTION, Potions.AWKWARD, Items.POTION, potion);
//		createPotionRecipe(item, Items.SPLASH_POTION, Potions.AWKWARD, Items.SPLASH_POTION, potion);
//		createPotionRecipe(item, Items.LINGERING_POTION, Potions.AWKWARD, Items.LINGERING_POTION, potion);
//		
//		createPotionRecipe(Items.GUNPOWDER, Items.POTION, potion, Items.SPLASH_POTION, potion);
//		createPotionRecipe(Items.DRAGON_BREATH, Items.SPLASH_POTION, potion, Items.LINGERING_POTION, potion);
//	}
//	
//	public static void createLongPotionRecipes(Potion potion, Potion long_potion) {
//		createPotionRecipe(Items.REDSTONE, Items.POTION, potion, Items.POTION, long_potion);
//		createPotionRecipe(Items.REDSTONE, Items.SPLASH_POTION, potion, Items.SPLASH_POTION, long_potion);
//		createPotionRecipe(Items.REDSTONE, Items.LINGERING_POTION, potion, Items.LINGERING_POTION, long_potion);
//		
//		createPotionRecipe(Items.GUNPOWDER, Items.POTION, long_potion, Items.SPLASH_POTION, long_potion);
//		createPotionRecipe(Items.DRAGON_BREATH, Items.SPLASH_POTION, long_potion, Items.LINGERING_POTION, long_potion);
//	}
//	
//	public static void createStrongPotionRecipes(Potion potion, Potion strong_potion) {
//		createPotionRecipe(Items.GLOWSTONE_DUST, Items.POTION, potion, Items.POTION, strong_potion);
//		createPotionRecipe(Items.GLOWSTONE_DUST, Items.SPLASH_POTION, potion, Items.SPLASH_POTION, strong_potion);
//		createPotionRecipe(Items.GLOWSTONE_DUST, Items.LINGERING_POTION, potion, Items.LINGERING_POTION, strong_potion);
//		
//		createPotionRecipe(Items.GUNPOWDER, Items.POTION, strong_potion, Items.SPLASH_POTION, strong_potion);
//		createPotionRecipe(Items.DRAGON_BREATH, Items.SPLASH_POTION, strong_potion, Items.LINGERING_POTION, strong_potion);
//	}
	
}
