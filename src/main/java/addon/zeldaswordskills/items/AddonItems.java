package addon.zeldaswordskills.items;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.blocks.BlockZeldaAddon;
import addon.zeldaswordskills.blocks.BlockZeldaOre;
import addon.zeldaswordskills.entity.EntityLandOctorok;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zeldaswordskills.ZSSMain;
import zeldaswordskills.api.item.ArmorIndex;
import zeldaswordskills.api.item.ZSSItemHelper;
import zeldaswordskills.creativetab.ZSSCreativeTabs;
import zeldaswordskills.item.ItemArmorTunic;
import zeldaswordskills.item.ItemCustomVariantEgg;
import zeldaswordskills.item.ItemTreasure.Treasures;
import zeldaswordskills.item.ItemZeldaShield;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.world.gen.DungeonLootLists;

public class AddonItems
{
    public static Item
    darknutHelmet,
    darknutChest,
    darknutLegs,
    darknutBoots,
    greenToonHelmet,
    greenToonChest,
    greenToonLegs,
    toonBoots,
    shieldOrdon,
    shieldHero,
    shieldFace,
    shieldBlue,
    shieldWood1,
    shieldWood2,
    shieldWood3,
    shieldSteel1,
    shieldSteel2,
    shieldSteel3,
    shieldSacred1,
    shieldSacred2,
    shieldSacred3,
    swordRazor,
    swordGilded,
    swordFairy,
    swordFierce,
    swordPhantom,
    swordLokomo,
    swordFour,
    swordGoddess1,
    swordGoddess2,
    swordGoddess3,
    swordBasic,
    swordOshus,
    swordRecruit,
    swordPicori,
    swordGreen,
    swordRed,
    swordBlue,
    fairyDust,
    goldDust,
    fierceFragment,
    phantomBlade,
    phantomHourglass,
    phantomHourglassFilled,
    hourSand,
    spiritEssence,
    metal1,
    metal2,
    metal3,
    eightBitSwordWooden,
    eightBitSwordWhite,
    eightBitSwordMagical,
    eightBitShieldSmall,
    eightBitShieldMagical,
    spawnEggLandOctorok,
   // spawnEggGoldOctorok,
   // spawnEggSmallBeetle,
   // spawnEggCucco,
   // spawnEggGoldCucco,
    bugNet,
    bigBugNet,
    triforceShard,
    cuccoGlove,
    triforce,
    swordSupport,
    shieldSupport,
    soupFull,
    soupHalf;
    
    //Bugs
    public static Item
    smallBeetle,
    bigBeetle,
    volcanicLadybug;
    
    //addonTab.class??
    public static Block
    metal1ore,
    metal2ore,
    metal3ore,
    phantomBlock;

	//public static Item
	//sail, redLion;
	
    public static void init()
    {
    	initItems();
    	registerItems();
    	registerItemLoot();
    	registerRecipes();
    }
    
