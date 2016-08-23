package addon.zeldaswordskills.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zeldaswordskills.util.PlayerUtils;

public class ItemPhantomHourglass extends ItemZeldaAddon
{
	public ItemPhantomHourglass()
	{
		super();
		this.setMaxDamage(200);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par1, boolean par2)
	{
		if (stack.getItemDamage() >= 200 && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			player.inventory.consumeInventoryItem(AddonItems.phantomHourglassFilled);
			PlayerUtils.addItemToInventory(player, new ItemStack(AddonItems.phantomHourglass, 1));
		}
		
		if(entity instanceof EntityPlayer)
		{
			EntityPlayer living = (EntityPlayer) entity;

			int x = (int) Math.floor(living.posX);
			int y = (int) (living.posY - living.getYOffset());
			int z = (int) Math.floor(living.posZ);
			Random rand = new Random();
			if(rand.nextInt(8) == 2)
			{
			if (world.getBlockState(new BlockPos(x, y - 1, z)) == AddonItems.phantomBlock.getDefaultState())
			{
				if(stack.getItem() == AddonItems.phantomHourglass)
				{
					living.attackEntityFrom(DamageSource.magic, 3);
				}
				else
				{
					stack.setItemDamage(stack.getItemDamage() + 1);
				}
			}
			else if (world.getBlockState(new BlockPos(x, y - 2, z)) == AddonItems.phantomBlock.getDefaultState())
			{
				if(stack.getItem() == AddonItems.phantomHourglass)
				{
					living.attackEntityFrom(DamageSource.magic, 3);
				}
				else
				{
					stack.setItemDamage(stack.getItemDamage() + 1);
				}
			}
			else if (world.getBlockState(new BlockPos(x, y - 3, z)) == AddonItems.phantomBlock.getDefaultState())
			{
				if(stack.getItem() == AddonItems.phantomHourglass)
				{
					living.attackEntityFrom(DamageSource.magic, 3);
				}
				else
				{
					stack.setItemDamage(stack.getItemDamage() + 1);
				}
			}
			}
		}
	}
}
