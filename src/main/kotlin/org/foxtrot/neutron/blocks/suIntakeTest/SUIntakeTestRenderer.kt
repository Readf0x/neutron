package org.foxtrot.neutron.blocks.suIntakeTest

import com.mojang.blaze3d.vertex.PoseStack
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.core.BlockPos
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.LightLayer
import net.minecraft.world.phys.Vec3


class SUIntakeTestRenderer(context: BlockEntityRendererProvider.Context?) : KineticBlockEntityRenderer<SUIntakeTestBlockEntity>(context) {
    override fun renderSafe(be: SUIntakeTestBlockEntity?, partialTicks: Float, ms: PoseStack?, buffer: MultiBufferSource?, light: Int, overlay: Int) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay)
    }
    private fun renderOnSides(ms: PoseStack, buffer: MultiBufferSource, be: SUIntakeTestBlockEntity, renderedItem: ItemStack, overlay: Int, translations: Array<Vec3>, sidePositions: Array<BlockPos>) {
        val level: Level = be.getLevel() ?: return

        for (i in translations.indices) {
            // Calculates the light for tihs side. IDK why it works
            val blockBright: Int = level.getBrightness(LightLayer.BLOCK, sidePositions[i])
            val skyBright: Int = level.getBrightness(LightLayer.SKY, sidePositions[i])

            val light = (skyBright shl 20) + (blockBright shl 4)

            ms.pushPose()
            ms.translate(translations[i].x, translations[i].y, translations[i].z) // Adjust position
            ms.scale(0.5f, 0.5f, 0.5f)
            Minecraft.getInstance().itemRenderer.renderStatic(renderedItem, ItemDisplayContext.FIXED, light, overlay, ms, buffer, be.getLevel(), 0)
            ms.popPose()
        }
    }
}