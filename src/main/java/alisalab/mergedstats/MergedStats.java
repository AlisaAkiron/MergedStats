package alisalab.mergedstats;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergedStats implements ModInitializer {

    public static final String MOD_ID = "assets/mergedstats";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from MergedStats!");
    }
}
