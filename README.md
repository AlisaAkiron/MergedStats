# Merged Stats

A Minecraft Fabric mod that add some new stats to the game which are useful if you want to make a scoreboard in the server.

You need Fabric and Fabric API to run this mod.

## About server compatibility

| Server    | Client    | Compatibility                                                                                     |
|-----------|-----------|---------------------------------------------------------------------------------------------------|
| Installed | No        | Scoreboard works fine. If the client open the `Statistic` panel in game, it will lost connection. |
| Installed | Installed | Works fine.                                                                                       |
| No        | Installed | The client could see the new stats, but no value.                                                 |

## Stats

- Mined Stones
- Mined Stones (Overworld)
- Mined Stones (The Nether)
- Mined Ores
- Mined Ores (Overworld)
- Mined Ores (The Nether)
- Time Played (Minutes)
- Distance Travelled (M)
- Distance Travelled by Self (M)
- Distance Travelled by Self on Ground (M)
- Distance Travelled by Self in Water (M)
- Distance Travelled by Riding (M)
- Distance Travelled by Riding Animals (M)
- Distance Travelled by Riding Transportations (M)

Stones in the overworld: granite, diorite, andesite, calcite, tuff, stone, cobblestone, deepslate, cobbled_deepslate, sandstone, red_sandstone.

Stones in the nether: netherrack, crimson_nylium, warped_nylium, soul_sand, soul_soil, blackstone, basalt, smooth_basalt, glowstone.

Ores in the overworld: coal_ore, iron_ore, copper_ore, gold_ore, redstone_ore, emerald_ore, lapis_ore, diamond_ore and all above's deepslate variant.

Ores in the nether: nether_gold_ore, nether_quartz_ore, ancient_debris.

Self ground: walk, sprint.

Self water: swim, walk on water, walk underwater.

Riding animals: by horse, by pig, by strider.

Riding transportations: by elytra, by boat, by minecart.

## License

This project is licensed under the MIT license.