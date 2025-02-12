package org.foxtrot.neutron

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.resources.ResourceLocation
import org.foxtrot.neutron.entity.Entities
import org.foxtrot.neutron.entity.model.BlackHoleModel
import org.foxtrot.neutron.entity.renderer.BlackHoleRenderer

object NeutronClient : ClientModInitializer {
	val MODEL_BLACK_HOLE_LAYER = ModelLayerLocation(ResourceLocation(Neutron.MOD_ID, "black_hole"), "main")
	override fun onInitializeClient() {
		EntityRendererRegistry.register(Entities.BLACK_HOLE, fun(context): BlackHoleRenderer { return BlackHoleRenderer(context) })
		EntityModelLayerRegistry.registerModelLayer(MODEL_BLACK_HOLE_LAYER, BlackHoleModel::getTexturedModelData)
	}
}