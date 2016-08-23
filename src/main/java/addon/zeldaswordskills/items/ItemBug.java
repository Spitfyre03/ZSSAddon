package addon.zeldaswordskills.items;

import java.util.List;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.ref.ModInfo;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;

public class ItemBug extends Item
{
	public int value;
	
	public ItemBug()
	{
		super();

		setCreativeTab(ZSSAddon.bugTab);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (!player.worldObj.isRemote && entity instanceof EntityVillager)
		{
			EntityVillager villager = (EntityVillager) entity;
			
			if(("Bug Trader").equals(villager.getCustomNameTag()) || ("Bug Maniac").equals(villager.getCustomNameTag()) || ("Bug Dealer").equals(villager.getCustomNameTag()) || ("Bug Catcher").equals(villager.getCustomNameTag()) || ("Bug Collector").equals(villager.getCustomNameTag()))
			{
				PlayerUtils.addItemToInventory(player, new ItemStack(Items.emerald, this.getValue() * player.inventory.getCurrentItem().stackSize));
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.bug.trade.1") + ": " + this.getValue() * player.inventory.getCurrentItem().stackSize + " " + StatCollector.translateToLocal("chat.zss.bug.trade.2"));
				PlayerUtils.consumeHeldItem(player, player.inventory.getCurrentItem().getItem(), player.inventory.getCurrentItem().stackSize);
				PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
			}
		}
		
		return true;
	}

	public int getValue()
	{
		return value;
	}

	public Item setValue(int value2)
	{
		value = value2;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));
	}
}
