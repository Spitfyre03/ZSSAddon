package addon.zeldaswordskills;

import java.lang.reflect.Field;

import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zeldaswordskills.block.ISpecialRenderer;
import zeldaswordskills.block.ZSSBlocks;
import zeldaswordskills.client.ISwapModel;
import zeldaswordskills.item.IModItem;
import zeldaswordskills.ref.ModInfo;

public class ItemRenderer
{
	static String modid = ZSSAddon.ModID;
	
	public static void registerItemRenderer()
	{
	    reg(AddonItems.bigBugNet);
	    reg(AddonItems.bugNet);
	    reg(AddonItems.cuccoGlove);
	    reg(AddonItems.darknutBoots);
	    reg(AddonItems.darknutLegs);
	    reg(AddonItems.darknutChest);
	    reg(AddonItems.darknutHelmet);
	    reg(AddonItems.eightBitShieldMagical);
	    reg(AddonItems.eightBitShieldSmall);
	    reg(AddonItems.eightBitSwordMagical);
	    reg(AddonItems.eightBitSwordWhite);
	    reg(AddonItems.eightBitSwordWooden);
	    reg(AddonItems.fairyDust);
	    reg(AddonItems.fierceFragment);
	    reg(AddonItems.goldDust);
	    reg(AddonItems.greenToonChest);
	    reg(AddonItems.greenToonLegs);
	    reg(AddonItems.greenToonHelmet);
	    reg(AddonItems.hourSand);
	    reg(AddonItems.metal1);
	    reg(AddonItems.metal2);
	    reg(AddonItems.metal3);
	    reg(AddonItems.metal1ore);
	    reg(AddonItems.metal2ore);
	    reg(AddonItems.metal3ore);
	    reg(AddonItems.phantomBlade);
	    reg(AddonItems.phantomBlock);
	    reg(AddonItems.phantomHourglass);
	    reg(AddonItems.phantomHourglassFilled);
	    reg(AddonItems.shieldBlue);
	    reg(AddonItems.shieldFace);
	    reg(AddonItems.shieldHero);
	    reg(AddonItems.shieldOrdon);
	    reg(AddonItems.shieldSacred1);
	    reg(AddonItems.shieldSacred2);
	    reg(AddonItems.shieldSacred3);
	    reg(AddonItems.shieldSteel1);
	    reg(AddonItems.shieldSteel2);
	    reg(AddonItems.shieldSteel3);
	    reg(AddonItems.shieldSupport);
	    reg(AddonItems.shieldWood1);
	    reg(AddonItems.shieldWood2);
	    reg(AddonItems.shieldWood3);

	    regBug(AddonItems.bigBeetle);
	    regBug(AddonItems.volcanicLadybug);
	    regBug(AddonItems.smallBeetle);
	    
	    reg(AddonItems.spawnEggLandOctorok, 0);
	    reg(AddonItems.spawnEggLandOctorok, 1);
	    reg(AddonItems.spiritEssence);
	    reg(AddonItems.swordBasic);
	    reg(AddonItems.swordFairy);
	    reg(AddonItems.swordFierce);
	    reg(AddonItems.swordGilded);
	    reg(AddonItems.swordGoddess1);
	    reg(AddonItems.swordGoddess2);
	    reg(AddonItems.swordGoddess3);
	    reg(AddonItems.swordLokomo);
	    reg(AddonItems.swordOshus);
	    reg(AddonItems.swordPhantom);
	    reg(AddonItems.swordRazor);
	    reg(AddonItems.swordRecruit);
	    reg(AddonItems.swordSupport);
	    reg(AddonItems.toonBoots);
	    reg(AddonItems.triforce);
	    reg(AddonItems.triforceShard);

	    /**reg(AddonItems.swordPicori);
	    reg(AddonItems.swordBlue);
	    reg(AddonItems.swordRed);
	    reg(AddonItems.swordGreen);*/
	}

	public static void reg(Item item)
	{
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
	    register(item, 0, new ModelResourceLocation
	    (modid + ":" + item.getUnlocalizedName().substring(9), "inventory"));
	}
	
	
	public static void reg(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
	    register(Item.getItemFromBlock(block), 0, new ModelResourceLocation
	    (modid + ":" + block.getUnlocalizedName().substring(9), "inventory"));
	}
	
	public static void reg(Item item, int meta)
	{
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
	    register(item, meta, new ModelResourceLocation
	    (modid + ":" + item.getUnlocalizedName().substring(9), "inventory"));
	}
	
	public static void reg(Block block, int meta) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
	    register(Item.getItemFromBlock(block), meta, new ModelResourceLocation
	    (modid + ":" + block.getUnlocalizedName().substring(9), "inventory"));
	}
	
	public static void regBug(Item item)
	{
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
	    register(item, 0, new ModelResourceLocation
	    (modid + ":" + item.getUnlocalizedName().substring(13), "inventory"));
	}
}
