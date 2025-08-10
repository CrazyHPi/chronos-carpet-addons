package chronos.mixins;

import chronos.ChronosSettings;
import net.minecraft.server.network.ChunkFilter;
import net.minecraft.server.world.ServerChunkLoadingManager;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerChunkLoadingManager.class)
public class ServerChunkLoadingManagerMixin {

    @Redirect(method = "sendToPlayers", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ChunkFilter;isWithinDistance(Lnet/minecraft/util/math/ChunkPos;)Z"))
    public boolean alwaysWithinDistance(ChunkFilter instance, ChunkPos pos) {
        if (ChronosSettings.squareViewDistance) {
            return true;
        } else {
            return instance.isWithinDistance(pos);
        }
    }

}
