package org.foxtrot.neutron

import com.simibubi.create.Create
import net.fabricmc.api.ModInitializer
import org.foxtrot.neutron.blocks.Blocks
import org.foxtrot.neutron.entity.Entities
import org.foxtrot.neutron.game.Gamerules
import org.foxtrot.neutron.game.Tab
import org.foxtrot.neutron.items.Items
import org.slf4j.LoggerFactory

object Neutron : ModInitializer {
	const val MOD_ID: String = "neutron"
	const val NAME: String = "Neutron"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Create mod addon [{}] is loading alongside Create [{}]!", NAME, Create.VERSION)

		Gamerules.init()
		Tab.init()
		Items.init()
		Blocks.init()
		Entities.init()
	}
}