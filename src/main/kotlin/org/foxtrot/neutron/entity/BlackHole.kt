package org.foxtrot.neutron.entity

import net.minecraft.nbt.CompoundTag
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.level.Level

class BlackHole(entityType: EntityType<BlackHole>, level: Level) : Entity(entityType, level) {
    // Entropy
    private val dataEntropy = SynchedEntityData.defineId(BlackHole::class.java, EntityDataSerializers.INT)
    private val defaultEntropy = 0
    var Entropy: Short
        get() = this.entityData.get(dataEntropy).toShort()
        set(value) = this.entityData.set(dataEntropy, value.toInt())

    // Density
    private val dataDensity = SynchedEntityData.defineId(BlackHole::class.java, EntityDataSerializers.LONG)
    private val defaultDensity: Long = 1000
    var Density: Long
        get() = this.entityData.get(dataDensity)
        set(value) = this.entityData.set(dataDensity, value)

    // NBT Tags
    override fun defineSynchedData() {
        this.entityData.define(dataEntropy, defaultEntropy)
        this.entityData.define(dataDensity, defaultDensity)
    }
    override fun readAdditionalSaveData(compound: CompoundTag) {
        compound.putShort("Entropy", Entropy)
        compound.putLong("Density", Density)
    }
    override fun addAdditionalSaveData(compound: CompoundTag) {
        Entropy = compound.getShort("Entropy")
        Density = compound.getLong("Density")
    }
}