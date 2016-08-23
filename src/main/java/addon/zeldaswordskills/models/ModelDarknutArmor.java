package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDarknutArmor extends ModelBiped
{
	ModelRenderer LeftBrace;
    ModelRenderer RightPiece;
    ModelRenderer LeftShield;
    ModelRenderer LeftFace;
    ModelRenderer BackShield;
    ModelRenderer LeftPiece;
    ModelRenderer Nose;
    ModelRenderer RightFace;
    ModelRenderer RightShield;
    ModelRenderer TopShield;
    ModelRenderer TopFaceHelmet;
    ModelRenderer LeftHornHolder;
    ModelRenderer RightHornHolder;
    ModelRenderer LeftHorn;
    ModelRenderer RightHorn;
    ModelRenderer ArmorTop;
    ModelRenderer ArmorBottom;
    ModelRenderer RightBrace;
  
    public ModelDarknutArmor(float f)
    {
    	super(f, 0, 64, 64);
    	
    	LeftBrace = new ModelRenderer(this, 0, 58);
    	LeftBrace.addBox(-1F, -3F, -2.5F, 6, 1, 5);
    	LeftBrace.setRotationPoint(0F, 0F, 0F);
    	LeftBrace.setTextureSize(64, 64);
    	setRotation(LeftBrace, 0F, 0F, -0.0349066F);
    	RightPiece = new ModelRenderer(this, 40, 36);
      	RightPiece.addBox(3.5F, -6.5F, -4.6F, 1, 2, 1);
      	RightPiece.setRotationPoint(0F, 0F, 0F);
      	RightPiece.setTextureSize(64, 64);
      	setRotation(RightPiece, 0F, 0F, 0F);
      	LeftShield = new ModelRenderer(this, 44, 44);
      	LeftShield.addBox(-4.5F, -8.5F, -3.6F, 1, 9, 8);
      	LeftShield.setRotationPoint(0F, 0F, 0F);
      	LeftShield.setTextureSize(64, 64);
      	setRotation(LeftShield, 0F, 0F, 0F);
      	LeftFace = new ModelRenderer(this, 32, 36);
      	LeftFace.addBox(-4.5F, -4.5F, -4.6F, 3, 5, 1);
      	LeftFace.setRotationPoint(0F, 0F, 0F);
      	LeftFace.setTextureSize(64, 64);
      	setRotation(LeftFace, 0F, 0F, 0F);
      	LeftFace.mirror = true;
      	BackShield = new ModelRenderer(this, 28, 46);
      	BackShield.addBox(-3.5F, -8.5F, 3.4F, 7, 9, 1);
      	BackShield.setRotationPoint(0F, 0F, 0F);
      	BackShield.setTextureSize(64, 64);
      	setRotation(BackShield, 0F, 0F, 0F);
      	LeftPiece = new ModelRenderer(this, 40, 36);
      	LeftPiece.addBox(-4.5F, -6.5F, -4.6F, 1, 2, 1);
      	LeftPiece.setRotationPoint(0F, 0F, 0F);
      	LeftPiece.setTextureSize(64, 64);
      	LeftPiece.mirror = true;
      	setRotation(LeftPiece, 0F, 0F, 0F);
      	Nose = new ModelRenderer(this, 56, 32);
      	Nose.addBox(-1F, -7F, -5.4F, 2, 4, 1);
      	Nose.setRotationPoint(0F, 0F, 0F);
      	Nose.setTextureSize(64, 64);
      	setRotation(Nose, -0.0872665F, 0F, 0F);
      	RightFace = new ModelRenderer(this, 32, 36);
      	RightFace.addBox(1.5F, -4.5F, -4.6F, 3, 5, 1);
      	RightFace.setRotationPoint(0F, 0F, 0F);
      	RightFace.setTextureSize(64, 64);
      	setRotation(RightFace, 0F, 0F, 0F);
      	RightShield = new ModelRenderer(this, 44, 44);
      	RightShield.addBox(3.5F, -8.5F, -3.6F, 1, 9, 8);
      	RightShield.setRotationPoint(0F, 0F, 0F);
      	RightShield.setTextureSize(64, 64);
      	setRotation(RightShield, 0F, 0F, 0F);
      	TopShield = new ModelRenderer(this, 22, 56);
      	TopShield.addBox(-3.5F, -8.5F, -3.6F, 7, 1, 7);
      	TopShield.setRotationPoint(0F, 0F, 0F);
      	TopShield.setTextureSize(64, 64);
      	setRotation(TopShield, 0F, 0F, 0F);
      	TopFaceHelmet = new ModelRenderer(this, 40, 40);
      	TopFaceHelmet.addBox(-4.5F, -8.5F, -4.6F, 9, 2, 1);
      	TopFaceHelmet.setRotationPoint(0F, 0F, 0F);
      	TopFaceHelmet.setTextureSize(64, 64);
      	setRotation(TopFaceHelmet, 0F, 0F, 0F);
      	LeftHornHolder = new ModelRenderer(this, 44, 32);
      	LeftHornHolder.addBox(-6F, -6F, -1.5F, 3, 3, 3);
      	LeftHornHolder.setRotationPoint(0F, 0F, 0F);
      	LeftHornHolder.setTextureSize(64, 64);
      	setRotation(LeftHornHolder, 0F, 0F, 0F);
      	RightHornHolder = new ModelRenderer(this, 44, 32);
      	RightHornHolder.addBox(3F, -6F, -1.5F, 3, 3, 3);
      	RightHornHolder.setRotationPoint(0F, 0F, 0F);
      	RightHornHolder.setTextureSize(64, 64);
      	setRotation(RightHornHolder, 0F, 0F, 0F);
      	LeftHorn = new ModelRenderer(this, 32, 32);
      	LeftHorn.addBox(-10F, -3.5F, -1F, 4, 2, 2);
      	LeftHorn.setRotationPoint(0F, 0F, 0F);
      	LeftHorn.setTextureSize(64, 64);
      	setRotation(LeftHorn, 0F, 0F, 0.3271794F);
      	RightHorn = new ModelRenderer(this, 32, 32);
      	RightHorn.addBox(6F, -3.5F, -1F, 4, 2, 2);
      	RightHorn.setRotationPoint(0F, 0F, 0F);
      	RightHorn.setTextureSize(64, 64);
      	setRotation(RightHorn, 0F, 0F, -0.3271794F);
      	ArmorTop = new ModelRenderer(this, 0, 32);
      	ArmorTop.addBox(-5F, -0.2F, -3F, 10, 7, 6);
      	ArmorTop.setRotationPoint(0F, 0F, 0F);
      	ArmorTop.setTextureSize(64, 64);
      	setRotation(ArmorTop, 0F, 0F, 0F);
      	ArmorBottom = new ModelRenderer(this, 0, 46);
      	ArmorBottom.addBox(-4.5F, 6.8F, -2.5F, 9, 6, 5);
      	ArmorBottom.setRotationPoint(0F, 0F, 0F);
      	ArmorBottom.setTextureSize(64, 64);
      	setRotation(ArmorBottom, 0F, 0F, 0F);
      	RightBrace = new ModelRenderer(this, 0, 58);
      	RightBrace.addBox(-5F, -3F, -2.5F, 6, 1, 5);
      	RightBrace.setRotationPoint(0F, 0F, 0F);
      	RightBrace.setTextureSize(64, 64);
      	setRotation(RightBrace, 0F, 0F, 0.0349066F);
      	
      	this.bipedRightArm.addChild(RightBrace);
      	this.bipedLeftArm.addChild(LeftBrace);
      	this.bipedHead.addChild(RightPiece);
      	this.bipedHead.addChild(LeftShield);
      	this.bipedHead.addChild(LeftFace);
      	this.bipedHead.addChild(BackShield);
      	this.bipedHead.addChild(LeftPiece);
     	this.bipedHead.addChild(Nose);
     	this.bipedHead.addChild(RightFace);
     	this.bipedHead.addChild(RightShield);
     	this.bipedHead.addChild(TopShield);
     	this.bipedHead.addChild(TopFaceHelmet);
     	this.bipedHead.addChild(LeftHornHolder);
     	this.bipedHead.addChild(RightHornHolder);
     	this.bipedHead.addChild(LeftHorn);
     	this.bipedHead.addChild(RightHorn);
     	this.bipedBody.addChild(ArmorTop);
     	this.bipedBody.addChild(ArmorBottom);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
	  model.rotateAngleX = x;
	  model.rotateAngleY = y;
	  model.rotateAngleZ = z;
  }
}
