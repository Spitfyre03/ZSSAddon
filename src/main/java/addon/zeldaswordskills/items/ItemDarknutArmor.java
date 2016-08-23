package addon.zeldaswordskills.items;

import java.util.List;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class ItemDarknutArmor extends ItemArmor
{
	public ItemDarknutArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(ZSSAddon.combatTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		switch(slot)
		{
			case 2:
				return ZSSAddon.ModID + ":" + "textures/models/armor/darknutBelt.png";
			case 3:
				return ZSSAddon.ModID + ":" + "textures/models/armor/darknutAccessories.png";
			default:
				return ZSSAddon.ModID + ":" + "textures/models/armor/darknutArmor.png";
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		ModelBiped armorModel = new ModelBiped();
		
		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ItemDarknutArmor)
			{
				int type = ((ItemArmor)itemStack.getItem()).armorType;
			
			if(type == 1)
			{
				armorModel = ZSSAddon.proxy.getArmorModel(0);
			}
			else if(type == 0)
			{
				armorModel = ZSSAddon.proxy.getArmorModel(1);
			}
			else
			{
				armorModel = ZSSAddon.proxy.getArmorModel(2);
			}
		}
		
		if(armorModel != null)
		{
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = armorSlot == 0;
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
			if(entityLiving instanceof EntityPlayer)
			{
				armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
			}
			return armorModel;
		}
	}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));
	}
}