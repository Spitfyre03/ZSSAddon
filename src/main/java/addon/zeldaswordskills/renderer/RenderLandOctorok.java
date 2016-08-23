package addon.zeldaswordskills.renderer;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.entity.EntityLandOctorok;
import addon.zeldaswordskills.models.ModelLandOctorok;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLandOctorok extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/octorok_red.png");
	private static final ResourceLocation texture2 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/octorok_blue.png");

	public RenderLandOctorok(RenderManager renderManager)
	{
		super(renderManager, new ModelLandOctorok(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return (((EntityLandOctorok) entity).getType() == 0 ? texture1 : texture2);
	}
}