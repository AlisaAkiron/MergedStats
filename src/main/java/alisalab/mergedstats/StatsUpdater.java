package alisalab.mergedstats;

import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

/**
 * Event listener
 */
public final class StatsUpdater {

    /**
     * Update players stats value
     * @param playerManager The player manager
     */
    public static void update(PlayerManager playerManager) {

        var playerList = playerManager.getPlayerList();

        for (ServerPlayerEntity p : playerList) {
            StatsHelper.updatePlayerData(p);
        }

    }
}
