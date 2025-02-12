package org.foxtrot.neutron

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item

object Items {
    private fun register(item: Item, id: String): Item {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation(Neutron.MOD_ID, id), item)
    }

    fun init() {
    }
}