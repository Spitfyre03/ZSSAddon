package addon.zeldaswordskills.renderer.bugs;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.models.ModelBigBeetle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBigBeetle extends RenderLiving
{
	private static final ResourceLocation texture1 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/bugs/big_beetle.png");
	
	public RenderBigBeetle(RenderManager renderManager)
	{
		super(renderManager, new ModelBigBeetle(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture1;
	}
}