package addon.zeldaswordskills.renderer;

import org.lwjgl.opengl.GL11;

import addon.zeldaswordskills.blocks.TileEntitySwitch;
import addon.zeldaswordskills.models.ModelSwitch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import zeldaswordskills.block.ZSSBlocks;

public class TileEntitySwitchRenderer extends TileEntitySpecialRenderer
{
	private final ModelSwitch model;
	private final ModelSwitch.ModelSwitchBase baseModel;
	private final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	private RenderManager renderManager;
	
	public TileEntitySwitchRenderer()
	{ 
		this.model = new ModelSwitch();
		this.baseModel = model.new ModelSwitchBase();
	}
	
	public void renderTileEntityAt(TileEntitySwitch te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		float rotation = 0.0F;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	    if(te.getSide() == 0) rotation = 90F;
	    if(te.getSide() == 1) rotation = 180F;
	    if(te.getSide() == 2) rotation = 270F;
	    GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
	    if(te.isToggled())
	    {
	    	GL11.glScalef(1.0F, 0.1F, 1.0F);
	    	GL11.glTranslatef(0.0F, 13F, 0.0F);
	    }
	    else GL11.glScalef(1.0F, 1.0F, 1.0F);
	    ResourceLocation textures = (new ResourceLocation("zssaddon:textures/tiles/switch_normal.png")); 
		if(te.getType() == 1) textures = (new ResourceLocation("zssaddon:textures/tiles/switch_blue.png")); 
		if(te.getType() == 2) textures = (new ResourceLocation("zssaddon:textures/tiles/switch_rusted.png")); 
		this.bindTexture(textures);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	    GL11.glPopMatrix();
	    {
	    	GlStateManager.pushMatrix();
	    	if(te.isToggled()) GlStateManager.translate(x + 0.5D, y + 0.52D, z + 0.5D);
	    	else GlStateManager.translate(x + 0.5D, y + 0.70D, z + 0.5D);
	    	GlStateManager.enableRescaleNormal();
	    	GlStateManager.rotate(180F, 0.0F, 1.0F, 0.0F);
	    	GlStateManager.scale(2.0F, 2.0F, 2.0F);
	    	if(!te.hasJar()) GlStateManager.scale(0.0F, 0.0F, 0.0F);
	    	renderItem.renderItemModel(new ItemStack(ZSSBlocks.ceramicJar));
	    	GlStateManager.disableRescaleNormal();
	    	GlStateManager.popMatrix();
		
	    	if(te.getJarItem() != null)
	    	{
	    		GlStateManager.pushMatrix();
	    		GlStateManager.translate(x + 0.45D, y + 0.2D, z + 0.45D);
	    		GlStateManager.enableRescaleNormal();
	    		GlStateManager.scale(0.425F, 0.425F, 0.425F);
	    		GlStateManager.rotate(45F, 0.0F, 1.0F, 0.0F);
	    		GlStateManager.rotate(30F, 1.0F, 0.0F, 0.0F);
	    		GlStateManager.rotate((te.getJarItem().getItem().isFull3D() ? 225.0F : 45.0F), 0.0F, 0.0F, 1.0F);
	    		renderItem.renderItemModel(te.getJarItem());
	    		GlStateManager.disableRescaleNormal();
	    		GlStateManager.popMatrix();
	    	}
	    }

	    renderBottomAt(x, y, z, textures);
	}
	
	public void renderBottomAt(double x, double y, double z, ResourceLocation textures)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	    this.bindTexture(textures);
		this.baseModel.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	    GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		renderTileEntityAt((TileEntitySwitch) te, x, y, z, partialTicks, destroyStage);
	}
}