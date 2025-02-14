package org.foxtrot.neutron.blocks

import com.simibubi.create.content.kinetics.BlockStressDefaults
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import org.foxtrot.neutron.Neutron
import org.foxtrot.neutron.blocks.suIntakeTest.SUIntakeTestBlock

object Blocks {
    private fun register(block: Block, name: String, shouldRegisterItem: Boolean): Block {
        val id = ResourceLocation(Neutron.MOD_ID, name)
        if (shouldRegisterItem) {
            val blockItem = BlockItem(block, Item.Properties())
            Registry.register(BuiltInRegistries.ITEM, id, blockItem)

        }
        return Registry.register(BuiltInRegistries.BLOCK, id, block)
    }

    val PORTAL_BLOCK = register(
        Block(BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK)),
        "portal_block",
        true
    )
    val PILLAR_TEST = register(
        RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK)),
        "pillar_test",
        true
    )
    val SU_INTAKE_TEST_BLOCK = Neutron.REGISTRATE.block<SUIntakeTestBlock>("su_intake_test", ::SUIntakeTestBlock)
        .transform(BlockStressDefaults.setImpact(16.0))
        .register()

    fun init() {
        Blocks.NETHER_PORTAL
    }
}