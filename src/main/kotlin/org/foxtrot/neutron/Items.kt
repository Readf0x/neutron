package org.foxtrot.neutron

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraft.world.item.Items
import java.lang.reflect.Modifier
import kotlin.reflect.full.memberProperties
import kotlin.reflect.typeOf

object Items {
    private fun register(item: Item, id: String): Item {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation(Neutron.MOD_ID, id), item)
    }

    val GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation(Neutron.MOD_ID, "neutron"))
    val GROUP: CreativeModeTab = FabricItemGroup.builder()
        .icon({ ItemStack(Items.OBSIDIAN) })
        .title(Component.translatable("itemGroup.neutron"))
        .build()

    fun init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, GROUP_KEY, GROUP)

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY)
            .register(fun(itemGroup){
            })
    }
}