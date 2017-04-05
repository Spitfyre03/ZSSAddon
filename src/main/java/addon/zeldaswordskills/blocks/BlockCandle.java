package addon.zeldaswordskills.blocks;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.items.AddonItems;
import addon.zeldaswordskills.renderer.TileEntityCandleRenderer;
import addon.zeldaswordskills.renderer.TileEntitySwitchRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import zeldaswordskills.block.ISpecialRenderer;

public class BlockCandle extends BlockContainer implements ISpecialRenderer
{
	public BlockCandle()
	{
		super(Material.iron);
		this.setCreativeTab(ZSSAddon.miscTab);
		this.setBlockUnbreakable();
	}
	

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing face, float hitX, float hitY, float hitZ)
	{	
		if (!world.isRemote)
		{
			TileEntityCandle te = (TileEntityCandle) world.getTileEntity(pos);
		
			if(player.getHeldItem() != null && te.onFire())
			{
				if(player.getHeldItem().getItem() == AddonItems.lantern)
				{
					player.getHeldItem().damageItem(2, player);
					te.toggleFire();
					world.notifyNeighborsOfStateChange(pos, world.getBlockState(pos).getBlock());
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack item)
    {
		TileEntityCandle te = (TileEntityCandle) world.getTileEntity(pos);
		te.onCreated();
    }

    public boolean canProvidePower(){ return true; }
	public TileEntity createNewTileEntity(World world, int meta){ return new TileEntityCandle(); }
	
    public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side)
    {	
    	TileEntityCandle te = (TileEntityCandle) world.getTileEntity(pos);
    	if(te.onFire())
    	{
    		return 15;
    	}
    	else return 0;
    }
    
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    	TileEntityCandle te = (TileEntityCandle) worldIn.getTileEntity(pos);
    	
        if (!worldIn.isRemote)
        {
            if (te.onFire() && worldIn.isBlockPowered(pos.down(2)))
            {
                te.toggleFire();
            }
        }
    }


	@Override
	public void registerSpecialRenderer() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandle.class, new TileEntityCandleRenderer());
	}
}