package org.foxtrot.neutron.blocks.suIntakeTest

import com.jozufozu.flywheel.api.Instancer
import com.jozufozu.flywheel.api.MaterialManager
import com.simibubi.create.AllBlocks
import com.simibubi.create.content.kinetics.base.KineticBlockEntityInstance
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock
import net.minecraft.world.level.block.state.BlockState

class SUIntakeTestInstance(
    materialManager: MaterialManager?,
    blockEntity: SUIntakeTestBlockEntity?
) : KineticBlockEntityInstance<SUIntakeTestBlockEntity>(materialManager, blockEntity) {
    lateinit var shaftModel: RotatingData
    val model: Instancer<RotatingData>
        get() = rotatingMaterial.getModel(getRenderedBlockState)
    val renderedBlockState: BlockState
        get() = AllBlocks.SHAFT.defaultState.setValue(ShaftBlock.AXIS, blockState.getValue(SUIntakeTestBlock.HORIZONTAL_FACING).axis)

    override fun init() {
        shaftModel = setup(this.model.createInstance())
    }
    override fun remove() {
        shaftModel.delete()
    }
}