package addon.zeldaswordskills.items;

import java.util.List;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.api.item.IFairyUpgrade;
import zeldaswordskills.block.tileentity.TileEntityDungeonCore;
import zeldaswordskills.entity.player.ZSSPlayerSkills;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.skills.SkillBase;
import zeldaswordskills.util.MerchantRecipeHelper;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.WorldUtils;

public class ItemZeldaAddon extends Item implements IFairyUpgrade
{
	public ItemZeldaAddon()
	{
		super();
	}
	
	public ItemZeldaAddon addToTab()
	{
		setCreativeTab(ZSSAddon.miscTab);
		return this;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (!player.worldObj.isRemote && entity instanceof EntityVillager)
		{
			EntityVillager villager = (EntityVillager) entity;
			MerchantRecipeList trades = villager.getRecipes(player);
			
			if(("Gabora").equals(villager.getCustomNameTag()) || ("Zubora").equals(villager.getCustomNameTag()))
			{
				if(this == AddonItems.goldDust)
				{
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(AddonItems.swordRazor), stack.copy(), new ItemStack(AddonItems.swordGilded)));
					PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss." + villager.getCustomNameTag() + ".golddust"));
				}
			}
			else if(("Oshus").equals(villager.getCustomNameTag()) || ("Ocean King").equals(villager.getCustomNameTag()))
			{
				if(this == AddonItems.phantomBlade)
				{
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(AddonItems.phantomHourglass), new ItemStack(AddonItems.phantomBlade), new ItemStack(AddonItems.swordPhantom)));
					PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.oshus.blade"));
				}
				else if(this == AddonItems.phantomHourglass)
				{
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(AddonItems.phantomHourglass), new ItemStack(AddonItems.phantomBlade), new ItemStack(AddonItems.swordPhantom)));
					PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.oshus.hourglass"));
				}
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@Override
	public void handleFairyUpgrade(EntityItem item, EntityPlayer player, TileEntityDungeonCore core)
	{
		ItemStack stack = item.getEntityItem();
		
	
		if (stack.getItem() == AddonItems.fairyDust)
		{
			if (ZSSPlayerSkills.get(player).getSkillLevel(SkillBase.bonusHeart) > 7)
			{
				if(core.consumeRupees(64))
				{
					item.setDead();
					WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.swordFairy), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
					core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
				}
				else
				{
					core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.unworthy"));
				}
			}
			else
			{
				core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.unleveled"));
			}
		}
		else if(stack.getItem() == AddonItems.fierceFragment)
		{
			if(PlayerUtils.hasItem(player, ZSSItems.maskFierce))
			{
				if (ZSSPlayerSkills.get(player).getSkillLevel(SkillBase.bonusHeart) > 14)
				{
					item.setDead();
					WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.swordFierce), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
					core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fierce.swordget"));
				}
				else
				{
					core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.unleveled"));
				}
			}
			else
			{
				core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.fierce"));
			}
		}
	}

	@Override
	public boolean hasFairyUpgrade(ItemStack stack)
	{
		return this == AddonItems.fairyDust || this == AddonItems.fierceFragment;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));
	}
}
