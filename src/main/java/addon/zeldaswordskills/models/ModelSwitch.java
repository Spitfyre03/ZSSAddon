package addon.zeldaswordskills.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSwitch extends ModelBase
{
	ModelRenderer Switch1;
    ModelRenderer Switch2;
  
    public class ModelSwitchBase extends ModelBase
	{
		ModelRenderer Base;
	  
	    public ModelSwitchBase()
	    {
	    	textureWidth = 128;
	    	textureHeight = 64;
	    	
	    	Base = new ModelRenderer(this, 0, 0);
	    	Base.addBox(-8F, 0F, -8F, 16, 1, 16);
	    	Base.setRotationPoint(0F, 23F, 0F);
	    	Base.setTextureSize(128, 64);
	    	Base.mirror = true;
	    	setRotation(Base, 0F, 0F, 0F);
	    }
	  
	    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	    {
	    	super.render(entity, f, f1, f2, f3, f4, f5);
	    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    	Base.render(f5);
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
	    }
	}
    
    public ModelSwitch()
    {
    	textureWidth = 128;
    	textureHeight = 64;
    	
    	Switch1 = new ModelRenderer(this, 0, 17);
    	Switch1.addBox(-7F, 0F, -7F, 14, 2, 14);
    	Switch1.setRotationPoint(0F, 21F, 0F);
    	Switch1.setTextureSize(128, 64);
    	Switch1.mirror = true;
    	setRotation(Switch1, 0F, 0F, 0F);
    	Switch2 = new ModelRenderer(this, 0, 33);
    	Switch2.addBox(-6.5F, 0F, -6.5F, 13, 1, 13);
    	Switch2.setRotationPoint(0F, 20F, 0F);
    	Switch2.setTextureSize(128, 64);
    	Switch2.mirror = true;
    	setRotation(Switch2, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	Switch1.render(f5);
    	Switch2.render(f5);
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
    }
}
