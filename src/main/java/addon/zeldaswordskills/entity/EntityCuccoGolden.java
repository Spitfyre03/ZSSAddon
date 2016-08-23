package addon.zeldaswordskills.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityCuccoGolden extends EntityCucco
{
	
    public EntityCuccoGolden(World world)
    {
        super(world);
    }
    
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	
    	this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 2.55, 2.55, 0);
		this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX + 0.5, this.posY, this.posZ + 0.5, 2.55, 2.55, 0);
		this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX - 0.5, this.posY, this.posZ - 0.5, 2.55, 2.55, 0);
		this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX + 0.5, this.posY, this.posZ - 0.5, 2.55, 2.55, 0);
		this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, this.posX - 0.5, this.posY, this.posZ + 0.5, 2.55, 2.55, 0);
    }
    
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
    }
	
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

        for (int k = 0; k < j; ++k)
        {
            this.dropItem(Items.feather, 1);
        }

        if (this.isBurning())
        {
            this.dropItem(Items.cooked_chicken, 1);
        }
        else
        {
            this.dropItem(Items.chicken, 1);
        }
        
        if(this.rand.nextInt(10) <= 8)
        {
        	this.dropItem(Items.emerald, 64);
        }
    }
}
