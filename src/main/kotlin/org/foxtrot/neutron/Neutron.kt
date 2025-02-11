package org.foxtrot.neutron

import com.simibubi.create.Create
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Neutron : ModInitializer {
	const val MOD_ID: String = "neutron"
	const val NAME: String = "Neutron"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Create mod addon [{}] is loading alongside Create [{}]!", NAME, Create.VERSION)

		Items.init()
	}
}