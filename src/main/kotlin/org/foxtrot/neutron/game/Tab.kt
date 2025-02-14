package org.foxtrot.neutron.game

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import org.foxtrot.neutron.Neutron
import org.foxtrot.neutron.blocks.Blocks

object Tab {
    val GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation(
        Neutron.MOD_ID, "neutron"))
    val GROUP: CreativeModeTab = FabricItemGroup.builder()
        .icon { ItemStack(net.minecraft.world.item.Items.OBSIDIAN) }
        .title(Component.translatable("itemGroup.neutron"))
        .build()

    fun init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, GROUP_KEY, GROUP)

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY)
            .register(fun(itemGroup){
                itemGroup.accept(Blocks.PORTAL_BLOCK.asItem())
                itemGroup.accept(Blocks.PILLAR_TEST.asItem())
            })
    }
}