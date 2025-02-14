package org.foxtrot.neutron.blocks.suIntakeTest

import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class SUIntakeTestBlockEntity(
    typeIn: BlockEntityType<in SUIntakeTestBlockEntity>?,
    pos: BlockPos?,
    state: BlockState?
) : KineticBlockEntity(typeIn, pos, state) {

}