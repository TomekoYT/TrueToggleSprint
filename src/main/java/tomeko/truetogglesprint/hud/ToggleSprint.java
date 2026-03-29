package tomeko.truetogglesprint.hud;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import tomeko.truetogglesprint.config.TrueToggleSprintConfig;

public class ToggleSprint {
    public static void register() {
        HudRenderCallback.EVENT.register(ToggleSprint::render);
        ClientTickEvents.START_CLIENT_TICK.register(ToggleSprint::sprint);
        ClientTickEvents.END_CLIENT_TICK.register(ToggleSprint::sprint);
    }

    private static void render(GuiGraphics context, DeltaTracker tickDelta) {
        Minecraft client = Minecraft.getInstance();
        if (!TrueToggleSprintConfig.toggleSprintEnabled || client.player == null) {
            return;
        }

        context.drawString(client.font, TrueToggleSprintConfig.toggleSprintText, (int) (TrueToggleSprintConfig.toggleSprintTextWidthPercentage * client.getWindow().getGuiScaledWidth() / 100), (int) (TrueToggleSprintConfig.toggleSprintTextHeightPercentage * client.getWindow().getGuiScaledHeight() / 100), TrueToggleSprintConfig.toggleSprintTextColor.getRGB(), TrueToggleSprintConfig.toggleSprintTextShadowEnabled);
    }

    private static void sprint(Minecraft client) {
        if (!TrueToggleSprintConfig.toggleSprintEnabled || client.player == null) {
            return;
        }

        client.player.setSprinting(client.player.input.hasForwardImpulse());
    }
}
