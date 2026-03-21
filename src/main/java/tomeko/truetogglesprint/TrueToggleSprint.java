package tomeko.truetogglesprint;

import net.fabricmc.api.ClientModInitializer;
import tomeko.truetogglesprint.config.*;
import tomeko.truetogglesprint.hud.*;
import tomeko.truetogglesprint.keybinds.*;

public class TrueToggleSprint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TrueToggleSprintConfig.register();

		ToggleSprint.register();

		ToggleSprintKeybind.register();
	}
}