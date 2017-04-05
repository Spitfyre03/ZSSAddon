package addon.zeldaswordskills.blocks;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import zeldaswordskills.block.tileentity.TileEntityBase;

public class TileEntityCandle extends TileEntityZSSA
{
	private boolean isLit;
	
	@Override
    public void writeToNBT(NBTTagCompound compound)
	{
        super.writeToNBT(compound);
    	compound.setBoolean("isLit", this.isLit);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.isLit = compound.getBoolean("isLit");
    }
	
	public void toggleFire()
	{ this.isLit = !this.isLit; }
	public boolean onFire()
	{ return isLit; }
	public void onCreated()
	{ isLit = false; }
}
