package addon.zeldaswordskills.items;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.block.tileentity.TileEntityDungeonCore;
import zeldaswordskills.item.ItemZeldaSword;
import zeldaswordskills.ref.Sounds;
import zeldaswordskills.util.PlayerUtils;
import zeldaswordskills.util.WorldUtils;

public class ItemZelda8BitSword extends ItemZeldaSword
{
	public ItemZelda8BitSword(ToolMaterial material, float bonusDamage)
	{
		super(material, bonusDamage);
		this.setCreativeTab(ZSSAddon.combatTab);
	}
	
	/**private int getDamageFactor(EntityPlayer player) {
		return 30 + (3 * 10);
	}
	
	private float getDamage(EntityPlayer player) {
		return (float)((double)(getDamageFactor(player)) * 0.01D * player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
	}*/
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		//I'll fuck around with this later...
		/**if (!world.isRemote)
		{
			if (!player.capabilities.isCreativeMode)
			{
				player.addExhaustion(getExhaustion());
			}
			WorldUtils.playSoundAtEntity(player, Sounds.WHOOSH, 0.4F, 0.5F);
			Vec3 vec3 = player.getLookVec();
			EntitySwordBeam beam = new EntitySwordBeam(world, player).setLevel(3);
			beam.setDamage(getDamage(player));
			beam.setMasterSword(PlayerUtils.isHoldingMasterSword(player));
			beam.setPosition(beam.posX + vec3.getPos().getX() * 2, beam.posY + vec3.getPos().getY() * 2, beam.posZ + vec3.getPos().getZ() * 2);
			world.spawnEntityInWorld(beam);
		}*/
		super.onItemRightClick(stack, world, player);
		
        return stack;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		return false;
	}
	
	@Override
	public void handleFairyUpgrade(EntityItem item, EntityPlayer player, TileEntityDungeonCore core)
	{
		ItemStack stack = item.getEntityItem();
		
		if (core.consumeRupees(128))
		{
			item.setDead();
			
			if(stack.getItem() == AddonItems.eightBitSwordWooden)
			{	
				WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.eightBitSwordWhite), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			}
			else
			{
				WorldUtils.spawnItemWithRandom(core.getWorld(), new ItemStack(AddonItems.eightBitSwordMagical), core.getPos().getX(), core.getPos().getY() + 2, core.getPos().getZ());
			}

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
		return this == AddonItems.eightBitSwordWooden || this == AddonItems.eightBitSwordWhite;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers(ItemModelMesher mesher) {
		String[] variants = getVariants();
		if (variants == null || variants.length < 1) {
			String name = getUnlocalizedName();
			variants = new String[]{ZSSAddon.ModID + ":" + name.substring(name.lastIndexOf(".") + 1)};
		}
		for (int i = 0; i < variants.length; ++i) {
			mesher.register(this, i, new ModelResourceLocation(variants[i], "inventory"));
		}
	}
}
