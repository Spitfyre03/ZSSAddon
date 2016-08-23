package addon.zeldaswordskills.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import zeldaswordskills.entity.npc.EntityGoron;
import zeldaswordskills.item.ItemZeldaShield;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.MerchantRecipeHelper;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.TargetUtils;
import zeldaswordskills.util.WorldUtils;
import addon.zeldaswordskills.ZSSAddon;

public class ItemHeroZeldaShield extends ItemZeldaShield{

	public ItemHeroZeldaShield(ToolMaterial material, float magicReduction, int recoveryTime, float decayRate, float recoveryRate)
	{
		super(material, magicReduction, recoveryTime, decayRate, recoveryRate);
		this.setCreativeTab(ZSSAddon.combatTab);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (!player.worldObj.isRemote && entity instanceof EntityVillager)
		{
			boolean isGoron = (entity instanceof EntityGoron);
			EntityVillager villager = (EntityVillager) entity;
			MerchantRecipeList trades = villager.getRecipes(player);
			
			if (isGoron && villager.getCustomNameTag().equals("Biggoron"))
			{
				MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(stack.copy(), new ItemStack(AddonItems.shieldBlue)));
				PlayerUtils.playSound(player, Sounds.VILLAGER_HAGGLE, 1.0F, 1.0F);
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.biggoron.hungry.1"));
				PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.biggoron.hungry.2"));
			}
		}
		else if (entity instanceof EntityLivingBase)
		{
			WorldUtils.playSoundAtEntity(player, Sounds.HAMMER, 0.4F, 0.5F);
			TargetUtils.knockTargetBack((EntityLivingBase) entity, player);
		}
		
		return true;
	}
}
