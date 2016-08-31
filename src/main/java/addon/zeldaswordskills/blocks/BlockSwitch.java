package addon.zeldaswordskills.blocks;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zeldaswordskills.block.ZSSBlocks;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.util.PlayerUtils;

public class BlockSwitch extends BlockContainer
{
	int type;
	
	public BlockSwitch(int type)
	{
		super(Material.iron);
		this.setCreativeTab(ZSSAddon.miscTab);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		this.type = type;
		this.setHardness(6.0F);
	}
	
	public boolean isFullCube(){ return false; }
	public int getRenderType(){ return -1; }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing face, float hitX, float hitY, float hitZ)
	{	
		if (!world.isRemote){
		TileEntitySwitch te = (TileEntitySwitch) world.getTileEntity(pos);
		
		if(te.getJarItem() != null) PlayerUtils.sendTranslatedChat(player, "Jar Item: " + te.getJarItem().getDisplayName());
		PlayerUtils.sendTranslatedChat(player, "Has Jar: " + te.hasJar());
		PlayerUtils.sendTranslatedChat(player, "Toggled?: " + te.isToggled());
		
		if(player.getHeldItem() == null && te.hasJar())
		{
			ItemStack jarStack = new ItemStack(ZSSBlocks.ceramicJar);
			if(te.getJarItem() != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				te.getJarItem().writeToNBT(item);
				jarStack.setTagCompound(new NBTTagCompound());
				jarStack.getTagCompound().setTag("jarStack", item);

			}

			player.setCurrentItemOrArmor(0, jarStack);
			te.removeJar();
			
			world.notifyNeighborsOfStateChange(pos, world.getBlockState(pos).getBlock());
			return true;
			}
		}
		return false;
	}
	
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
	{
		TileEntitySwitch te = (TileEntitySwitch) world.getTileEntity(pos);
		if(player.inventory.getCurrentItem() != null)
		{
			if(player.inventory.getCurrentItem().getItem() == ZSSItems.hammerMegaton || player.inventory.getCurrentItem().getItem() == ZSSItems.hammerSkull)
			{
				te.setToggled(true);
				world.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, 0.1F);
				world.notifyNeighborsOfStateChange(pos, this);
			}
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack item)
    {
		int direction = MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		TileEntitySwitch te = (TileEntitySwitch) world.getTileEntity(pos);
		int side = 0;
		if(direction == 0)
		{
			side = 3;
		}
		if(direction == 1)
		{
			side = 0;
		}
		if(direction == 2)
		{
			side = 1;
		}
		if(direction == 3)
		{
			side = 2;
		}
		
		te.onCreated(side, type);
    }

    public boolean canProvidePower(){ return true; }
	public TileEntity createNewTileEntity(World world, int meta){ return new TileEntitySwitch(); }
	public boolean isOpaqueCube(){ return false; }

	protected AxisAlignedBB getSensitiveAABB(BlockPos pos)
    {
        return new AxisAlignedBB((double)((float)pos.getX() + 0.125F), (double)pos.getY(), (double)((float)pos.getZ() + 0.125F), (double)((float)(pos.getX() + 1) - 0.125F), (double)pos.getY() + 0.25D, (double)((float)(pos.getZ() + 1) - 0.125F));
    }
	
    public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side)
    {	
    	TileEntitySwitch te = (TileEntitySwitch) world.getTileEntity(pos);
    	if(te.isToggled())
    	{
    		return 15;
    	}
    	else return 0;
    }
}