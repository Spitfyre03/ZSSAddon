package addon.zeldaswordskills.items;

import java.util.List;
import java.util.Random;

import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.entity.EntityBug;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.api.item.IFairyUpgrade;
import zeldaswordskills.block.tileentity.TileEntityDungeonCore;
import zeldaswordskills.entity.passive.EntityFairy;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.ref.ModInfo;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.WorldUtils;

public class ItemBugNet extends Item implements IFairyUpgrade
{
	protected ItemBugNet()
	{
		super();
        this.setMaxStackSize(1);
        this.setMaxDamage(120);
	}

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		Random rand = player.worldObj.rand;
		
		if (!player.worldObj.isRemote && entity instanceof EntityBug)
		{
			EntityBug bug = (EntityBug) entity;
			
			if(AddonConfig.doesBugsEscapeNet())
			{
				int bugChance = rand.nextInt(bug.getStrength());
				
				if(this == AddonItems.bugNet)
				{
					if(bugChance == 0)
					{
						player.inventory.addItemStackToInventory(new ItemStack(bug.getItem(), 1));
						bug.setDead();
					}
					else
					{
						player.getCurrentEquippedItem().damageItem(3, player);
					}
				}
				else
				{
					if(bugChance == 0 || bugChance == 1 || bugChance == 2 || bugChance == 3 || bugChance == 4)
					{
						player.inventory.addItemStackToInventory(new ItemStack(bug.getItem(), 1));
						bug.setDead();
					}
					else
					{
						player.getCurrentEquippedItem().damageItem(1, player);
					}
				}
			}
			else
			{ 
				player.inventory.addItemStackToInventory(new ItemStack(bug.getItem(), 1));
				bug.setDead();
			}
			
			return true;
		}
		else if(!player.worldObj.isRemote && entity instanceof EntityFairy)
		{
			EntityFairy fairy = (EntityFairy) entity;
			
			if(AddonConfig.doesBugsEscapeNet())
			{
				int fairyChance = rand.nextInt(3);
				
				if(this == AddonItems.bugNet)
				{
					if(fairyChance == 0)
					{
						if(PlayerUtils.hasItem(player, Items.glass_bottle))
						{
							for (int a = 0; a < player.inventory.getSizeInventory(); ++a)
							{
								ItemStack stack3 = player.inventory.getStackInSlot(a);
								
								if(stack3 == null)
								{
									for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
									{
										ItemStack stack2 = player.inventory.getStackInSlot(i);
								
										if (stack2 != null)
										{
											if (stack2.getItem() == Items.glass_bottle)
											{
												stack2.stackSize = stack2.stackSize - 1;

												player.inventory.addItemStackToInventory(new ItemStack(ZSSItems.fairyBottle, 1));
												fairy.setDead();
											}
										}
									}
								}
								else
								{
									PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.bugnet.fairy.2"));
								}
							}
						}
						else
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.bugnet.fairy.1"));
						}
					}
					else
					{
						player.getCurrentEquippedItem().damageItem(3, player);
					}
				}
			}
			else
			{ 
				if(PlayerUtils.hasItem(player, Items.glass_bottle))
				{
					for (int a = 0; a < player.inventory.getSizeInventory(); ++a)
					{
						ItemStack stack3 = player.inventory.getStackInSlot(a);
						
						if(stack3 == null)
						{
							for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
							{
								ItemStack stack2 = player.inventory.getStackInSlot(i);
						
								if (stack2 != null)
								{
									if (stack2.getItem() == Items.glass_bottle)
									{
										stack2.stackSize = stack2.stackSize - 1;

										player.inventory.addItemStackToInventory(new ItemStack(ZSSItems.fairyBottle, 1));
										fairy.setDead();
									}
								}
							}
						}
						else
						{
							PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.bugnet.fairy.2"));
						}
					}
				}
				else
				{
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.bugnet.fairy.1"));
				}
			}
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected void onStackDamaged(ItemStack stack, EntityLivingBase entity)
	{
		if(stack.getItem() == AddonItems.bugNet)
		{
			stack.setItemDamage(stack.getItemDamage() - 1);
		}
		if (stack.stackSize < 1 && entity instanceof EntityPlayer)
		{
			{
				EntityPlayer player = (EntityPlayer) entity;
				
				PlayerUtils.consumeHeldItem(player, player.inventory.getCurrentItem().getItem(), 1);
			}
		}
	}

    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
	
    @Override
	public void handleFairyUpgrade(EntityItem item, EntityPlayer player, TileEntityDungeonCore core)
	{
		ItemStack stack = item.getEntityItem();
		
		if (stack.getItem() == AddonItems.bugNet)
		{
			if(core.consumeRupees(64))
			{
				item.setDead();
				WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.bigBugNet), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
				core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
			}
			else
			{
				core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.unworthy"));
			}
		}
	}

	@Override
	public boolean hasFairyUpgrade(ItemStack stack)
	{
		return this == AddonItems.bugNet;
	}
    
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));	
	}
}
