package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBigBeetle extends ModelBase
{
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer foot4;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer pincer1;
    ModelRenderer pincer2;
    ModelRenderer wing1;
    ModelRenderer wing2;
  
  public ModelBigBeetle()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      foot1 = new ModelRenderer(this, 34, 0);
      foot1.addBox(-1F, 0F, -1.5F, 2, 1, 3);
      foot1.setRotationPoint(3F, 23F, -3F);
      foot1.setTextureSize(64, 32);
      foot1.mirror = true;
      setRotation(foot1, 0F, 0F, 0F);
      foot2 = new ModelRenderer(this, 34, 0);
      foot2.addBox(-1F, 0F, -1.5F, 2, 1, 3);
      foot2.setRotationPoint(3F, 23F, 3F);
      foot2.setTextureSize(64, 32);
      foot2.mirror = true;
      setRotation(foot2, 0F, 0F, 0F);
      foot3 = new ModelRenderer(this, 34, 0);
      foot3.addBox(-1F, 0F, -1.5F, 2, 1, 3);
      foot3.setRotationPoint(-3F, 23F, 3F);
      foot3.setTextureSize(64, 32);
      foot3.mirror = true;
      setRotation(foot3, 0F, 0F, 0F);
      foot4 = new ModelRenderer(this, 34, 0);
      foot4.addBox(-1F, 0F, -1.5F, 2, 1, 3);
      foot4.setRotationPoint(-3F, 23F, -3F);
      foot4.setTextureSize(64, 32);
      foot4.mirror = true;
      setRotation(foot4, 0F, 0F, 0F);
      body1 = new ModelRenderer(this, 0, 0);
      body1.addBox(-3.5F, 0F, -5F, 7, 2, 10);
      body1.setRotationPoint(0F, 21.5F, 0F);
      body1.setTextureSize(64, 32);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      body2 = new ModelRenderer(this, 0, 12);
      body2.addBox(-3F, 0F, -4.5F, 6, 1, 9);
      body2.setRotationPoint(0F, 21F, 0F);
      body2.setTextureSize(64, 32);
      body2.mirror = true;
      setRotation(body2, 0F, 0F, 0F);
      pincer1 = new ModelRenderer(this, 34, 4);
      pincer1.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 5);
      pincer1.setRotationPoint(1.5F, 21F, -5F);
      pincer1.setTextureSize(64, 32);
      pincer1.mirror = true;
      setRotation(pincer1, -0.6108652F, -0.2617994F, 0F);
      pincer2 = new ModelRenderer(this, 34, 4);
      pincer2.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 5);
      pincer2.setRotationPoint(-1.5F, 21F, -5F);
      pincer2.setTextureSize(64, 32);
      pincer2.mirror = true;
      setRotation(pincer2, -0.6108652F, 0.2617994F, 0F);
      wing1 = new ModelRenderer(this, 0, 0);
      wing1.addBox(-2F, -0.5F, -0.5F, 4, 6, 1);
      wing1.setRotationPoint(1.5F, 21.3F, -0.5F);
      wing1.setTextureSize(64, 32);
      wing1.mirror = true;
      setRotation(wing1, 1.745329F, 0.5235988F, 0F);
      wing2 = new ModelRenderer(this, 0, 0);
      wing2.addBox(-2F, -0.5F, -0.5F, 4, 6, 1);
      wing2.setRotationPoint(-1.5F, 21.3F, -0.5F);
      wing2.setTextureSize(64, 32);
      wing2.mirror = true;
      setRotation(wing2, 1.745329F, -0.5235988F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    foot1.render(f5);
    foot2.render(f5);
    foot3.render(f5);
    foot4.render(f5);
    body1.render(f5);
    body2.render(f5);
    pincer1.render(f5);
    pincer2.render(f5);
    wing2.render(f5);
    wing1.render(f5);
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
	foot3.rotateAngleX = MathHelper.cos(-(f * 0.6662F + 3.1415927F) * 1.4F * f1);
	foot2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	foot4.rotateAngleX = MathHelper.cos(-(f * 0.6662F + 3.1415927F) * 1.4F * f1);
  }

}
