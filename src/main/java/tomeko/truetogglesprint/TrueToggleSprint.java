package tomeko.truetogglesprint;

import net.fabricmc.api.ClientModInitializer;
import tomeko.truetogglesprint.config.TrueToggleSprintConfig;

public class TrueToggleSprint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TrueToggleSprintConfig.register();
	}
}