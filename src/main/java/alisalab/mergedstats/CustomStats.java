package alisalab.mergedstats;

import net.minecraft.util.Identifier;

/**
 * Identifiers of custom stats
 */
public class CustomStats {

    /**
     * Things in MINED_STONES_OVERWORLD and MINED_STONES_NETHER.
     * @see CustomStats#MINED_STONES_OVERWORLD
     * @see CustomStats#MINED_STONES_NETHER
     */
    public static final Identifier MINED_STONES_TOTAL = new Identifier(MergedStats.MOD_ID, "ms_mined_stones_total");

    /**
     * Mined stones count in the overworld. Include: granite, diorite, andesite, calcite, tuff,
     * stone, cobblestone, deepslate, cobbled_deepslate, sandstone, red_sandstone
     */
    public static final Identifier MINED_STONES_OVERWORLD = new Identifier(MergedStats.MOD_ID, "ms_mined_stones_overworld");

    /**
     * Mined stones count in the nether. Include: netherrack, crimson_nylium, warped_nylium,
     * soul_sand, soul_soil, blackstone, basalt, smooth_basalt, glowstone
     */
    public static final Identifier MINED_STONES_NETHER = new Identifier(MergedStats.MOD_ID, "ms_mined_stones_nether");

    /**
     * Vanilla minecraft.custom:minecraft.play_time in minutes
     */
    public static final Identifier PLAY_TIME_MINUTES = new Identifier(MergedStats.MOD_ID, "ms_play_time_minutes");

    /**
     * Things in TRAVEL_SELF_DISTANCE and TRAVEL_RIDE_DISTANCE
     * @see CustomStats#TRAVEL_SELF_DISTANCE
     * @see CustomStats#TRAVEL_RIDE_DISTANCE
     */
    public static final Identifier TRAVEL_ALL_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_all_distance");

    /**
     * Things in TRAVEL_SELF_GROUND_DISTANCE and TRAVEL_SELF_WATER_DISTANCE
     * @see CustomStats#TRAVEL_SELF_GROUND_DISTANCE
     * @see CustomStats#TRAVEL_SELF_WATER_DISTANCE
     */
    public static final Identifier TRAVEL_SELF_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_self_distance");

    /**
     * A combination of: walk, sprint
     */
    public static final Identifier TRAVEL_SELF_GROUND_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_self_ground_distance");

    /**
     * A combination of: swim, walk on water, walk underwater
     */
    public static final Identifier TRAVEL_SELF_WATER_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_self_water_distance");

    /**
     * Things in TRAVEL_RIDE_ANIMAL_DISTANCE and TRAVEL_RIDE_TRANSPORTATION_DISTANCE
     * @see CustomStats#TRAVEL_RIDE_ANIMAL_DISTANCE
     * @see CustomStats#TRAVEL_RIDE_TRANSPORTATION_DISTANCE
     */
    public static final Identifier TRAVEL_RIDE_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_ride_distance");

    /**
     * A combination of: by horse, by pig, by strider
     */
    public static final Identifier TRAVEL_RIDE_ANIMAL_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_ride_animal_distance");

    /**
     * A combination of: by elytra, by boat, by minecart
     */
    public static final Identifier TRAVEL_RIDE_TRANSPORTATION_DISTANCE = new Identifier(MergedStats.MOD_ID, "ms_travel_ride_transportation_distance");
}
