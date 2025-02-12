package org.foxtrot.neutron.game

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry
import net.minecraft.world.level.GameRules

object Gamerules {
    val VANILLA_PORTALS: GameRules.Key<GameRules.BooleanValue> = GameRuleRegistry.register("vanillaPortals", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false))

    fun init() {}
}