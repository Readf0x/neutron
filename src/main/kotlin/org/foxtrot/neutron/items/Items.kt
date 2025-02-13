package org.foxtrot.neutron.items

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.item.SpawnEggItem
import org.foxtrot.neutron.Neutron
import org.foxtrot.neutron.entity.Entities

object Items : ModInitializer {
    fun register(value: Item, name: String): Item {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation(Neutron.MOD_ID, name), value)
    }

    val BLACK_HOLE_SPAWNER = register(
        BlackHoleSpawner(FabricItemSettings()), "black_hole_spawner"
    )

    override fun onInitialize() {}
}