    public static void initItems()
    {
    	shieldOrdon = new ItemZeldaShield(ToolMaterial.WOOD, 0.25F, 30, 3F, 5F).setUnlocalizedName("shield_ordon").setCreativeTab(ZSSAddon.combatTab);
		shieldHero = new ItemHeroZeldaShield(ToolMaterial.WOOD, 0.25F, 28, 3.5F, 4.5F).setUnlocalizedName("shield_hero");
		shieldFace = new ItemZeldaShield(ToolMaterial.EMERALD, 0.60F, 24, 4.25F, 3.25F).setUnlocalizedName("shield_face").setCreativeTab(ZSSAddon.combatTab);
		shieldBlue = new ItemAddonZeldaShield(ToolMaterial.EMERALD, 0.50F, 26, 4F, 3.5F).setUnlocalizedName("shield_blue");
		
		shieldWood1 = new ItemAddonZeldaShield(ToolMaterial.WOOD, 0.25F, 30, 2.8F, 4.8F).setUnlocalizedName("shield_1wood");
		shieldWood2 = new ItemAddonZeldaShield(ToolMaterial.WOOD, 0.25F, 29, 3F, 4.6F).setUnlocalizedName("shield_2wood");
		shieldWood3 = new ItemAddonZeldaShield(ToolMaterial.WOOD, 0.25F, 28, 3.2F, 4.4F).setUnlocalizedName("shield_3wood");
		shieldSteel1 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.50F, 27, 3.4F, 4.2F).setUnlocalizedName("shield_1iron");
		shieldSteel2 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.50F, 26, 3.6F, 4.0F).setUnlocalizedName("shield_2iron");
		shieldSteel3 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.50F, 25, 3.8F, 3.8F).setUnlocalizedName("shield_3iron");
		shieldSacred1 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.75F, 24, 4.0F, 3.6F).setUnlocalizedName("shield_1sacred");
		shieldSacred2 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.75F, 23, 4.2F, 3.4F).setUnlocalizedName("shield_2sacred");
		shieldSacred3 = new ItemAddonZeldaShield(ToolMaterial.IRON, 0.75F, 22, 4.4F, 3.2F).setUnlocalizedName("shield_3sacred");
		
		swordGilded = new ItemZeldaSword(ToolMaterial.GOLD, 6.0F).setNoItemOnBreak().setUnlocalizedName("sword_gilded").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		swordPhantom = new ItemZeldaSword(ToolMaterial.EMERALD, 7.5F).setMasterSword().setUnlocalizedName("sword_phantom").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		swordLokomo = new ItemZeldaSword(ToolMaterial.EMERALD, 7.5F).setMasterSword().setUnlocalizedName("sword_lokomo").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		//swordFour = new ItemZeldaSword(ToolMaterial.EMERALD, 8.0F).setMasterSword().setUnlocalizedName("sword_four").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		swordFierce = new ItemZeldaSword(ToolMaterial.EMERALD, 9.0F, true).setMasterSword().setUnlocalizedName("sword_fierce").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		swordFairy = new ItemZeldaSword(ToolMaterial.EMERALD, 6.5F, true).setNoItemOnBreak().setUnlocalizedName("sword_fairy").setCreativeTab(ZSSAddon.combatTab).setMaxDamage(0);
		/**
		swordPicori = new ItemZeldaSword(ToolMaterial.EMERALD, 6.0F).setMasterSword().setUnlocalizedName("sword_picori").setCreativeTab(ZSSAddon.addonTab).setMaxDamage(0);
		swordGreen = new ItemZeldaSword(ToolMaterial.EMERALD, 5.5F).setMasterSword().setUnlocalizedName("sword_green").setCreativeTab(ZSSAddon.addonTab).setMaxDamage(0);
		swordRed = new ItemZeldaSword(ToolMaterial.EMERALD, 6.0F).setMasterSword().setUnlocalizedName("sword_red").setCreativeTab(ZSSAddon.addonTab).setMaxDamage(0);
		swordBlue = new ItemZeldaSword(ToolMaterial.EMERALD, 7.0F).setMasterSword().setUnlocalizedName("sword_blue").setCreativeTab(ZSSAddon.addonTab).setMaxDamage(0);
		*/
		swordBasic = new ItemBasicZeldaSword(ToolMaterial.IRON, -1.0F).setUnlocalizedName("sword_basic").setMaxDamage(256);
		swordOshus = new ItemBasicZeldaSword(ToolMaterial.IRON, -1.0F).setUnlocalizedName("sword_oshus").setMaxDamage(256);
		swordRecruit = new ItemBasicZeldaSword(ToolMaterial.IRON, -1.0F).setUnlocalizedName("sword_recruit").setMaxDamage(256);
		
		swordRazor = new ItemAddonZeldaSword(ToolMaterial.IRON, 2.0F).setUnlocalizedName("sword_razor").setMaxDamage(100);
		
		darknutHelmet = new ItemDarknutArmor(ArmorMaterial.IRON, 4, 0).setUnlocalizedName("zss.darknut_helmet");
		darknutChest = new ItemDarknutArmor(ArmorMaterial.IRON, 4, 1).setUnlocalizedName("zss.darknut_chest");
		darknutLegs = new ItemDarknutArmor(ArmorMaterial.IRON, 4, 2).setUnlocalizedName("zss.darknut_legs");
		darknutBoots = new ItemDarknutArmor(ArmorMaterial.IRON, 4, 3).setUnlocalizedName("zss.darknut_boots");
		
		greenToonHelmet = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_HELM).setUnlocalizedName("green_toon_helmet").setCreativeTab(ZSSAddon.combatTab);
		greenToonChest = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_CHEST).setUnlocalizedName("green_toon_chest").setCreativeTab(ZSSAddon.combatTab);
		greenToonLegs = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_LEGS).setUnlocalizedName("green_toon_legs").setCreativeTab(ZSSAddon.combatTab);
		
		toonBoots = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_BOOTS).setUnlocalizedName("toon_boots").setCreativeTab(ZSSAddon.combatTab);
		
		//redLion = new ItemRedLion().setUnlocalizedName("redLion");
		//sail = new ItemZeldaAddon().setUnlocalizedName("sail").setCreativeTab(CreativeTabs.tabTransport);
		
		fairyDust = new ItemZeldaAddon().setUnlocalizedName("zss.fairydust").setCreativeTab(ZSSAddon.miscTab);
		goldDust = new ItemZeldaAddon().setUnlocalizedName("zss.golddust").setCreativeTab(ZSSAddon.miscTab);
		fierceFragment = new ItemZeldaAddon().setUnlocalizedName("zss.fierce_fragment").setCreativeTab(ZSSAddon.miscTab);
		hourSand = new ItemZeldaAddon().setUnlocalizedName("zss.hoursand").setCreativeTab(ZSSAddon.miscTab);
		
		metal1 = new ItemZeldaAddon().setUnlocalizedName("zss.metal1").setCreativeTab(ZSSAddon.miscTab);
		metal2 = new ItemZeldaAddon().setUnlocalizedName("zss.metal2").setCreativeTab(ZSSAddon.miscTab);
		metal3 = new ItemZeldaAddon().setUnlocalizedName("zss.metal3").setCreativeTab(ZSSAddon.miscTab);
		
		spiritEssence = new ItemZeldaAddon().setUnlocalizedName("zss.spirit_essence").setCreativeTab(ZSSAddon.miscTab);
		phantomBlade = new ItemZeldaAddon().setUnlocalizedName("zss.phantom_blade").setCreativeTab(ZSSAddon.miscTab);
		phantomHourglass = new ItemPhantomHourglass().setUnlocalizedName("zss.phantom_hourglass").setCreativeTab(ZSSAddon.miscTab);
		phantomHourglassFilled = new ItemPhantomHourglass().setUnlocalizedName("zss.phantom_hourglass_filled").setCreativeTab(ZSSAddon.miscTab);
		
		metal1ore = new BlockZeldaOre().setUnlocalizedName("zss.metal1ore");
		metal2ore = new BlockZeldaOre().setUnlocalizedName("zss.metal2ore");
		metal3ore = new BlockZeldaOre().setUnlocalizedName("zss.metal3ore");
		phantomBlock = new BlockZeldaAddon(true).setUnlocalizedName("zss.phantomBlock");
		
		eightBitSwordWooden = new ItemZelda8BitSword(ToolMaterial.IRON, -1.0F).setNoItemOnBreak().setUnlocalizedName("sword_8bit_wooden").setMaxDamage(128);
		eightBitSwordWhite = new ItemZelda8BitSword(ToolMaterial.IRON, 1.0F).setNoItemOnBreak().setUnlocalizedName("sword_8bit_white").setMaxDamage(256);
		eightBitSwordMagical = new ItemZelda8BitSword(ToolMaterial.EMERALD, 0.0F).setNoItemOnBreak().setUnlocalizedName("sword_8bit_magical").setMaxDamage(512);

		swordGoddess1 = new ItemZeldaGoddessSword(ToolMaterial.IRON, -1.0F).setMasterSword().setUnlocalizedName("sword_goddess1").setMaxDamage(128);
		swordGoddess2 = new ItemZeldaGoddessSword(ToolMaterial.IRON, 1.0F).setMasterSword().setUnlocalizedName("sword_goddess2").setMaxDamage(256);
		swordGoddess3 = new ItemZeldaGoddessSword(ToolMaterial.EMERALD, 0.0F).setMasterSword().setUnlocalizedName("sword_goddess3").setMaxDamage(512);

		eightBitShieldSmall = new ItemZelda8BitShield(ToolMaterial.WOOD, 0.25F, 30, 3F, 5F).setUnlocalizedName("shield_8bit_small").setCreativeTab(ZSSAddon.combatTab);
		eightBitShieldMagical = new ItemZelda8BitShield(ToolMaterial.WOOD, 0.90F, 26, 4F, 3.5F).setUnlocalizedName("shield_8bit_magical").setCreativeTab(ZSSAddon.combatTab);
    
		triforce = new ItemZeldaAddon().setUnlocalizedName("zss.triforce");
		triforceShard = new ItemZeldaAddon().setUnlocalizedName("zss.triforceShard");

		shieldSupport = new ItemSupportZeldaShield(ToolMaterial.EMERALD, 0.75F, 24, 4F, 4F).setCreativeTab(null).setUnlocalizedName("shield_support");
		swordSupport = new ItemSupportZeldaSword(ToolMaterial.EMERALD, 8.0F).setMasterSword().setCreativeTab(null).setUnlocalizedName("sword_support").setMaxDamage(0);
		
		spawnEggLandOctorok = new ItemCustomVariantEgg(EntityLandOctorok.class, "landOctorok").setCreativeTab(ZSSCreativeTabs.tabEggs).setUnlocalizedName("eggLandOcto");
		/**spawnEggGoldOctorok = new ItemCustomEgg().setCreativeTab(ZSSAddon.addonTab).setUnlocalizedName("eggGoldOcto");
		spawnEggSmallBeetle = new ItemCustomEgg().setCreativeTab(ZSSAddon.addonTab).setUnlocalizedName("eggSmallBeetle");
		spawnEggCucco = new ItemCustomEgg().setCreativeTab(ZSSAddon.addonTab).setUnlocalizedName("eggCucco");
		spawnEggGoldCucco = new ItemCustomVariantEgg(EntityCuccoGolden.class, "cuccoGold").setCreativeTab(ZSSAddon.addonTab).setUnlocalizedName("eggCuccoGold");*/
		
		bugNet = new ItemBugNet().setUnlocalizedName("zss.bug_net").setCreativeTab(ZSSAddon.bugTab);
		bigBugNet = new ItemBugNet().setUnlocalizedName("zss.bigbug_net").setCreativeTab(ZSSAddon.bugTab);

		cuccoGlove = new ItemCuccoGlove().setUnlocalizedName("zss.cuccoGlove").setCreativeTab(ZSSAddon.miscTab);

		//BUGS
		smallBeetle = new ItemBug().setValue(20).setUnlocalizedName("zss.bug.small_beetle");
		bigBeetle = new ItemBug().setValue(50).setUnlocalizedName("zss.bug.big_beetle");
		volcanicLadybug = new ItemBug().setValue(70).setUnlocalizedName("zss.bug.volcanic_ladybug");
    }
    
	public static void registerItems()
	{
    	GameRegistry.registerItem(shieldOrdon, "shield_ordon");
    	GameRegistry.registerItem(shieldHero, "shield_hero");
    	GameRegistry.registerItem(shieldFace, "shield_face");
    	GameRegistry.registerItem(shieldBlue, "shield_blue");

    	GameRegistry.registerItem(swordGilded, "sword_gilded");
    	GameRegistry.registerItem(swordFairy, "sword_fairy");
    	GameRegistry.registerItem(swordFierce, "sword_fierce");
    	GameRegistry.registerItem(swordPhantom, "sword_phantom");
    	GameRegistry.registerItem(swordLokomo, "sword_lokomo");
    	//GameRegistry.registerItem(swordFour, "sword_four");

    	GameRegistry.registerItem(swordRazor, "sword_razor");

    	GameRegistry.registerItem(swordGoddess1, "sword_goddess1");
    	GameRegistry.registerItem(swordGoddess2, "sword_goddess2");
    	GameRegistry.registerItem(swordGoddess3, "sword_goddess3");
    	
    	GameRegistry.registerItem(swordBasic, "sword_basic");
    	GameRegistry.registerItem(swordOshus, "sword_oshus");
    	GameRegistry.registerItem(swordRecruit, "sword_recruit");
    	/**GameRegistry.registerItem(swordPicori, "sword_picori");
    	GameRegistry.registerItem(swordGreen, "sword_green");
    	GameRegistry.registerItem(swordRed, "sword_red");
    	GameRegistry.registerItem(swordBlue, "sword_blue");*/

    	GameRegistry.registerItem(shieldWood1, "shield_1wood");
    	GameRegistry.registerItem(shieldWood2, "shield_2wood");
    	GameRegistry.registerItem(shieldWood3, "shield_3wood");
    	GameRegistry.registerItem(shieldSteel1, "shield_1iron");
    	GameRegistry.registerItem(shieldSteel2, "shield_2iron");
    	GameRegistry.registerItem(shieldSteel3, "shield_3iron");
    	GameRegistry.registerItem(shieldSacred1, "shield_1sacred");
    	GameRegistry.registerItem(shieldSacred2, "shield_2sacred");
    	GameRegistry.registerItem(shieldSacred3, "shield_3sacred");

    	GameRegistry.registerItem(swordSupport, "sword_support");
    	GameRegistry.registerItem(shieldSupport, "shield_support");
    	
    	GameRegistry.registerItem(darknutHelmet, "darknut_helmet");
    	GameRegistry.registerItem(darknutChest, "darknut_chest");
    	GameRegistry.registerItem(darknutLegs, "darknut_legs");
    	GameRegistry.registerItem(darknutBoots, "darknut_boots");

    	GameRegistry.registerItem(greenToonHelmet, "green_toon_helmet");
    	GameRegistry.registerItem(greenToonChest, "green_toon_chest");
    	GameRegistry.registerItem(greenToonLegs, "green_toon_legs");
    	//Blue Red Purple Toonic
    	GameRegistry.registerItem(toonBoots, "toon_boots");
    	
    	GameRegistry.registerItem(fairyDust, "fairydust");
    	GameRegistry.registerItem(goldDust, "golddust");
    	GameRegistry.registerItem(fierceFragment, "fierce_fragment");
    	GameRegistry.registerItem(hourSand, "hoursand");
    	
    	GameRegistry.registerItem(spiritEssence, "spirit_essence");
    	GameRegistry.registerItem(phantomBlade, "phantom_blade");
    	GameRegistry.registerItem(phantomHourglass, "phantom_hourglass");
    	GameRegistry.registerItem(phantomHourglassFilled, "phantom_hourglass_filled");
    	
    	GameRegistry.registerItem(metal1, "metal1");
    	GameRegistry.registerItem(metal2, "metal2");
    	GameRegistry.registerItem(metal3, "metal3");

    	GameRegistry.registerItem(eightBitSwordWooden, "sword_8bit_wooden");
    	GameRegistry.registerItem(eightBitSwordWhite, "sword_8bit_white");
    	GameRegistry.registerItem(eightBitSwordMagical, "sword_8bit_magical");
    	GameRegistry.registerItem(eightBitShieldSmall, "shield_8bit_small");
    	GameRegistry.registerItem(eightBitShieldMagical, "shield_8bit_magical");
    	
    	GameRegistry.registerItem(triforce, "triforce");
    	GameRegistry.registerItem(triforceShard, "triforceShard");

    	GameRegistry.registerItem(cuccoGlove, "cuccoGlove");

    	GameRegistry.registerItem(spawnEggLandOctorok, "eggLandOcto");
    	/**GameRegistry.registerItem(spawnEggGoldOctorok, "eggGoldOcto");
    	GameRegistry.registerItem(spawnEggSmallBeetle, "eggSmallBeetle");
    	GameRegistry.registerItem(spawnEggCucco, "eggCucco");*/
    	
    	GameRegistry.registerItem(bugNet, "bug_net");
    	GameRegistry.registerItem(bigBugNet, "bigbug_net");
    	
    	GameRegistry.registerBlock(metal1ore, "metal1ore");
    	GameRegistry.registerBlock(metal2ore, "metal2ore");
    	GameRegistry.registerBlock(metal3ore, "metal3ore");
    	GameRegistry.registerBlock(phantomBlock, "phantomBlock");

    	//GameRegistry.registerItem(sail, "sail");
    	//GameRegistry.registerItem(redLion, "redLion");
    	
    	//BUUUGSSSS :P
    	GameRegistry.registerItem(smallBeetle, "small_beetle");
    	GameRegistry.registerItem(bigBeetle, "big_beetle");
    	GameRegistry.registerItem(volcanicLadybug, "volcanic_ladybug");
	}
	
	public static void registerRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(darknutHelmet, 1), Items.flint, Items.flint, Items.iron_helmet);
    	GameRegistry.addShapelessRecipe(new ItemStack(darknutChest, 1), Items.coal, Items.iron_ingot, Items.coal, Items.iron_ingot, Items.iron_chestplate);
    	GameRegistry.addShapelessRecipe(new ItemStack(darknutLegs, 1), new ItemStack(ZSSItems.treasure, 1, Treasures.KNIGHTS_CREST.ordinal()), Items.iron_leggings);
    	GameRegistry.addShapelessRecipe(new ItemStack(darknutBoots, 1), Items.iron_ingot, Items.iron_ingot, Items.iron_boots);
    	
    	GameRegistry.addRecipe(new ItemStack(phantomHourglassFilled, 1, 20), new Object[]{"XXX", "XOX", "XXX", 'X', hourSand, 'O', phantomHourglass});

    	GameRegistry.addRecipe(new ItemStack(shieldWood1, 1), new Object[]{"YXY", "XOX", "YXY", 'X', Blocks.planks, 'O', Items.iron_ingot, 'Y', Items.leather});
    	GameRegistry.addRecipe(new ItemStack(swordBasic, 1), new Object[]{"  X", " X ", "O  ", 'X', Items.iron_ingot, 'O', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(swordBasic, 1), new Object[]{"X  ", " X ", "  O", 'X', Items.iron_ingot, 'O', Items.stick});
    	
    	/**if(AddonConfig.enableNewBasicSword())
    	{
        	GameRegistry.addRecipe(new ItemStack(swordBasic, 1), new Object[]{"X  ", " X ", "  O", 'X', Items.iron_ingot, 'O', Items.stick});
    	}*/
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(phantomBlade, 1), metal1, metal2, metal3);
    	GameRegistry.addSmelting(metal1ore, new ItemStack(metal1), 100);
    	GameRegistry.addSmelting(metal2ore, new ItemStack(metal2), 100);
    	GameRegistry.addSmelting(metal3ore, new ItemStack(metal3), 100);
    	GameRegistry.addShapelessRecipe(new ItemStack(swordPhantom, 1), swordLokomo);
    	GameRegistry.addShapelessRecipe(new ItemStack(swordLokomo, 1), swordPhantom, spiritEssence);
	}
	
	public static void registerItemLoot()
	{
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(shieldOrdon), 1, 1, 15));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(hourSand), 1, 1, 10));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(fairyDust), 1, 1, 2));
		ChestGenHooks.getInfo(DungeonLootLists.BOSS_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(fierceFragment), 1, 1, 2));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(goldDust), 1, 1, 2));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(eightBitShieldSmall), 1, 1, 5));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(eightBitSwordWooden), 1, 1, 5));
		ChestGenHooks.getInfo(DungeonLootLists.LOCKED_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(cuccoGlove), 1, 1, 4));
		ChestGenHooks.getInfo(DungeonLootLists.BOSS_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(phantomHourglass), 1, 1, 3));
		ChestGenHooks.getInfo(DungeonLootLists.BOSS_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(spiritEssence), 1, 1, 5));
		ChestGenHooks.getInfo(DungeonLootLists.BOSS_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(swordGoddess1), 1, 1, 5));
		ChestGenHooks.getInfo(DungeonLootLists.BASIC_LOOT).addItem(new WeightedRandomChestContent(new ItemStack(bugNet), 1, 1, 4));
	}
	
	public static void registerTabComparators()
	{
		ZSSItemHelper.addItemForZssCreativeTab(spawnEggLandOctorok);
		//^^ For the Egg Tab ^^ //-~=~-// vv For the Addon Tab vv

		// Combat Tab
		ZSSItemHelper.addItemForZssCreativeTab(darknutHelmet);
		ZSSItemHelper.addItemForZssCreativeTab(darknutChest);
		ZSSItemHelper.addItemForZssCreativeTab(darknutLegs);
		ZSSItemHelper.addItemForZssCreativeTab(darknutBoots);
		ZSSItemHelper.addItemForZssCreativeTab(greenToonHelmet);
		ZSSItemHelper.addItemForZssCreativeTab(greenToonChest);
		ZSSItemHelper.addItemForZssCreativeTab(greenToonLegs);
		//Red, Blue, Purple Toonic
		ZSSItemHelper.addItemForZssCreativeTab(toonBoots);
		
		ZSSItemHelper.addItemForZssCreativeTab(swordGoddess1);
		ZSSItemHelper.addItemForZssCreativeTab(swordGoddess2);
		ZSSItemHelper.addItemForZssCreativeTab(swordGoddess3);
		ZSSItemHelper.addItemForZssCreativeTab(swordBasic);
		ZSSItemHelper.addItemForZssCreativeTab(swordOshus);
		ZSSItemHelper.addItemForZssCreativeTab(swordRecruit);
		ZSSItemHelper.addItemForZssCreativeTab(swordRazor);
		ZSSItemHelper.addItemForZssCreativeTab(swordGilded);
		ZSSItemHelper.addItemForZssCreativeTab(swordFairy);
		ZSSItemHelper.addItemForZssCreativeTab(swordFierce);
		ZSSItemHelper.addItemForZssCreativeTab(swordPhantom);
		ZSSItemHelper.addItemForZssCreativeTab(swordLokomo);

		ZSSItemHelper.addItemForZssCreativeTab(shieldHero);
		ZSSItemHelper.addItemForZssCreativeTab(shieldOrdon);
		ZSSItemHelper.addItemForZssCreativeTab(shieldBlue);
		ZSSItemHelper.addItemForZssCreativeTab(shieldFace);
		ZSSItemHelper.addItemForZssCreativeTab(shieldWood1);
		ZSSItemHelper.addItemForZssCreativeTab(shieldWood2);
		ZSSItemHelper.addItemForZssCreativeTab(shieldWood3);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSteel1);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSteel2);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSteel3);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSacred1);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSacred2);
		ZSSItemHelper.addItemForZssCreativeTab(shieldSacred3);

		ZSSItemHelper.addItemForZssCreativeTab(eightBitSwordWooden);
		ZSSItemHelper.addItemForZssCreativeTab(eightBitSwordWhite);
		ZSSItemHelper.addItemForZssCreativeTab(eightBitSwordMagical);
		ZSSItemHelper.addItemForZssCreativeTab(eightBitShieldSmall);
		ZSSItemHelper.addItemForZssCreativeTab(eightBitShieldMagical);

		//Misc Tab
		ZSSItemHelper.addItemForZssCreativeTab(cuccoGlove);
		ZSSItemHelper.addItemForZssCreativeTab(fairyDust);
		ZSSItemHelper.addItemForZssCreativeTab(goldDust);
		ZSSItemHelper.addItemForZssCreativeTab(fierceFragment);
		ZSSItemHelper.addItemForZssCreativeTab(phantomBlade);
		ZSSItemHelper.addItemForZssCreativeTab(hourSand);
		ZSSItemHelper.addItemForZssCreativeTab(phantomHourglass);
		ZSSItemHelper.addItemForZssCreativeTab(phantomHourglassFilled);
		ZSSItemHelper.addItemForZssCreativeTab(spiritEssence);
		ZSSItemHelper.addItemForZssCreativeTab(metal1);
		ZSSItemHelper.addItemForZssCreativeTab(metal2);
		ZSSItemHelper.addItemForZssCreativeTab(metal3);
		ZSSItemHelper.addItemForZssCreativeTab(Item.getItemFromBlock(metal1ore));
		ZSSItemHelper.addItemForZssCreativeTab(Item.getItemFromBlock(metal2ore));
		ZSSItemHelper.addItemForZssCreativeTab(Item.getItemFromBlock(metal3ore));
		ZSSItemHelper.addItemForZssCreativeTab(Item.getItemFromBlock(phantomBlock));

		//Bug Tab
		ZSSItemHelper.addItemForZssCreativeTab(bugNet);
		ZSSItemHelper.addItemForZssCreativeTab(bigBugNet);
		ZSSItemHelper.addItemForZssCreativeTab(smallBeetle);
		ZSSItemHelper.addItemForZssCreativeTab(bigBeetle);
		ZSSItemHelper.addItemForZssCreativeTab(volcanicLadybug);

		/**ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);
		ZSSItemHelper.addItemForZssCreativeTab(item);*/
	}
}
