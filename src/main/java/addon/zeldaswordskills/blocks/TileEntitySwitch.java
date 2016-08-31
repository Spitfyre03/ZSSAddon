package addon.zeldaswordskills.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import addon.zeldaswordskills.AddonConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ChestGenHooks;
import zeldaswordskills.entity.projectile.EntityCeramicJar;
import zeldaswordskills.world.gen.DungeonLootLists;

public class TileEntitySwitch extends TileEntityZSSA implements IUpdatePlayerListBox
{
	private int type;
	private int pointing;
	private boolean toggled;
	private ItemStack jarItem;
	private boolean hasJar;
	
	@Override
    public void writeToNBT(NBTTagCompound compound)
	{
        super.writeToNBT(compound);
        compound.setInteger("type", this.type);
        compound.setInteger("side", this.pointing);
        compound.setBoolean("toggled", this.toggled);
    	compound.setBoolean("hasJar", this.hasJar);
    	
    	if (jarItem != null)
    	{
    		NBTTagCompound stack = new NBTTagCompound();
    		this.jarItem.writeToNBT(stack);
    		compound.setTag("jarItem", stack);
    	}
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.type = compound.getInteger("type");
        this.pointing = compound.getInteger("side");
        this.toggled = compound.getBoolean("toggled");
        this.hasJar = compound.getBoolean("hasJar");
        if (compound.hasKey("jarItem")) this.jarItem = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("jarItem"));
    }
    
    public void onCreated(int side, int type)
    {
    	this.pointing = side;
		this.type = type;
    }
    
    public int getSide() { return this.pointing; }
    public int getType() { return this.type; }
    public void setToggled(boolean toggled) { this.toggled = toggled; }
    public boolean isToggled() { return toggled; }

	@Override
	public void update()
	{
		AxisAlignedBB axisalignedbb = new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 0.4, pos.getZ() + 1).expand(0.2, 0.4, 0.2);
        List list;

        if(AddonConfig.doesOnlyPlayerActivate()) list = worldObj.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
        else list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
	
        /**List jarList;
        jarList = worldObj.getEntitiesWithinAABB(EntityCeramicJar.class, axisalignedbb);
        
        if(!jarList.isEmpty() && !hasJar())
        {
        	Iterator iterator = jarList.iterator();
        	EntityCeramicJar jar = (EntityCeramicJar)iterator.next();
            
        	if(jar.getNBTTagCompound() != null)
        	{
        		if (jar.getNBTTagCompound().hasKey("jarItem"))
        		{
        			ItemStack jarItem = ItemStack.loadItemStackFromNBT(jar.getNBTTagCompound().getCompoundTag("jarItem"));
        		}
        	}
            addJar(jarItem);
			worldObj.notifyNeighborsOfStateChange(pos, worldObj.getBlockState(pos).getBlock());
			jar.setDead();
        }*/
        
        if (!list.isEmpty())
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                Entity entity = (Entity)iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate())
                {
                	if(!isToggled() && (type != 2))
                	{
                		setToggled(true);
                		worldObj.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
                		worldObj.notifyNeighborsOfStateChange(pos, worldObj.getBlockState(pos).getBlock());
                	}
                }
            }
        }
        else if(type == 1)
        {
        	if(isToggled() && !hasJar())
        	{
        		setToggled(false);
        		worldObj.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, 0.6F);
        		worldObj.notifyNeighborsOfStateChange(pos, worldObj.getBlockState(pos).getBlock());
        	}
        }
	}

	public boolean hasJar() { return hasJar; }
	public void removeJar() { hasJar = false; }
	public void addJar(ItemStack stack) { hasJar = true; jarItem = stack; }
	public ItemStack getJarItem() { return jarItem; }
}
