package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmallBeetle extends ModelBase
{
  //fields
    ModelRenderer BackLeg2;
    ModelRenderer Body;
    ModelRenderer BackLeg1;
    ModelRenderer FrontLeg2;
    ModelRenderer FrontLeg1;
    ModelRenderer Antenna1;
    ModelRenderer Antenna2;
  
  public ModelSmallBeetle()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      BackLeg2 = new ModelRenderer(this, 0, 5);
      BackLeg2.addBox(0F, -0.5F, -1.5F, 1, 1, 1);
      BackLeg2.setRotationPoint(0.5F, 23.5F, 1.5F);
      BackLeg2.setTextureSize(64, 32);
      BackLeg2.mirror = true;
      setRotation(BackLeg2, 0F, -0.6981317F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-1F, -0.5F, -2.2F, 2, 1, 4);
      Body.setRotationPoint(0F, 23F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      BackLeg1 = new ModelRenderer(this, 0, 5);
      BackLeg1.addBox(-1F, -0.5F, -1.5F, 1, 1, 1);
      BackLeg1.setRotationPoint(-0.5F, 23.5F, 1.5F);
      BackLeg1.setTextureSize(64, 32);
      BackLeg1.mirror = true;
      setRotation(BackLeg1, 0F, 0.6981317F, 0F);
      FrontLeg2 = new ModelRenderer(this, 0, 5);
      FrontLeg2.addBox(0F, -0.5F, -1.5F, 1, 1, 1);
      FrontLeg2.setRotationPoint(0.5F, 23.5F, -1F);
      FrontLeg2.setTextureSize(64, 32);
      FrontLeg2.mirror = true;
      setRotation(FrontLeg2, 0F, -0.6981317F, 0F);
      FrontLeg1 = new ModelRenderer(this, 0, 5);
      FrontLeg1.addBox(-1F, -0.5F, -1.5F, 1, 1, 1);
      FrontLeg1.setRotationPoint(-0.5F, 23.5F, -1F);
      FrontLeg1.setTextureSize(64, 32);
      FrontLeg1.mirror = true;
      setRotation(FrontLeg1, 0F, 0.6981317F, 0F);
      Antenna1 = new ModelRenderer(this, 12, 0);
      Antenna1.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3);
      Antenna1.setRotationPoint(0.7F, 22.8F, -1.4F);
      Antenna1.setTextureSize(64, 32);
      Antenna1.mirror = true;
      setRotation(Antenna1, -0.6981317F, -2.268928F, 0F);
      Antenna2 = new ModelRenderer(this, 12, 0);
      Antenna2.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3);
      Antenna2.setRotationPoint(-0.7F, 22.8F, -1.4F);
      Antenna2.setTextureSize(64, 32);
      Antenna2.mirror = true;
      setRotation(Antenna2, -0.6981317F, 2.268928F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    BackLeg2.render(f5);
    Body.render(f5);
    BackLeg1.render(f5);
    FrontLeg2.render(f5);
    FrontLeg1.render(f5);
    Antenna1.render(f5);
    Antenna2.render(f5);
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
	FrontLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	FrontLeg2.rotateAngleX = MathHelper.cos(-(f * 0.6662F + 3.1415927F) * 1.4F * f1);
	BackLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	BackLeg2.rotateAngleX = MathHelper.cos(-(f * 0.6662F + 3.1415927F) * 1.4F * f1);
  }

}
