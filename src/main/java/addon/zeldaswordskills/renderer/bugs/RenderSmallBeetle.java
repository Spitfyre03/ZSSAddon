package addon.zeldaswordskills.renderer.bugs;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.models.ModelSmallBeetle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSmallBeetle extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/bugs/small_beetle.png");
	
	public RenderSmallBeetle(RenderManager renderManager)
	{
		super(renderManager, new ModelSmallBeetle(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture1;
	}
}