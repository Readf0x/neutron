package org.foxtrot.neutron.mixin;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.portal.PortalShape;
import org.foxtrot.neutron.Blocks;
import org.foxtrot.neutron.Gamerules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PortalShape.class)
public class PortalMixin {
    @Shadow @Final private LevelAccessor level;
//    private static final BlockBehaviour.StatePredicate NEW_FRAME = (blockState, blockGetter, blockPos) -> blockState.is(Blocks.INSTANCE.getPORTAL_BLOCK())

    @Inject(method = "createPortalBlocks", at = @At(value = "HEAD"), cancellable = true)
    private void createPortalBlocks(CallbackInfo ci) {
        if (!level.getLevelData().getGameRules().getBoolean(Gamerules.INSTANCE.getVANILLA_PORTALS()))
            ci.cancel();
    }
}