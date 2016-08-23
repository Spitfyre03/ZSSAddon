package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLandOctorok extends ModelBase
{
    ModelRenderer body;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer foot4;
    ModelRenderer blaster;
    ModelRenderer tube;
  
    public ModelLandOctorok()
    {
    	textureWidth = 64;
    	textureHeight = 32;
    	
    	body = new ModelRenderer(this, 0, 0);
    	body.addBox(-4F, 0F, -4F, 8, 6, 8);
    	body.setRotationPoint(0F, 17F, 0F);
    	body.setTextureSize(64, 32);
    	setRotation(body, 0F, 0F, 0F);
    	foot1 = new ModelRenderer(this, 0, 14);
    	foot1.addBox(-1F, -1F, -1F, 2, 2, 2);
    	foot1.setRotationPoint(-4F, 23F, 4F);
    	foot1.setTextureSize(64, 32);
    	setRotation(foot1, 0F, 0F, 0F);
    	foot2 = new ModelRenderer(this, 0, 14);
    	foot2.addBox(-1F, -1F, -1F, 2, 2, 2);
    	foot2.setRotationPoint(4F, 23F, -4F);
    	foot2.setTextureSize(64, 32);
    	setRotation(foot2, 0F, 0F, 0F);
    	foot3 = new ModelRenderer(this, 0, 14);
    	foot3.addBox(-1F, -1F, -1F, 2, 2, 2);
    	foot3.setRotationPoint(-4F, 23F, -4F);
    	foot3.setTextureSize(64, 32);
    	setRotation(foot3, 0F, 0F, 0F);
    	foot4 = new ModelRenderer(this, 0, 14);
    	foot4.addBox(-1F, -1F, -1F, 2, 2, 2);
    	foot4.setRotationPoint(4F, 23F, 4F);
    	foot4.setTextureSize(64, 32);
    	setRotation(foot4, 0F, 0F, 0F);
    	blaster = new ModelRenderer(this, 32, 0);
    	blaster.addBox(-2F, -2F, -1.5F, 4, 4, 1);
    	blaster.setRotationPoint(0F, 21F, -5F);
    	blaster.setTextureSize(64, 32);
    	setRotation(blaster, 0F, 0F, 0F);
    	tube = new ModelRenderer(this, 18, 8);
    	tube.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
    	tube.setRotationPoint(0F, 21F, -4F);
    	tube.setTextureSize(64, 32);
    	setRotation(tube, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    	body.render(f5);
    	foot1.render(f5);
    	foot2.render(f5);
    	foot3.render(f5);
    	foot4.render(f5);
    	blaster.render(f5);
    	tube.render(f5);
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
    	foot1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	foot2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    	foot3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	foot4.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    	
    }
}
