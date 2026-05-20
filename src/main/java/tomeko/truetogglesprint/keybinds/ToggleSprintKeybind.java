package tomeko.truetogglesprint.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//? if >= 26.1 {
/*import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
*///?} else {
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
//?}
import net.minecraft.client.KeyMapping;
//? if >= 1.21.11 {
/*import net.minecraft.resources.Identifier;
*///?} else {
import net.minecraft.resources.ResourceLocation;
//?}
import org.lwjgl.glfw.GLFW;
import tomeko.truetogglesprint.config.TrueToggleSprintConfig;
import tomeko.truetogglesprint.utils.Constants;

public class ToggleSprintKeybind {
    private static KeyMapping toggleSprintKey;

    public static void register() {
        toggleSprintKey =
                //? if >= 26.1 {
                /*KeyMappingHelper.registerKeyMapping
                *///?} else {
                KeyBindingHelper.registerKeyBinding
                        //?}
                                (new KeyMapping(
                                        "key.category.truetogglesprint.togglesprint",
                                        InputConstants.Type.KEYSYM,
                                        GLFW.GLFW_KEY_M,
                                        //? if >= 1.21.11 {
                                        /*KeyMapping.Category.register(Identifier.parse(Constants.MOD_ID))
                                        *///?} else {
                                        KeyMapping.Category.register(ResourceLocation.parse(Constants.MOD_ID))
                                        //?}
                                ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleSprintKey.consumeClick()) {
                TrueToggleSprintConfig.toggleSprintEnabled = !TrueToggleSprintConfig.toggleSprintEnabled;
                TrueToggleSprintConfig.CONFIG.save();
            }
        });
    }
}
