package chronos.mixins;

import chronos.ChronosSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.world.ClientChunkManager$ClientChunkMap")
public class ClientChunkManagerMixin {

    @Inject(method = "isInRadius", at = @At("HEAD"), cancellable = true)
    public void alwaysInRadius(int chunkX, int chunkZ, CallbackInfoReturnable<Boolean> cir) {
        if (ChronosSettings.squareViewDistance) cir.setReturnValue(true);
    }

}
