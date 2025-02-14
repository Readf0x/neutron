package org.foxtrot.neutron.entity

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import org.foxtrot.neutron.Neutron

object Entities {
    fun <T : Entity?>register(value: EntityType<T>, name: String): EntityType<T> {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation(Neutron.MOD_ID, name), value)
    }

    fun init() {
    }
}
