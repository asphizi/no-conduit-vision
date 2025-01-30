package io.github.asphizi.no_conduit_vision;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.asphizi.no_conduit_vision.NoConduitVisionConfig;

public class NoConduitVisionClient implements ClientModInitializer {
	public static final String MOD_ID = "no-conduit-vision";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final NoConduitVisionConfig CONFIG = NoConduitVisionConfig.createAndLoad();

	private static KeyBinding toggleKeyBinding;

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("No Conduit Vision loaded!");

		toggleKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.no-conduit-vision.toggle",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_UNKNOWN,
				"category.no-conduit-vision.no-conduit-vision"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleKeyBinding.wasPressed()) {
				CONFIG.conduitVisionEnabled(!CONFIG.conduitVisionEnabled());
			}
		});
	}

	public static boolean isConduitVisionEnabled() {
		return CONFIG.conduitVisionEnabled();
	}
}