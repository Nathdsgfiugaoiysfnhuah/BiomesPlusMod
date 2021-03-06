package naenaenz.biomes.plus;

import naenaenz.biomes.plus.registry.RegisterEntities;
import naenaenz.biomes.plus.registry.RegisterItems;
import naenaenz.biomes.plus.registry.RegisterModels;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiomesPlusMain implements ModInitializer, ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("biomesplus");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		GeckoLib.initialize();
		new RegisterItems().Register();
		new RegisterEntities().Register();
	}

	@Override
	public void onInitializeClient() {
		new RegisterModels().Register();
	}
}
