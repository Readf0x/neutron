package org.foxtrot.neutron

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block

object Blocks {
    private fun register(block: Block, id: String): Block {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation(Neutron.MOD_ID, id), block)
    }

    val BLOCK = register()

    fun init() {
    }
}