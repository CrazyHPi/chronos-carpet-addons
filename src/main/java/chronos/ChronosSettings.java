package chronos;

import carpet.api.settings.Rule;

import static carpet.api.settings.RuleCategory.*;

public class ChronosSettings
{
    private static final String CHRONOS = "chronos";

    public static boolean betterCarefulBreak = false;

    @Rule(categories = { SURVIVAL, COMMAND, CHRONOS })
    public static boolean commandTotal = false;

    @Rule(categories = { CREATIVE, CHRONOS })
    public static boolean creativeOneHitKill = false;

    @Rule(categories = { OPTIMIZATION, CHRONOS })
    public static boolean disableNetherPortalCollisionCheck = false;

    @Rule(categories = { CREATIVE, EXPERIMENTAL, CHRONOS})
    public static boolean ignoreExistingRaids = false;

    @Rule(categories = { SURVIVAL, CHRONOS })
    public static boolean endGatewayCooldown = true;

    @Rule(categories = { SURVIVAL, CHRONOS })
    public static boolean netheritePickaxeInstantMineDeepslate = false;

    @Rule(categories = { CREATIVE, CHRONOS })
    public static boolean oldFlintAndSteelBehavior = false;

    @Rule(categories = { OPTIMIZATION, CHRONOS })
    public static boolean optimizedFallDamageRaycast = false;

    @Rule(categories = { CHRONOS })
    public static boolean playerSit = false;

    @Rule(categories = { SURVIVAL, COMMAND, CHRONOS })
    public static boolean totalScore = false;

    @Rule(categories = { SURVIVAL, CHRONOS })
    public static boolean scoreboardIgnoresBots = false;

}
