package org.foxtrot.neutron

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object Items {
    fun register(item: Item, id: String): Item {
        val itemID: Identifier = Identifier(CreateNeutron.MOD_ID, id)
        val registeredItem: Item = Registry.register(Registries.ITEM, itemID, item)
        return registeredItem
    }

    val TEST: Item = register(Item(FabricItemSettings().maxCount(9)), "test")

    fun init() {}
}