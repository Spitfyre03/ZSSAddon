package addon.zeldaswordskills.items;

import java.util.List;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.item.ItemArmorTunic;
import zeldaswordskills.ref.ModInfo;
public class ItemArmorToonic extends ItemArmorTunic
{
	public ItemArmorToonic(int par3, int par4)
	{
		super(par3, par4);
		this.setCreativeTab(ZSSAddon.combatTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String name = getUnlocalizedName();
		name = name.substring(name.lastIndexOf(".") + 1, name.lastIndexOf("_"));
		return String.format("%s:textures/armor/%s_layer_%d.png", ZSSAddon.ModID, name, (slot == 2 ? 2 : 1));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		ModelBiped armorModel = new ModelBiped();
		
		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ItemArmorToonic)
			{
				int type = ((ItemArmor)itemStack.getItem()).armorType;
			
				if(type != 2)
				{
					armorModel = ZSSAddon.proxy.getArmorModel(3, "toonic");
				}
				else
				{
					armorModel = ZSSAddon.proxy.getArmorModel(4, "toonic");
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