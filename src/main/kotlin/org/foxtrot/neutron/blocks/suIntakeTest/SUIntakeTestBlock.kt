package org.foxtrot.neutron.blocks.suIntakeTest

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock
import com.simibubi.create.foundation.block.IBE
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import org.foxtrot.neutron.blocks.BlockEntities

class SUIntakeTestBlock(properties: Properties?) : HorizontalKineticBlock(properties), IBE<SUIntakeTestBlockEntity> {
    override fun getRotationAxis(state: BlockState?): Direction.Axis {
        if (state != null) return state.getValue(HORIZONTAL_FACING).axis
        return defaultBlockState().getValue(HORIZONTAL_FACING).axis
    }

    override fun hasShaftTowards(world: LevelReader?, pos: BlockPos?, state: BlockState?, face: Direction?): Boolean {
        if (face != null && state != null) return face.axis == state.getValue(HORIZONTAL_FACING).axis
        return super.hasShaftTowards(world, pos, state, face)
    }

    override fun getBlockEntityClass(): Class<SUIntakeTestBlockEntity> {
        return SUIntakeTestBlockEntity::class.java
    }

    override fun getBlockEntityType(): BlockEntityType<out SUIntakeTestBlockEntity> {
        return BlockEntities.SU_INTAKE_TEST.get()
    }
}