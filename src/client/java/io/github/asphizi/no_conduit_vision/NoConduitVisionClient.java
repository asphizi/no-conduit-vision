package io.github.asphizi.no_conduit_vision;

import io.github.asphizi.no_conduit_vision.NoConduitVisionConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoConduitVisionClient implements ClientModInitializer {
	public static final String MOD_ID = "no-conduit-vision";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final NoConduitVisionConfig CONFIG = NoConduitVisionConfig.createAndLoad();

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("No Conduit Vision loaded!");
	}

	public static boolean isConduitVisionEnabled() {
		return CONFIG.conduitVisionEnabled();
	}
}