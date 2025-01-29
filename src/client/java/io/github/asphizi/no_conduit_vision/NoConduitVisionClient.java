package io.github.asphizi.no_conduit_vision;

import net.fabricmc.api.ClientModInitializer;

public class NoConduitVisionClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}

	public static boolean isConduitVisionEnabled() {
		// TODO: client-side configuration, such as a config file and a keybind that toggles the effect.
		return false;
	}
}