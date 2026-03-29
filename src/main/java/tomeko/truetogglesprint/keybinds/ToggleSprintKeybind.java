package tomeko.truetogglesprint.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;
import tomeko.truetogglesprint.config.TrueToggleSprintConfig;
import tomeko.truetogglesprint.utils.Constants;

public class ToggleSprintKeybind {
    private static KeyMapping toggleSprintKey;

    public static void register() {
        toggleSprintKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.category.truetogglesprint.togglesprint",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                KeyMapping.Category.register(ResourceLocation.parse(Constants.MOD_ID))
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleSprintKey.consumeClick()) {
                TrueToggleSprintConfig.toggleSprintEnabled = !TrueToggleSprintConfig.toggleSprintEnabled;
                TrueToggleSprintConfig.CONFIG.save();
            }
        });
    }
}
