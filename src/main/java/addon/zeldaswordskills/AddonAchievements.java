package addon.zeldaswordskills;

import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import zeldaswordskills.item.ZSSItems;
import addon.zeldaswordskills.items.AddonItems;

public class AddonAchievements
{
	public static AchievementPage addonPage;
	
	public static Achievement octoSmash;
	public static Achievement sweetGrandma;
	public static Achievement blueShield;
	public static Achievement faceShield;
	public static Achievement gildedSword;
	public static Achievement healingDealing;
	public static Achievement doubleHelix;
	public static Achievement takeThis;
	public static Achievement cuccoChase;
	public static Achievement cuccoMaster;

	public static void loadAchievements()
	{
		if(AddonConfig.shouldAchievementsLoad())
		{
			octoSmash = new Achievement("", "zss.octoSmash", 2, 2, ZSSItems.hammerMegaton, null);
			cuccoChase = new Achievement("", "zss.cuccoChase", 2, 4, Items.chicken, null);
			cuccoMaster = new Achievement("", "zss.cuccoMaster", 4, 4, AddonItems.cuccoGlove, cuccoChase);
			sweetGrandma = new Achievement("", "zss.sweetGrandma", 0, 1, AddonItems.shieldHero, null);
			blueShield = new Achievement("", "zss.blueShield", 0, 2, AddonItems.shieldBlue, sweetGrandma);
			faceShield = new Achievement("", "zss.faceShield", 0, 3, AddonItems.shieldFace, blueShield);
			gildedSword = new Achievement("", "zss.gildedSword", 0, -1, AddonItems.swordGilded, null);
			healingDealing = new Achievement("", "zss.healingDealing", 1, -1, AddonItems.swordFairy, null);
			doubleHelix = new Achievement("", "zss.doubleHelix", 2, -1, AddonItems.swordFierce, null);
			takeThis = new Achievement("", "zss.takeThis", -1, -1, AddonItems.eightBitSwordWooden, null);
			
			addonPage = new AchievementPage("ZSS Addon",
					octoSmash,
					sweetGrandma,
					blueShield,
					faceShield,
					gildedSword,
					healingDealing,
					doubleHelix,
					takeThis,
					cuccoChase,
					cuccoMaster);
			AchievementPage.registerAchievementPage(addonPage);
		}
	}
}
