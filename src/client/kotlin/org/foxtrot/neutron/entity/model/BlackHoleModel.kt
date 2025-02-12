package org.foxtrot.neutron.entity.model

import com.google.common.collect.ImmutableList
import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import net.minecraft.client.model.EntityModel
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.model.geom.PartNames
import net.minecraft.client.model.geom.PartPose
import net.minecraft.client.model.geom.builders.CubeListBuilder
import net.minecraft.client.model.geom.builders.LayerDefinition
import net.minecraft.client.model.geom.builders.MeshDefinition
import net.minecraft.client.model.geom.builders.PartDefinition
import org.foxtrot.neutron.entity.BlackHole

class BlackHoleModel(modelPart: ModelPart) : EntityModel<BlackHole>() {
    private val base: ModelPart

    init {
        this.base = modelPart.getChild(PartNames.CUBE)
    }
    companion object {
        fun getTexturedModelData(): LayerDefinition {
            val modelData = MeshDefinition()
            val modelPartData: PartDefinition = modelData.root
            modelPartData.addOrReplaceChild(
                PartNames.CUBE,
                CubeListBuilder.create()
                    .texOffs(0,0)
                    .addBox(-6F, 12F, -6F, 12F, 12F, 12F),
                PartPose.offset(0F, 0F, 0F)
            )
            return LayerDefinition.create(modelData, 64, 64)
        }
    }

    override fun setupAnim(entity: BlackHole, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {}

    override fun renderToBuffer(poseStack: PoseStack, buffer: VertexConsumer, packedLight: Int, packedOverlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        return ImmutableList.of(base).forEach(fun(modelRenderer) {
            modelRenderer.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
        })
    }
}