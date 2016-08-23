package addon.zeldaswordskills.items;

import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;

public class ItemBasicZeldaSword extends ItemZeldaSword
{
	public ItemBasicZeldaSword(ToolMaterial material, float bonusDamage)
	{
		super(material, bonusDamage);
		this.setCreativeTab(ZSSAddon.combatTab);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		boolean damage = false;
		
		if (entity instanceof EntityVillager)
		{
			if(!player.worldObj.isRemote)
			{
				EntityVillager villager = (EntityVillager) entity;
				
				if(("Soldier").equals(villager.getCustomNameTag()) || ("Guard").equals(villager.getCustomNameTag()) || ("General").equals(villager.getCustomNameTag()) || ("Knight").equals(villager.getCustomNameTag()) || ("Captain").equals(villager.getCustomNameTag()))
				{
					if(this == AddonItems.swordBasic)
					{
						PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
						
						if(stack.getItemDamage() >= 126)
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.guard.trade.1.2"));
						}
						else if(stack.getItemDamage() <= 125)
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.guard.trade.1.1"));
						}
						
						player.setCurrentItemOrArmor(0, new ItemStack(AddonItems.swordRecruit));
					}
					else if(this == AddonItems.swordRecruit)
					{
						PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
						
						if(stack.getItemDamage() >= 126)
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.guard.trade.2.2"));
						}
						else if(stack.getItemDamage() <= 125)
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.guard.trade.2.1"));
						}
						
						player.setCurrentItemOrArmor(0, new ItemStack(AddonItems.swordBasic));
					}
				}
				if(("Grandma").equals(villager.getCustomNameTag()) || ("Grannie").equals(villager.getCustomNameTag()) || ("Grandmother").equals(villager.getCustomNameTag()) || ("Gran").equals(villager.getCustomNameTag()))
				{
					if(this == AddonItems.swordBasic || this == AddonItems.swordOshus || this == AddonItems.swordRecruit)
					{
						if(!player.getEntityData().getBoolean("GrandmaGear"))
						{
							player.getEntityData().setBoolean("GrandmaGear", true);
							player.inventory.addItemStackToInventory(new ItemStack(AddonItems.shieldHero));
							if(AddonConfig.doesGrandmaGiveArmor())
							{
								player.inventory.addItemStackToInventory(new ItemStack(AddonItems.greenToonHelmet));
								player.inventory.addItemStackToInventory(new ItemStack(AddonItems.greenToonChest));
								player.inventory.addItemStackToInventory(new ItemStack(AddonItems.greenToonLegs));
								player.inventory.addItemStackToInventory(new ItemStack(AddonItems.toonBoots));
							}
							PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.grandma.gear.get"));
						}
						else
						{
							PlayerUtils.playSound(player, Sounds.VILLAGER_HAGGLE, 1.0F, 1.0F);
							if(AddonConfig.doesGrandmaGiveArmor())
							{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.grandma.gear.cheat"));
							}
							else
							{
								PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.grandma.gear.cheat.shield"));
							}
						}
					}
					
				//I forgot that this is inside the ItemBasicZeldaSword class...
				//I will have to add the GrandmaNPC
					
					/**else if(this == Items.glass_bottle)
					{
					player.inventory.consumeInventoryItem(this);
					player.inventory.addItemStackToInventory(new ItemStack(ZSSItems.potionBlue));
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.grandma.soup"));
					}*/
				}
				if(("Oshus").equals(villager.getCustomNameTag()) || ("Ocean King").equals(villager.getCustomNameTag()))
				{
					if(this == AddonItems.swordBasic)
					{
						player.setCurrentItemOrArmor(0, new ItemStack(AddonItems.swordOshus));
						PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
						PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.oshus.trade.1"));
					}
					else if(this == AddonItems.swordOshus)
					{
						player.setCurrentItemOrArmor(0, new ItemStack(AddonItems.swordBasic));
						PlayerUtils.playSound(player, Sounds.VILLAGER_IDLE, 1.0F, 1.0F);
						PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.oshus.trade.2"));
					}
				}	
			}	
			
		damage = true;
		
		}
		else
		{
			damage = false;
		}
		
		return damage;
	}
	
}