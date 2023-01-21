package alisalab.mergedstats;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergedStats implements ModInitializer {

    public static final String MOD_ID = "mergedstats";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from MergedStats!");

        initializeRegistry();
    }

    private void initializeRegistry() {
        registerCustomStat(CustomStats.MINED_STONES_TOTAL);
        registerCustomStat(CustomStats.MINED_STONES_OVERWORLD);
        registerCustomStat(CustomStats.MINED_STONES_NETHER);
        registerCustomStat(CustomStats.PLAY_TIME_MINUTES);
        registerCustomStat(CustomStats.TRAVEL_ALL_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_SELF_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_SELF_GROUND_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_SELF_WATER_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_RIDE_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_RIDE_ANIMAL_DISTANCE);
        registerCustomStat(CustomStats.TRAVEL_RIDE_TRANSPORTATION_DISTANCE);

        ServerTickEvents.END_SERVER_TICK.register((listener) -> StatsUpdater.update(listener.getPlayerManager()));
    }

    private static void registerCustomStat(Identifier identifier) {
        Registry.register(Registries.CUSTOM_STAT, identifier.getPath(), identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, StatFormatter.DEFAULT);
    }
}
