package org.foxtrot.neutron.blocks

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import org.foxtrot.neutron.Neutron

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

    fun init() {
        Blocks.NETHER_PORTAL
    }
}