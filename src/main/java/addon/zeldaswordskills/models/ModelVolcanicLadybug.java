package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVolcanicLadybug extends ModelBase
{
	ModelRenderer head, legs1, body, legs2;
  
	public ModelVolcanicLadybug()
	{
		textureWidth = 32;
		textureHeight = 32;
    
		head = new ModelRenderer(this, 0, 5);
		head.addBox(-0.5F, 0F, -0.3F, 1, 1, 1);
		head.setRotationPoint(0F, 22.75F, 0F);
		head.setTextureSize(32, 32);
		setRotation(head, -0.1745329F, 0F, 0F);
		legs1 = new ModelRenderer(this, 0, 0);
		legs1.addBox(1F, -1F, 0F, 1, 1, 1);
		legs1.setRotationPoint(-0.7F, 23.7F, 0.4F);
		legs1.setTextureSize(32, 32);
		setRotation(legs1, 0F, -0.0872665F, 0.1745329F);
		body = new ModelRenderer(this, 0, 2);
		body.addBox(-1F, -1F, 0F, 2, 1, 2);
		body.setRotationPoint(0F, 23.8F, 0F);
		body.setTextureSize(32, 32);
		setRotation(body, 0F, 0F, 0F);
		legs2 = new ModelRenderer(this, 0, 0);
		legs2.addBox(-1F, -1F, 0F, 1, 1, 1);
		legs2.setRotationPoint(-0.3F, 23.9F, 0.5F);
		legs2.setTextureSize(32, 32);
		setRotation(legs2, 0F, 0.0872665F, -0.1745329F);
	}
  
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		legs1.render(f5);
		body.render(f5);
		legs2.render(f5);
	}
  
	private void setRotation(ModelRenderer model, float x, float y, float z)
 	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
 	}
  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		legs1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		legs2.rotateAngleX = MathHelper.cos(-(f * 0.6662F + 3.1415927F) * 1.4F * f1);
	}
}