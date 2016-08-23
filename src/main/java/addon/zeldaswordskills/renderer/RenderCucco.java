package addon.zeldaswordskills.renderer;

import org.lwjgl.opengl.GL11;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.entity.EntityCucco;
import addon.zeldaswordskills.entity.EntityCuccoAngry;
import addon.zeldaswordskills.entity.EntityCuccoGolden;
import addon.zeldaswordskills.models.ModelCucco;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCucco extends RenderLiving
{	
	private static final ResourceLocation texture1 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/cucco.png");
	private static final ResourceLocation texture2 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/cucco_angry.png");
	private static final ResourceLocation texture3 = new ResourceLocation(ZSSAddon.ModID + ":" + "textures/entity/cucco_golden.png");

	public RenderCucco(RenderManager renderManager)
	{
		super(renderManager, new ModelCucco(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		ResourceLocation texture = texture1;
		
		if(entity instanceof EntityCuccoAngry) texture = texture2;
		if(entity instanceof EntityCuccoGolden) texture = texture3;
		
		return texture;
	}
	
	protected float handleRotationFloat(EntityCucco p_77044_1_, float p_77044_2_)
    {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.wingRotation - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }
	
	protected float handleRotationFloat(EntityCuccoAngry p_77044_1_, float p_77044_2_)
    {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }
	
	@Override
	public void doRender(EntityLiving entity, double dx, double dy, double dz, float yaw, float partialTick)
	{
		GL11.glPushMatrix();
		if(entity instanceof EntityCucco)
		{
			this.renderCucco((EntityCucco)entity, dx, dy, dz, yaw, partialTick);
		}
		super.doRender(entity, dx, dy, dz, yaw, partialTick);
		GL11.glPopMatrix();
	}
	
	public void renderCucco(EntityCucco entity, double dx, double dy, double dz, float yaw, float partialTick)
	{
		if(entity.isRiding())
		{
			GL11.glTranslatef(0, -1.1F, 0);
		}
	}
	
	protected float handleRotationFloat(EntityCuccoGolden p_77044_1_, float p_77044_2_)
    {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.wingRotation - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }
	
	protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_)
    {
		if(p_77044_1_ instanceof EntityCuccoAngry)
		{
			return this.handleRotationFloat((EntityCuccoAngry)p_77044_1_, p_77044_2_);
		}
		else if(p_77044_1_ instanceof EntityCuccoGolden)
		{
			return this.handleRotationFloat((EntityCuccoGolden)p_77044_1_, p_77044_2_);
		}
		else
		{
			return this.handleRotationFloat((EntityCucco)p_77044_1_, p_77044_2_);
		}
	}
}