package org.foxtrot.neutron.entity

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.*
import org.foxtrot.neutron.Neutron

object Entities : ModInitializer {
    fun <T : Entity?>register(value: EntityType<T>, name: String): EntityType<T> {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation(Neutron.MOD_ID, name), value)
    }

    val BLACK_HOLE = register(
        FabricEntityTypeBuilder.create<BlackHole>(MobCategory.MISC)
            .fireImmune()
            .dimensions(EntityDimensions(0.75F, 0.75F, false))
            .build(),
        "black_hole"
    )

    override fun onInitialize() {}
}