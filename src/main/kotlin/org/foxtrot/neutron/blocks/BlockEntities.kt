package org.foxtrot.neutron.blocks

import com.tterrag.registrate.util.nullness.NonNullFunction
import org.foxtrot.neutron.Neutron
import org.foxtrot.neutron.blocks.suIntakeTest.SUIntakeTestBlockEntity
import org.foxtrot.neutron.blocks.suIntakeTest.SUIntakeTestInstance
import org.foxtrot.neutron.blocks.suIntakeTest.SUIntakeTestRenderer
import java.util.function.BiFunction

object BlockEntities {
    val SU_INTAKE_TEST = Neutron.REGISTRATE
        .blockEntity<SUIntakeTestBlockEntity>("su_intake_test", ::SUIntakeTestBlockEntity)
        .instance { BiFunction{ a, b -> SUIntakeTestInstance(a, b) } }
        .validBlocks(SU_INTAKE_TEST_BLOCK)
        .renderer { NonNullFunction { a -> SUIntakeTestRenderer(a) } }
        .build()
}