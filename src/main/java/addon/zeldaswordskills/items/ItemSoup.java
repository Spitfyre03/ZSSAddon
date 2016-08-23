package addon.zeldaswordskills.items;

import java.util.List;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSoup extends ItemZeldaAddon
{
    public ItemSoup()
    {
    	super();
    	
        this.setCreativeTab(ZSSAddon.miscTab);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
        --stack.stackSize;
        
        player.heal(20F);
        player.getFoodStats().addStats(16, 5.0F);
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 600));
        
        if(this == AddonItems.soupFull)
        {
        	stack.setItem(AddonItems.soupHalf);
        }
        
        return stack;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (playerIn.canEat(false))
        {
            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        }

        return itemStackIn;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced)
	{
		list.add(StatCollector.translateToLocal(getUnlocalizedName() + ".desc"));
		list.add("");
		list.add(EnumChatFormatting.BLUE + "+" + EnumChatFormatting.OBFUSCATED + "20 Health Points");
	}
}