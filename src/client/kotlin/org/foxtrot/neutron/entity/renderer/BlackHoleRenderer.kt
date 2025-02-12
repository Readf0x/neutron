package org.foxtrot.neutron.entity.renderer

import net.minecraft.client.renderer.entity.EntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import org.foxtrot.neutron.Neutron
import org.foxtrot.neutron.entity.BlackHole

class BlackHoleRenderer(context: EntityRendererProvider.Context) : EntityRenderer<BlackHole>(context,) {

    override fun getTextureLocation(entity: BlackHole): ResourceLocation {
        return ResourceLocation(Neutron.MOD_ID, "textures/entity/black_hole/test.png")
    }
}