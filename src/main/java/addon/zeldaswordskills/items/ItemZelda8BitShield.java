package addon.zeldaswordskills.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import zeldaswordskills.block.tileentity.TileEntityDungeonCore;
import zeldaswordskills.item.ItemZeldaShield;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.WorldUtils;

public class ItemZelda8BitShield extends ItemZeldaShield{

	public ItemZelda8BitShield(ToolMaterial material, float magicReduction, int recoveryTime, float decayRate, float recoveryRate)
	{
		super(material, magicReduction, recoveryTime, decayRate, recoveryRate);
	}

	@Override
	public void handleFairyUpgrade(EntityItem item, EntityPlayer player, TileEntityDungeonCore core)
	{
		if (core.consumeRupees(64))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.eightBitShieldMagical), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else
		{
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
			PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.unworthy"));
		}
	}

	@Override
	public boolean hasFairyUpgrade(ItemStack stack)
	{
		return this == AddonItems.eightBitShieldSmall;
	}
}
