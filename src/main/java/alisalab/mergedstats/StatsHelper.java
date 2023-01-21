package alisalab.mergedstats;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.StatHandler;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

/**
 * Helper class to do stats operation
 */
public final class StatsHelper {

    /**
     * Calculate merged stats and set its value
     * @param p Player entity
     */
    public static void updatePlayerData(ServerPlayerEntity p) {
        var handler = p.getStatHandler();

        var minedStonesOverworld = getMinedStonesOverworld(handler);
        var minedStonesNether = getMinedStonesNether(handler);
        var minedStonesTotal = minedStonesOverworld + minedStonesNether;
        var minedOresOverworld = getMinedOresOverworld(handler);
        var minedOresNether = getMinedOresNether(handler);
        var minedOresTotal = minedOresOverworld + minedOresNether;
        var playTimeMinutes = getPlayTime(handler) / 20 / 60;
        var travelSelfGroundDistance = getSelfGroundDistance(handler);
        var travelSelfWaterDistance = getSelfWaterDistance(handler);
        var travelSelfDistance = travelSelfGroundDistance + travelSelfWaterDistance;
        var travelRideAnimalDistance = getRideAnimalDistance(handler);
        var travelRideTransportationDistance = getRideTransportationDistance(handler);
        var travelRideDistance = travelRideAnimalDistance + travelRideTransportationDistance;
        var travelAllDistance = travelSelfDistance + travelRideDistance;

        updateStatValue(p, CustomStats.MINED_STONES_OVERWORLD, minedStonesOverworld);
        updateStatValue(p, CustomStats.MINED_STONES_NETHER, minedStonesNether);
        updateStatValue(p, CustomStats.MINED_STONES_TOTAL, minedStonesTotal);
        updateStatValue(p, CustomStats.MINED_ORES_OVERWORLD, minedOresOverworld);
        updateStatValue(p, CustomStats.MINED_ORES_NETHER, minedOresNether);
        updateStatValue(p, CustomStats.MINED_ORES_TOTAL, minedOresTotal);
        updateStatValue(p, CustomStats.PLAY_TIME_MINUTES, playTimeMinutes);
        updateStatValue(p, CustomStats.TRAVEL_SELF_GROUND_DISTANCE, travelSelfGroundDistance);
        updateStatValue(p, CustomStats.TRAVEL_SELF_WATER_DISTANCE, travelSelfWaterDistance);
        updateStatValue(p, CustomStats.TRAVEL_SELF_DISTANCE, travelSelfDistance);
        updateStatValue(p, CustomStats.TRAVEL_RIDE_ANIMAL_DISTANCE, travelRideAnimalDistance);
        updateStatValue(p, CustomStats.TRAVEL_RIDE_TRANSPORTATION_DISTANCE, travelRideTransportationDistance);
        updateStatValue(p, CustomStats.TRAVEL_RIDE_DISTANCE, travelRideDistance);
        updateStatValue(p, CustomStats.TRAVEL_ALL_DISTANCE, travelAllDistance);
    }

    private static void updateStatValue(ServerPlayerEntity p, Identifier identifier, int newValue) {
        var oldValue = p.getStatHandler().getStat(Stats.CUSTOM.getOrCreateStat(identifier));
        var increase = newValue - oldValue;
        p.increaseStat(identifier, increase);
    }

    private static int getMinedStonesOverworld(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.STONE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLESTONE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLED_DEEPSLATE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SANDSTONE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.RED_SANDSTONE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GRANITE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DIORITE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.ANDESITE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CALCITE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.TUFF));
    }

    private static int getMinedStonesNether(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.NETHERRACK))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CRIMSON_NYLIUM))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.WARPED_NYLIUM))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SAND))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SOIL))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BLACKSTONE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BASALT))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SMOOTH_BASALT))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GLOWSTONE));
    }

    private static int getMinedOresOverworld(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COAL_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_COAL_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.IRON_BLOCK))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_IRON_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COPPER_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_COPPER_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GOLD_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_GOLD_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.REDSTONE_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_REDSTONE_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.EMERALD_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_EMERALD_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.LAPIS_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_LAPIS_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DIAMOND_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE_DIAMOND_ORE));
    }

    private static int getMinedOresNether(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.NETHER_GOLD_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.NETHER_QUARTZ_ORE))
                + handler.getStat(Stats.MINED.getOrCreateStat(Blocks.ANCIENT_DEBRIS));
    }

    private static int getPlayTime(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PLAY_TIME));
    }

    private static int getSelfGroundDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SPRINT_ONE_CM));
    }

    private static int getSelfWaterDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SWIM_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ON_WATER_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_UNDER_WATER_ONE_CM));
    }

    private static int getRideAnimalDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.HORSE_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PIG_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.STRIDER_ONE_CM));
    }

    private static int getRideTransportationDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.AVIATE_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.MINECART_ONE_CM))
                + handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.BOAT_ONE_CM));
    }
}
