package chronos.mixins;

import carpet.CarpetServer;
import chronos.util.CapturedDrops;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "dropStack(Lnet/minecraft/world/World;Ljava/util/function/Supplier;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
    private static void captureDrops(World world, Supplier<ItemEntity> itemEntitySupplier, ItemStack stack, CallbackInfo ci) {
        if (CapturedDrops.isCapturing()) {
            if (CapturedDrops.capture(stack)) {
                PlayerEntity player = CapturedDrops.getPlayer();
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, (CarpetServer.rand.nextFloat() - CarpetServer.rand.nextFloat()) * 1.4F + 2.0F);
                ci.cancel();
            }
        }
    }
}