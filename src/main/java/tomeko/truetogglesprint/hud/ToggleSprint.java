package tomeko.truetogglesprint.hud;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
//? if >= 26.1 {
/*import net.minecraft.client.gui.GuiGraphicsExtractor;
*///?} else {
import net.minecraft.client.gui.GuiGraphics;
//?}
//? if >= 1.21.11 {
/*import net.minecraft.resources.Identifier;
*///?} else {
import net.minecraft.resources.ResourceLocation;
//?}
import tomeko.truetogglesprint.config.TrueToggleSprintConfig;
import tomeko.truetogglesprint.utils.Constants;

public class ToggleSprint {
    public static void register() {
        //? if >= 1.21.11 {
        /*HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(Constants.MOD_ID, "before_chat"), ToggleSprint::render);
        *///?} else {
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "before_chat"), ToggleSprint::render);
        //?}
        ClientTickEvents.START_CLIENT_TICK.register(ToggleSprint::sprint);
        ClientTickEvents.END_CLIENT_TICK.register(ToggleSprint::sprint);
    }

    //? if >= 26.1 {
    /*private static void render(GuiGraphicsExtractor context, DeltaTracker tickDelta) {
    *///?} else {
    private static void render(GuiGraphics context, DeltaTracker tickDelta) {
        //?}
        Minecraft client = Minecraft.getInstance();
        if (!TrueToggleSprintConfig.toggleSprintEnabled || client.player == null) {
            return;
        }

        int x = (int) (TrueToggleSprintConfig.toggleSprintTextWidthPercentage * client.getWindow().getGuiScaledWidth() / 100);
        int y = (int) (TrueToggleSprintConfig.toggleSprintTextHeightPercentage * client.getWindow().getGuiScaledHeight() / 100);
        float scale = TrueToggleSprintConfig.toggleSprintScale / 100;

        context.pose().pushMatrix();
        context.pose().scale(scale, scale);

        //? if >= 26.1 {
        /*context.text(
        *///?} else {
        context.drawString(
                //?}
                client.font,
                TrueToggleSprintConfig.toggleSprintText,
                (int) (x / scale),
                (int) (y / scale),
                TrueToggleSprintConfig.toggleSprintTextColor.getRGB(),
                TrueToggleSprintConfig.toggleSprintTextShadowEnabled
        );

        context.pose().popMatrix();
    }

    private static void sprint(Minecraft client) {
        if (!TrueToggleSprintConfig.toggleSprintEnabled || client.player == null) {
            return;
        }

        client.player.setSprinting(client.player.input.hasForwardImpulse());
    }
}
