package addon.zeldaswordskills.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zeldaswordskills.util.PlayerUtils;

public class ItemTeleporter extends Item
{	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		{
			PlayerUtils.sendTranslatedChat(player, "Work in progress.");
		}
		
        return stack;
    }
}
