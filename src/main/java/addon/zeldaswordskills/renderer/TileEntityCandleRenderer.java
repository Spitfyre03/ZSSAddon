package addon.zeldaswordskills.renderer;

import addon.zeldaswordskills.blocks.TileEntityCandle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCandleRenderer extends TileEntitySpecialRenderer
{
	private final RenderItem renderItem;
	
	public TileEntityCandleRenderer()
	{
		renderItem = Minecraft.getMinecraft().getRenderItem();
	}
	
	public void renderTileEntityAt(TileEntityCandle te, double x, double y, double z)
	{
		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		renderItem.renderItemModel(new ItemStack(Blocks.hardened_clay));
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		renderTileEntityAt((TileEntityCandle) te, x, y, z);
	}
}