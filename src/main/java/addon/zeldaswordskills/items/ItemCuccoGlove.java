package addon.zeldaswordskills.items;

import java.util.List;
import java.util.Random;

import addon.zeldaswordskills.AddonAchievements;
import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.entity.EntityCucco;
import addon.zeldaswordskills.entity.EntityCuccoGolden;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.ref.ModInfo;

public class ItemCuccoGlove extends Item
{
	protected ItemCuccoGlove()
	{
		super();
        this.setMaxStackSize(1);
	}
	
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isHeld)
    {
		Random rand = world.rand;
    	
    	EntityPlayer player = (entity instanceof EntityPlayer ? (EntityPlayer) entity : null);
    	EntityCucco cucco = (EntityCucco) player.riddenByEntity;
    	
    	if(player.riddenByEntity != null && player.riddenByEntity instanceof EntityCucco)
    	{
    		if (isHeld && entity.fallDistance > 1.0F && entity.motionY < 0)
    		{
    			if (player == null || !player.capabilities.isFlying)
    			{
    				entity.motionY = (entity.motionY < -0.05D ? -0.05D : entity.motionY);
    				entity.fallDistance = 1.0F;
    				
    				if(cucco instanceof EntityCuccoGolden && rand.nextInt(824) <= 3)
    				{
    					entity.motionY = player.motionY + 1.25D;
    				}
    			}
    		}
    		
    		if(rand.nextInt(8) == 2)
    		{
    			cucco.playSound(ZSSAddon.ModID + ":cuccoHeld", 1.0F, 1.0F);
    		}
    	}
    	
    	if(!isHeld)
    	{
    		if(player.riddenByEntity instanceof EntityCucco)
    		{
    			cucco.mountEntity((Entity)null);
    		}
    	}
    }
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if (!player.worldObj.isRemote && player.isSneaking())
        {
    		if(player.riddenByEntity != null && player.riddenByEntity instanceof EntityCucco)
    		{
    			EntityCucco cucco = (EntityCucco) player.riddenByEntity;
            	cucco.mountEntity((Entity)null);
    		}
        }
    	else if(!player.isSneaking())
    	{
    		if(AddonConfig.doesCuccoGloveLeap() && player.onGround) player.motionY = player.motionY + 0.75D;
    	}
    	
        return true;
    }
    
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		Random rand = player.worldObj.rand;
		Boolean boolean1;
		
		if (!player.worldObj.isRemote && entity instanceof EntityCucco)
		{
			EntityCucco cucco = (EntityCucco) entity;
			{
				player.addStat(AddonAchievements.cuccoMaster, 1);
				cucco.mountEntity(player);
			}
			
			boolean1 = true;
		}
		else
		{
			boolean1 = false;
		}
		
		return boolean1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.1"));
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.2"));
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.3"));	
	}
}
