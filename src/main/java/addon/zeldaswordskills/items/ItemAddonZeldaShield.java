package addon.zeldaswordskills.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.block.tileentity.TileEntityDungeonCore;
import zeldaswordskills.client.render.item.ModelItemShield;
import zeldaswordskills.entity.ZSSEntityInfo;
import zeldaswordskills.entity.buff.Buff;
import zeldaswordskills.item.ItemZeldaShield;
import zeldaswordskills.ref.ModInfo;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.MerchantRecipeHelper;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.TargetUtils;
import zeldaswordskills.util.WorldUtils;

public class ItemAddonZeldaShield extends ItemZeldaShield
{	
	@SideOnly(Side.CLIENT)
	private List<ModelResourceLocation> models;
	
	public ItemAddonZeldaShield(ToolMaterial toolMaterial, float magicReduction, int recoveryTime, float decayRate, float recoveryRate)
	{
		super(toolMaterial, magicReduction, recoveryTime, decayRate, recoveryRate);
		this.setCreativeTab(ZSSAddon.combatTab);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity target)
	{
		if (!player.worldObj.isRemote && target instanceof EntityZombie)
		{
			EntityZombie zombie = (EntityZombie) target;
			if(this == AddonItems.shieldBlue)
			{
				if(("Gibdo").equals(zombie.getCustomNameTag()))
				{
					player.setCurrentItemOrArmor(0, new ItemStack(AddonItems.shieldFace));
					PlayerUtils.playSound(player, Sounds.DARKNUT_DIE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.gibdo.sorrow"));
				}
			}
		}
		if(!player.worldObj.isRemote && target instanceof EntityVillager)
		{
			EntityVillager villager = (EntityVillager) target;
			MerchantRecipeList trades = villager.getRecipes(player);
			if(this != AddonItems.shieldBlue && this instanceof ItemAddonZeldaShield)
			{
				if(villager.getProfession() == 3)
				{
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(Items.emerald, 25 + villager.worldObj.rand.nextInt(25)), new ItemStack(AddonItems.shieldWood1, 1)));
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(Items.emerald, 64), new ItemStack(Items.emerald, 20 + villager.worldObj.rand.nextInt(16)), new ItemStack(AddonItems.shieldSteel1, 1)));
					MerchantRecipeHelper.addToListWithCheck(trades, new MerchantRecipe(new ItemStack(Items.emerald, 64), new ItemStack(Items.emerald, 32 + villager.worldObj.rand.nextInt(32)), new ItemStack(AddonItems.shieldSacred1, 1)));
					PlayerUtils.playSound(player, Sounds.VILLAGER_HAGGLE, 1.0F, 1.0F);
					PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.villager.shield"));
				}
			}
		}
		super.onLeftClickEntity(stack, player, target);
		
		return true;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
	{
		if(stack.getItem() == AddonItems.shieldSacred1 || stack.getItem() == AddonItems.shieldSacred2 || stack.getItem() == AddonItems.shieldSacred3)
		{
			ZSSEntityInfo buffInfo = ZSSEntityInfo.get(player);
			buffInfo.applyBuff(Buff.RESIST_SHOCK, 5, 50);
		}
		
		super.onUsingTick(stack, player, count);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld)
	{
		list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.0"));
		
		if(!(this == AddonItems.shieldBlue))
		{
			list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip." + getUnlocalizedName().substring(5) + ".desc.1"));
		}
	}
	
	@Override
	public void handleFairyUpgrade(EntityItem item, EntityPlayer player, TileEntityDungeonCore core)
	{
		ItemStack stack = item.getEntityItem();
		if (stack.getItem() == AddonItems.shieldWood1 && core.consumeRupees(30))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldWood2), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldWood2 && core.consumeRupees(50))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldWood3), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldSteel1 && core.consumeRupees(50))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldSteel2), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldSteel2 && core.consumeRupees(100))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldSteel3), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldSacred1 && core.consumeRupees(100))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldSacred2), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldSacred2 && core.consumeRupees(150))
		{
			item.setDead();
			WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.shieldSacred3), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.SECRET_MEDLEY, 1.0F, 1.0F);
		}
		else if (stack.getItem() == AddonItems.shieldWood3 || stack.getItem() == AddonItems.shieldSteel3 || stack.getItem() == AddonItems.shieldSacred3)
		{
			core.getWorld().playSoundEffect(core.getPos().getX() + 0.5D, core.getPos().getY() + 1, core.getPos().getZ() + 0.5D, Sounds.FAIRY_LAUGH, 1.0F, 1.0F);
			PlayerUtils.sendTranslatedChat(player, StatCollector.translateToLocal("chat.zss.fairy.laugh.noupgrade"));
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
		if(this != AddonItems.shieldWood3 || this != AddonItems.shieldSacred3 || this != AddonItems.shieldSteel3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int ticksRemaining) {
		return (player.isUsingItem() ? models.get(1) : models.get(0));
	}

	@Override
	public String[] getVariants() {
		String name = getUnlocalizedName();
		name = ModInfo.ID + ":" + name.substring(9);
		return new String[]{name, name + "_using", name + "_back"};
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers(ItemModelMesher mesher) {
		String[] resources = getVariants();
		models = new ArrayList<ModelResourceLocation>(resources.length);
		for (int i = 0; i < resources.length; ++i) {
			models.add(new ModelResourceLocation(resources[i], "inventory"));
		}
		// Register only the first model as the base resource:
		mesher.register(this, 0, models.get(0));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Collection<ModelResourceLocation> getDefaultResources() {
		String[] variants = getVariants();
		// Swap both regular and 'using' models
		return Lists.newArrayList(new ModelResourceLocation(variants[0], "inventory"), new ModelResourceLocation(variants[1], "inventory"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Class<? extends IBakedModel> getNewModel() {
		return ModelItemShield.class;
	}
}
