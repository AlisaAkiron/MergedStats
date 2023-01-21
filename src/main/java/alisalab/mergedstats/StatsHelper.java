package alisalab.mergedstats;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.StatHandler;
import net.minecraft.stat.Stats;

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

        var minedStonesOverworld = getMinedStones(handler)
                + getMinedCobblestones(handler)
                + getMinedDeepslate(handler)
                + getMinedCobbledDeepslate(handler)
                + getMinedSandstone(handler)
                + getMinedRedSandstone(handler)
                + getMinedGranite(handler)
                + getMinedDiorite(handler)
                + getMinedDiorite(handler)
                + getMinedAndesite(handler)
                + getMinedCalcite(handler)
                + getMinedTuff(handler);
        var minedStonesNether = getMinedNetherrack(handler)
                + getMinedCrimsonNylium(handler)
                + getMinedWarpedNylium(handler)
                + getMinedSoulSand(handler)
                + getMinedSoulSoil(handler)
                + getMinedBlackstone(handler)
                + getMinedBasalt(handler)
                + getMinedSmoothBasalt(handler)
                + getMinedGlowstone(handler);
        var minedStonesTotal = minedStonesOverworld + minedStonesNether;
        var playTimeMinutes = getPlayTime(handler) / 20 / 60;
        var travelSelfGroundDistance = getWalkDistance(handler)
                + getSprintDistance(handler);
        var travelSelfWaterDistance = getSwimDistance(handler)
                + getWalkOnWaterDistance(handler)
                + getWalkUnderWaterDistance(handler);
        var travelSelfDistance = travelSelfGroundDistance + travelSelfWaterDistance;
        var travelRideAnimalDistance = getHorseDistance(handler)
                + getPigDistance(handler)
                + getStriderDistance(handler);
        var travelRideTransportationDistance = getElytraDistance(handler)
                + getBoatDistance(handler)
                + getMinecartDistance(handler);
        var travelRideDistance = travelRideAnimalDistance + travelRideTransportationDistance;
        var travelAllDistance = travelSelfDistance + travelRideDistance;

        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_OVERWORLD), minedStonesOverworld);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_NETHER), minedStonesNether);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.MINED_STONES_TOTAL), minedStonesTotal);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.PLAY_TIME_MINUTES), playTimeMinutes);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_GROUND_DISTANCE), travelSelfGroundDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_WATER_DISTANCE), travelSelfWaterDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_SELF_DISTANCE), travelSelfDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_ANIMAL_DISTANCE), travelRideAnimalDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_TRANSPORTATION_DISTANCE), travelRideTransportationDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_RIDE_DISTANCE), travelRideDistance);
        handler.setStat(p, Stats.CUSTOM.getOrCreateStat(CustomStats.TRAVEL_ALL_DISTANCE), travelAllDistance);
    }

    /**
     * Get minecraft.mined:minecraft.stone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedStones(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.STONE));
    }

    /**
     * Get minecraft.mined:minecraft.cobblestone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedCobblestones(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLESTONE));
    }

    /**
     * Get minecraft.mined:minecraft.deepslate stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedDeepslate(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DEEPSLATE));
    }

    /**
     * Get minecraft.mined:minecraft.cobbled_deepslate stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedCobbledDeepslate(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.COBBLED_DEEPSLATE));
    }

    /**
     * Get minecraft.mined:minecraft.sandstone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedSandstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SANDSTONE));
    }

    /**
     * Get minecraft.mined:minecraft.red_sandstone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedRedSandstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.RED_SANDSTONE));
    }

    /**
     * Get minecraft.mined:minecraft.granite stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedGranite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GRANITE));
    }

    /**
     * Get minecraft.mined:minecraft.diorite stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedDiorite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.DIORITE));
    }

    /**
     * Get minecraft.mined:minecraft.andesite stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedAndesite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.ANDESITE));
    }

    /**
     * Get minecraft.mined:minecraft.calcite stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedCalcite(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CALCITE));
    }

    /**
     * Get minecraft.mined:minecraft.tuff stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedTuff(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.TUFF));
    }

    /**
     * Get minecraft.mined:minecraft.netherrack stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedNetherrack(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.NETHERRACK));
    }

    /**
     * Get minecraft.mined:minecraft.crimson_nylium stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedCrimsonNylium(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.CRIMSON_NYLIUM));
    }

    /**
     * Get minecraft.mined:minecraft.warped_nylium stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedWarpedNylium(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.WARPED_NYLIUM));
    }

    /**
     * Get minecraft.mined:minecraft.soul_sand stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedSoulSand(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SAND));
    }

    /**
     * Get minecraft.mined:minecraft.soul_soil stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedSoulSoil(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SOUL_SOIL));
    }

    /**
     * Get minecraft.mined:minecraft.blackstone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedBlackstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BLACKSTONE));
    }

    /**
     * Get minecraft.mined:minecraft.basalt stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedBasalt(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.BASALT));
    }

    /**
     * Get minecraft.mined:minecraft.smooth_basalt stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedSmoothBasalt(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.SMOOTH_BASALT));
    }

    /**
     * Get minecraft.mined:minecraft.glowstone stats
     * @param handler The stat handler of the player
     * @return Stats count in Blocks
     */
    public static int getMinedGlowstone(StatHandler handler) {
        return handler.getStat(Stats.MINED.getOrCreateStat(Blocks.GLOWSTONE));
    }

    /**
     * Get minecraft.custom:minecraft.play_time stats
     * @param handler The stat handler of the player
     * @return Stats count in Ticks (gt, 0.05 s)
     */
    public static int getPlayTime(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PLAY_TIME));
    }

    /**
     * Get minecraft.custom:minecraft.walk_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getWalkDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.sprint_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getSprintDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SPRINT_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.swim_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getSwimDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.SWIM_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.walk_on_water_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getWalkOnWaterDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_ON_WATER_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.walk_under_water_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getWalkUnderWaterDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.WALK_UNDER_WATER_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.horse_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getHorseDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.HORSE_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.pig_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getPigDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.PIG_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.strider_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getStriderDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.STRIDER_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.aviate_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getElytraDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.AVIATE_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.minecart_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getMinecartDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.MINECART_ONE_CM));
    }

    /**
     * Get minecraft.custom:minecraft.boat_one_cm stats
     * @param handler The stat handle of the player
     * @return Stats count in centimeter
     */
    public static int getBoatDistance(StatHandler handler) {
        return handler.getStat(Stats.CUSTOM.getOrCreateStat(Stats.BOAT_ONE_CM));
    }
}
