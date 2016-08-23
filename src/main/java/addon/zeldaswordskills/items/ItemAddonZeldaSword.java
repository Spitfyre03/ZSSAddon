package addon.zeldaswordskills.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.util.PlayerUtils;
import addon.zeldaswordskills.ZSSAddon;

public class ItemAddonZeldaSword extends ItemZeldaSword
{
	public ItemAddonZeldaSword(ToolMaterial material, float bonusDamage)
	{
		super(material, bonusDamage);
		this.setCreativeTab(ZSSAddon.combatTab);
	}

	protected void onStackDamaged(ItemStack stack, EntityLivingBase entity)
	{
		if (stack.stackSize == 0 && entity instanceof EntityPlayer)
		{
			if(stack.getItem() == AddonItems.swordRazor)
			{
				PlayerUtils.addItemToInventory((EntityPlayer) entity, new ItemStack(ZSSItems.swordKokiri, 1));
			}
			else if(givesBrokenItem)
			{
				PlayerUtils.addItemToInventory((EntityPlayer) entity, new ItemStack(ZSSItems.swordBroken, 1, Item.getIdFromItem(this)));
			}
		}
	}
}
