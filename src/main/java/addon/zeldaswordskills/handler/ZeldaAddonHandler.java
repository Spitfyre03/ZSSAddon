package addon.zeldaswordskills.handler;

import addon.zeldaswordskills.items.AddonItems;
import addon.zeldaswordskills.items.ItemAddonZeldaShield;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.MerchantRecipeHelper;
import zeldaswordskills.util.PlayerUtils;

@SideOnly(Side.CLIENT)
public class ZeldaAddonHandler
{
	//Man, is this necessary?
	@SubscribeEvent
	public void kokiriSwordTradeEvent(LivingAttackEvent event)
	{
		if(event.entityLiving instanceof EntityVillager && event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			EntityVillager villager = (EntityVillager) event.entityLiving;
			MerchantRecipeList trades = villager.getRecipes(player);
			if(player.getHeldItem().getItem() != AddonItems.shieldBlue && player.getHeldItem().getItem() instanceof ItemAddonZeldaShield)
			{
				if(villager.getProfession() == 3)
				{
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(ZSSItems.swordKokiri, 1), new ItemStack(Items.emerald, 50), new ItemStack(AddonItems.swordRazor)));
					PlayerUtils.playSound(player, Sounds.VILLAGER_HAGGLE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.villager.kokirisword"));
					event.setCanceled(true);
				}
			}
		}
	}
}