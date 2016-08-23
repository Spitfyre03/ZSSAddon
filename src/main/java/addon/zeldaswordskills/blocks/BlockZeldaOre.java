package addon.zeldaswordskills.blocks;

import java.util.Random;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockZeldaOre extends BlockOre
{

    public BlockZeldaOre()
    {
        this.setCreativeTab(ZSSAddon.miscTab);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	if(this == AddonItems.metal1ore || this == AddonItems.metal2ore || this == AddonItems.metal3ore)
    	{
    		return Item.getItemFromBlock(this);
    	}
    	else
    	{
    		return Item.getItemFromBlock(Blocks.stone);
    	}
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int par1, Random rand)
    {
        return 1;
    }

    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        return 100;
    }
}