package addon.zeldaswordskills.items;

import addon.zeldaswordskills.ZSSAddon;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zeldaswordskills.item.BaseModItem;
import zeldaswordskills.util.PlayerUtils;

public class ItemTeleporter extends BaseModItem
{	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		{
			PlayerUtils.sendTranslatedChat(player, "Work in progress.");
		}
		
        return stack;
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
