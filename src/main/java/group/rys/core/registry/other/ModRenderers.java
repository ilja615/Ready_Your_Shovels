package group.rys.core.registry.other;

import group.rys.client.renderer.GathererAntRenderer;
import group.rys.client.renderer.HuntingAntLarvaeRenderer;
import group.rys.client.renderer.HuntingAntRenderer;
import group.rys.client.renderer.QueenAntRenderer;
import group.rys.common.entity.GathererAntEntity;
import group.rys.common.entity.HuntingAntEntity;
import group.rys.common.entity.HuntingAntLarvaeEntity;
import group.rys.common.entity.QueenAntEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModRenderers {
	
	public static void register() {
		RenderingRegistry.registerEntityRenderingHandler(GathererAntEntity.class, GathererAntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HuntingAntEntity.class, HuntingAntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(QueenAntEntity.class, QueenAntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HuntingAntLarvaeEntity.class, HuntingAntLarvaeRenderer::new);
	}
	
}
