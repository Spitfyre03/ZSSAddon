package addon.zeldaswordskills.blocks;
import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zeldaswordskills.entity.mobs.EntityDarknut;

public class BlockZeldaAddon extends Block
{

    public BlockZeldaAddon(Boolean unbreakable)
    {
    	super(Material.iron);
        this.setCreativeTab(ZSSAddon.miscTab);
        if(unbreakable) this.setBlockUnbreakable();
        this.setStepSound(soundTypeStone);
    }

    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
    	if(world.getBlockState(pos) == AddonItems.phantomBlock.getDefaultState())
    	{
    		if(entity instanceof EntityPlayer)
    		{
    			EntityPlayer player = (EntityPlayer) entity;
    			if(!(player.inventory.hasItem(AddonItems.phantomHourglass) || player.inventory.hasItem(AddonItems.phantomHourglassFilled)))
    			{
    				if(AddonConfig.doesPhantomInstantDeath())
    				{
    					player.attackEntityFrom(DamageSource.magic, 100.0F);
    				}
    				else
    				{
    					{
    						player.attackEntityFrom(DamageSource.magic, 3);
    					}
    				}
    			}
    		}
    		else
    		{
    			if(!(entity instanceof EntityDarknut))
    			{
    				entity.attackEntityFrom(DamageSource.magic, 100.0F);
    			}
    		}
    	}
    }
}