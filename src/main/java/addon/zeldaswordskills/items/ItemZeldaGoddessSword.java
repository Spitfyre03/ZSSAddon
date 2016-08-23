package addon.zeldaswordskills.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import zeldaswordskills.block.BlockSacredFlame;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.WorldUtils;
import addon.zeldaswordskills.ZSSAddon;

public class ItemZeldaGoddessSword extends ItemZeldaSword
{
	public ItemZeldaGoddessSword(ToolMaterial material, float bonusDamage)
	{
		super(material, bonusDamage);
		setCreativeTab(ZSSAddon.combatTab);
	}
	
	@Override
	public boolean onActivatedSacredFlame(ItemStack stack, World world, EntityPlayer player, BlockSacredFlame.EnumType flame, boolean isActive)
	{
		return false;
	}

	@Override
	public boolean onClickedSacredFlame(ItemStack stack, World world, EntityPlayer player, BlockSacredFlame.EnumType type, boolean isActive) {
	{
		if (world.isRemote)
		{
			return false;
		}
		else if (isActive)
		{
			if(this == AddonItems.swordGoddess1)
			{
				changeSwords(stack, player);
				world.playSoundAtEntity(player, Sounds.FLAME_ABSORB, 1.0F, 1.0F);
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocalFormatted("chat.zss.sacred_flame.new",
				getItemStackDisplayName(player.inventory.getCurrentItem()), StatCollector.translateToLocal("misc.zss.sacred_flame.name." + type)));
				addSacredFlameEnchantments(player.inventory.getCurrentItem(), type);
						
				//NBTTags
				NBTTagCompound firstTag = player.inventory.getCurrentItem().getTagCompound();
				if(firstTag == null) { firstTag = new NBTTagCompound(); }
				firstTag.setInteger("SacredFlames", 0 | type.getBit());
				player.getCurrentEquippedItem().setTagCompound(firstTag);
				return true;
			}
			else
			{
				NBTTagCompound tag = player.inventory.getCurrentItem().getTagCompound();
				
				if (tag == null)
				{
					tag = new NBTTagCompound();
				}
				if ((tag.getInteger("SacredFlames") & type.getBit()) == 0)
				{
					tag.setInteger("SacredFlames", tag.getInteger("SacredFlames") | type.getBit());
					changeSwords(stack, player);
					player.getCurrentEquippedItem().setTagCompound(tag);
					world.playSoundAtEntity(player, Sounds.FLAME_ABSORB, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocalFormatted("chat.zss.sacred_flame.new",
					getItemStackDisplayName(player.inventory.getCurrentItem()), StatCollector.translateToLocal("misc.zss.sacred_flame.name." + type)));
					addSacredFlameEnchantments(player.inventory.getCurrentItem(), type);
					
					return true;
				}
				else
				{
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocalFormatted("chat.zss.sacred_flame.old.same", getItemStackDisplayName(stack)));
				}
			}
		}
		else
		{
			if (isActive)
			{
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.sacred_flame.incorrect.sword"));
			}
			else
			{
			PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.sacred_flame.inactive"));
			}
		}
		
		WorldUtils.playSoundAtEntity(player, Sounds.SWORD_MISS, 0.4F, 0.5F);
		
		return false;
		}
	}

	private void addSacredFlameEnchantments(ItemStack stack, BlockSacredFlame.EnumType flame)
	{
		switch(flame)
		{
			case DIN:
				stack.addEnchantment(Enchantment.fireAspect, 1);
				break;
			case FARORE:
				stack.addEnchantment(Enchantment.knockback, 1);
				break;
			case NAYRU:
				stack.addEnchantment(Enchantment.looting, 2);
				break;
		}
		
		boolean flag = false;
		NBTTagList enchList = stack.getTagCompound().getTagList("ench", Constants.NBT.TAG_COMPOUND);
		
		for (int i = 0; i < enchList.tagCount(); ++i)
		{
			NBTTagCompound compound = enchList.getCompoundTagAt(i);
			
			if (compound.getShort("id") == Enchantment.sharpness.effectId)
			{
				short lvl = compound.getShort("lvl");
				
				if (lvl < Enchantment.sharpness.getMaxLevel())
				{
					enchList.removeTag(i);
					stack.addEnchantment(Enchantment.sharpness, lvl + 1);
				}
				flag = true;
				
				break;
			}
		}
		if (!flag)
		{
			stack.addEnchantment(Enchantment.sharpness, 1);
		}
	}
	
	private void changeSwords(ItemStack stack, EntityPlayer player)
	{
		if(stack.getItem() == AddonItems.swordGoddess1)
		{
			player.inventory.consumeInventoryItem(this);
			player.inventory.addItemStackToInventory(new ItemStack(AddonItems.swordGoddess2, 1));
		}
		else if(stack.getItem() == AddonItems.swordGoddess2)
		{
			player.inventory.consumeInventoryItem(this);
			player.inventory.addItemStackToInventory(new ItemStack(AddonItems.swordGoddess3, 1));
		}
		else if(stack.getItem() == AddonItems.swordGoddess3)
		{
			player.inventory.consumeInventoryItem(this);
			player.inventory.addItemStackToInventory(new ItemStack(ZSSItems.swordMaster, 1));
		}
	}
}