package group.rys.core.registry.other;

import group.rys.client.renderer.GathererAntRenderer;
import group.rys.common.entity.GathererAntEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static void register() {
		RenderingRegistry.registerEntityRenderingHandler(GathererAntEntity.class, GathererAntRenderer::new);
	}
	
}
