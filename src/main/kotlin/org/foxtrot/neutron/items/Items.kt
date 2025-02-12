package org.foxtrot.neutron.items

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import org.foxtrot.neutron.Neutron

object Items {
    fun register(value: Item, name: String): Item {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation(Neutron.MOD_ID, name), value)
    }

    fun init() {
    }
}