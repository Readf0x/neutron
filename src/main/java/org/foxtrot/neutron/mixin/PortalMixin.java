package org.foxtrot.neutron.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.portal.PortalShape;
import org.foxtrot.neutron.game.Gamerules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(PortalShape.class)
public class PortalMixin {
    @Shadow @Final private LevelAccessor level;

    @Inject(method = "createPortalBlocks", at = @At(value = "HEAD"), cancellable = true)
    private void createPortalBlocks(CallbackInfo ci) {
        if (!level.getLevelData().getGameRules().getBoolean(Gamerules.INSTANCE.getVANILLA_PORTALS())) {
            Objects.requireNonNull(level.getServer()).getPlayerList().broadcastSystemMessage(Component.literal("Vanilla Portals are disabled by default"), false);
            ci.cancel();
        }
    }

    @Inject(method = "isValid", at = @At(value = "HEAD"), cancellable = true)
    public void isValid(CallbackInfoReturnable<Boolean> cir) {
        boolean gr = level.getLevelData().getGameRules().getBoolean(Gamerules.INSTANCE.getVANILLA_PORTALS());
        if (!gr) cir.setReturnValue(false);
    }
}