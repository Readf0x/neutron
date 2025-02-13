package org.foxtrot.neutron.items

import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.MobSpawnType
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import org.foxtrot.neutron.entity.Entities

class BlackHoleSpawner(properties: Properties) : Item(properties) {
    override fun useOn(context: UseOnContext): InteractionResult {
        if (!(context.level is ServerLevel)) {
            return InteractionResult.SUCCESS
        }
        Entities.BLACK_HOLE.spawn(context.level as ServerLevel, context.clickedPos, MobSpawnType.SPAWN_EGG)
        return InteractionResult.SUCCESS
    }
}