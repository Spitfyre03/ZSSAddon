package addon.zeldaswordskills.items;

import java.lang.reflect.Field;

import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.blocks.BlockZeldaAddon;
import addon.zeldaswordskills.blocks.BlockZeldaOre;
import addon.zeldaswordskills.entity.EntityLandOctorok;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
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
import zeldaswordskills.block.IVanillaRotation;
import zeldaswordskills.creativetab.ZSSCreativeTabs;
import zeldaswordskills.item.ICustomDispenserBehavior;
import zeldaswordskills.item.ItemArmorTunic;
import zeldaswordskills.item.ItemCustomVariantEgg;
import zeldaswordskills.item.ItemTreasure.Treasures;
import zeldaswordskills.item.ItemZeldaShield;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.util.BlockRotationData;
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
    blueToonHelmet,
    blueToonChest,
    blueToonLegs,
    redToonHelmet,
    redToonChest,
    redToonLegs,
    purpleToonHelmet,
    purpleToonChest,
    purpleToonLegs,
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
    cuccoGlove,
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
    bugNet,
    bigBugNet,
    triforceShard,
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
    
    //Blocks
    public static Block
    metal1ore,
    metal2ore,
    metal3ore,
    phantomBlock;
	
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
		
		blueToonHelmet = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_HELM).setUnlocalizedName("blue_toon_helmet").setCreativeTab(ZSSAddon.combatTab);
		blueToonChest = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_CHEST).setUnlocalizedName("blue_toon_chest").setCreativeTab(ZSSAddon.combatTab);
		blueToonLegs = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_LEGS).setUnlocalizedName("blue_toon_legs").setCreativeTab(ZSSAddon.combatTab);

		redToonHelmet = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_HELM).setUnlocalizedName("red_toon_helmet").setCreativeTab(ZSSAddon.combatTab);
		redToonChest = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_CHEST).setUnlocalizedName("red_toon_chest").setCreativeTab(ZSSAddon.combatTab);
		redToonLegs = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_LEGS).setUnlocalizedName("red_toon_legs").setCreativeTab(ZSSAddon.combatTab);

		purpleToonHelmet = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_HELM).setUnlocalizedName("purple_toon_helmet").setCreativeTab(ZSSAddon.combatTab);
		purpleToonChest = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_CHEST).setUnlocalizedName("purple_toon_chest").setCreativeTab(ZSSAddon.combatTab);
		purpleToonLegs = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_LEGS).setUnlocalizedName("purple_toon_legs").setCreativeTab(ZSSAddon.combatTab);
		
		toonBoots = new ItemArmorTunic(ZSSMain.proxy.addArmor("tunic"), ArmorIndex.TYPE_BOOTS).setUnlocalizedName("toon_boots").setCreativeTab(ZSSAddon.combatTab);
		
		//redLion = new ItemRedLion().setUnlocalizedName("redLion");
		//sail = new ItemZeldaAddon().setUnlocalizedName("sail").setCreativeTab(CreativeTabs.tabTransport);
		
		soupFull = new ItemSoup().setUnlocalizedName("zss.soup_full");
		soupHalf = new ItemSoup().setUnlocalizedName("zss.soup_half");
		
		fairyDust = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.fairydust");
		goldDust = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.golddust");
		fierceFragment = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.fierce_fragment");
		hourSand = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.hoursand");
		
		metal1 = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.metal1");
		metal2 = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.metal2");
		metal3 = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.metal3");
		
		spiritEssence = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.spirit_essence");
		phantomBlade = new ItemZeldaAddon().addToTab().setUnlocalizedName("zss.phantom_blade");
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

		bugNet = new ItemBugNet().setUnlocalizedName("zss.bug_net").setCreativeTab(ZSSAddon.bugTab);
		bigBugNet = new ItemBugNet().setUnlocalizedName("zss.bigbug_net").setCreativeTab(ZSSAddon.bugTab);

		cuccoGlove = new ItemCuccoGlove().setUnlocalizedName("zss.cuccoGlove").setCreativeTab(ZSSAddon.miscTab);

		//BUGS
		smallBeetle = new ItemBug().setValue(20).setUnlocalizedName("zss.small_beetle");
		bigBeetle = new ItemBug().setValue(50).setUnlocalizedName("zss.big_beetle");
		volcanicLadybug = new ItemBug().setValue(70).setUnlocalizedName("zss.volcanic_ladybug");
    }
    
    public static void registerItems()
    {
    	try {
			for (Field f: AddonItems.class.getFields()) {
				if (Item.class.isAssignableFrom(f.getType())) {
					Item item = (Item) f.get(null);
					if (item != null) {
						ZSSItemHelper.addItemForZssCreativeTab(item);
						String name = item.getUnlocalizedName();
						GameRegistry.registerItem(item, name.substring(9));
						if (item instanceof ICustomDispenserBehavior) {
							BlockDispenser.dispenseBehaviorRegistry.putObject(item, ((ICustomDispenserBehavior) item).getNewDispenserBehavior());
						}
					}
				}
			}
		}
    	catch(Exception e) {
			ZSSMain.logger.warn("Caught exception while registering items: " + e.toString());
			e.printStackTrace();
		}
    	
    	try {
			for (Field f: AddonItems.class.getFields()) {
				if (Block.class.isAssignableFrom(f.getType())) {
					Block block = (Block) f.get(null);
					if (block != null) {
						String name = block.getUnlocalizedName();
						ZSSItemHelper.addItemForZssCreativeTab(Item.getItemFromBlock(block));
						GameRegistry.registerBlock(block, name.substring(9));
						if (block instanceof IVanillaRotation) {
							ZSSMain.logger.debug("Registering custom rotation for " + block.getUnlocalizedName());
							BlockRotationData.registerCustomBlockRotation(block, ((IVanillaRotation) block).getRotationPattern());
						}
					}
				}
			}
		} catch (Exception e) {
			ZSSMain.logger.warn("Caught exception while registering block ItemBlocks: " + e.toString());
			e.printStackTrace();
		}
    	
    	ZSSItemHelper.addItemForZssCreativeTab(cuccoGlove);
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
    	
    	if(AddonConfig.enableNewBasicSword())
    	{
        	GameRegistry.addRecipe(new ItemStack(swordBasic, 1), new Object[]{"X  ", " X ", "  O", 'X', Items.iron_ingot, 'O', Items.stick});
    	}
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(phantomBlade, 1), metal1, metal2, metal3);
    	GameRegistry.addSmelting(metal1ore, new ItemStack(metal1), 100);
    	GameRegistry.addSmelting(metal2ore, new ItemStack(metal2), 100);
    	GameRegistry.addSmelting(metal3ore, new ItemStack(metal3), 100);
    	GameRegistry.addShapelessRecipe(new ItemStack(swordPhantom, 1), swordLokomo);
    	GameRegistry.addShapelessRecipe(new ItemStack(swordLokomo, 1), swordPhantom, spiritEssence);
	
    	GameRegistry.addShapelessRecipe(new ItemStack(blueToonHelmet, 1), greenToonHelmet, new ItemStack(Items.dye, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(blueToonChest, 1), greenToonChest, new ItemStack(Items.dye, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(blueToonLegs, 1), greenToonLegs, new ItemStack(Items.dye, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(redToonHelmet, 1), redToonHelmet, new ItemStack(Items.dye, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(redToonChest, 1), redToonChest, new ItemStack(Items.dye, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(redToonLegs, 1), redToonLegs, new ItemStack(Items.dye, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(purpleToonHelmet, 1), purpleToonHelmet, new ItemStack(Items.dye, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(purpleToonChest, 1), purpleToonChest, new ItemStack(Items.dye, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(purpleToonLegs, 1), purpleToonLegs, new ItemStack(Items.dye, 1, 5));
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
}
