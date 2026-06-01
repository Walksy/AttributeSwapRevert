package walksy.attributeswaprevert.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import walksy.attributeswaprevert.config.Config;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Redirect(method = "handleKeybinds", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;setSelectedSlotDeferred(I)V"))
    public void setSelectedSlot(Inventory instance, int selected) {
        if (Config.modEnabled) {
            instance.setSelectedSlot(selected);
        } else {
            instance.setSelectedSlotDeferred(selected);
        }
    }
}
