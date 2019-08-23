package rys.common.init;

import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import rys.common.item.ModItems;
import rys.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
	
	@SubscribeEvent
	public static void addFurnaceFuel(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ModItems.peat) {
			event.setBurnTime(800);
		}
	}
	
}
