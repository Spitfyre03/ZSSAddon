package addon.zeldaswordskills;

import java.io.File;

import addon.zeldaswordskills.entity.AddonEntities;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class AddonConfig
{
	public static Configuration config;
	
	private static boolean grandmaGiveArmor;
	private static boolean bugNetChances;
	private static boolean achievementLoad;
	private static boolean basicSwordRecipe;
	private static boolean cuccoGloveLeap;
	private static boolean cuccoAngrySpawn;
	private static boolean phantomBlockKill;
	private static boolean playerButtonActivation;
	
	public static void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/" + "zeldaswordskills-addon" + ".cfg"));
		config.load();
		
		phantomBlockKill = config.get("General", "Whether the player instantly dies from phantom blocks without the hourglass.", true).getBoolean(true);
		grandmaGiveArmor = config.get("General", "Whether players recieves toon-armor from Grandma. You will still recieve the shield.", true).getBoolean(true);
		bugNetChances = config.get("General", "Whether catched bugs randomly can escape before being catched.", true).getBoolean(true);
		achievementLoad = config.get("General", "Whether to load ingame Achievements or not. (WARNING: Might be bugged!)", true).getBoolean(true);
		basicSwordRecipe = config.get("General", "Whether to enable an alternate recipe for the Basic Sword (Used for Mod Compatability) (Currently does nothing)", false).getBoolean(false);
		playerButtonActivation = config.get("General", "Wheteher only players should be able to activate the switches.", true).getBoolean(true);
		
		cuccoGloveLeap = config.get("General", "Whether the Cucco Glove can 'leap'.", true).getBoolean(true);
		cuccoAngrySpawn = config.get("General", "Whether to spawn extra Angry Cuccos when enraging a cucco.)", true).getBoolean(true);
	}

	public static void postInit()
	{	
		AddonEntities.postInit(config);
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
	
	public static boolean doesPhantomInstantDeath() { return phantomBlockKill; }
	public static boolean doesGrandmaGiveArmor() { return grandmaGiveArmor; }
	public static boolean doesBugsEscapeNet() { return bugNetChances; }
	public static boolean doesSmallBeetleSpawn() { return cuccoGloveLeap; }
	public static boolean shouldAchievementsLoad() { return achievementLoad; }
	public static boolean doesAngryCuccosSpawn() { return cuccoAngrySpawn; }
	public static boolean doesCuccoGloveLeap() { return cuccoGloveLeap; }
	public static boolean enableNewBasicSword() { return basicSwordRecipe; }
	public static boolean doesOnlyPlayerActivate() { return playerButtonActivation; }
}