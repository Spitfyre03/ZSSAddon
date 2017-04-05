package addon.zeldaswordskills.items;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers(ItemModelMesher mesher) {
		String[] variants = getVariants();
		if (variants == null || variants.length < 1) {
			String name = getUnlocalizedName();
			variants = new String[]{ZSSAddon.ModID + ":" + name.substring(name.lastIndexOf(".") + 1)};
		}
		for (int i = 0; i < variants.length; ++i) {
			mesher.register(this, i, new ModelResourceLocation(variants[i], "inventory"));
		}
	}
}
