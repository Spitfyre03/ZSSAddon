package addon.zeldaswordskills.entity;

import java.util.List;

import addon.zeldaswordskills.AddonAchievements;
import addon.zeldaswordskills.AddonConfig;
import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCucco extends EntityChicken
{
	
    public EntityCucco(World world)
    {
        super(world);
        this.setSize(1.0F, 0.4F);
    }
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    	
        if(this.ridingEntity instanceof EntityPlayer)
        {
        	EntityPlayer player = (EntityPlayer) this.ridingEntity;
        	
        	Item item;
        	
			if(player.getCurrentEquippedItem() != null)
			{
				item = player.getCurrentEquippedItem().getItem();
				
				if(item != AddonItems.cuccoGlove)
				{
					this.mountEntity((Entity)null);
				}
			}
			else
			{
				this.mountEntity((Entity)null);
			}
			
			this.setPosition(this.posX, this.posY - 2, this.posX);
		}
    }
    
	public boolean attackEntityFrom(DamageSource entity, float f1)
    {
		super.attackEntityFrom(entity, f1);
		

		if(AddonConfig.doesAngryCuccosSpawn() && !(this instanceof EntityCuccoGolden))
		{
		if (entity.getEntity() instanceof EntityPlayer)
        {
        	this.setBeenAttacked();
        	
        	EntityPlayer player = (EntityPlayer) entity.getEntity();
    		
   			if(this.getHealth() <= 20.0D)
   			{
   				this.worldObj.playSoundAtEntity(this, "zeldaswordskills:cuccoAngry", 1.0F, 1.0F);
   				this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY + 0.5, this.posZ, 0, 0, 0);
   	   			this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, 0, 0.2, 0);
   	   			this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX - 0.5, this.posY + 0.5, this.posZ - 0.5, 0, 0.2, 0);
   	   			this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX + 0.5, this.posY + 0.5, this.posZ - 0.5, 0, 0.2, 0);
   	   			this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX - 0.5, this.posY + 0.5, this.posZ + 0.5, 0, 0.2, 0);
   	            	
   				
   				if(!this.worldObj.isRemote)
   				{
   					{
   						Entity angryCucco;angryCucco = new EntityCuccoAngry(this.worldObj);
   						Entity angryCucco2;angryCucco2 = new EntityCuccoAngry(this.worldObj);
   						Entity angryCucco3;angryCucco3 = new EntityCuccoAngry(this.worldObj);
   						Entity angryCucco4;angryCucco4 = new EntityCuccoAngry(this.worldObj);
   						Entity angryCucco5;angryCucco5 = new EntityCuccoAngry(this.worldObj);

   		   				player.addStat(AddonAchievements.cuccoChase, 1);
   		   				this.setDead();
   		   				
   						angryCucco.setPosition(this.posX, this.posY, this.posZ);
   						worldObj.spawnEntityInWorld(angryCucco);
   						angryCucco2.setPosition(this.posX, this.posY + 5, this.posZ - 2);
   						worldObj.spawnEntityInWorld(angryCucco2);
   						angryCucco3.setPosition(this.posX - 2, this.posY + 5, this.posZ);
   						worldObj.spawnEntityInWorld(angryCucco3);
   						angryCucco4.setPosition(this.posX + 2, this.posY + 5, this.posZ);
   						worldObj.spawnEntityInWorld(angryCucco4);
   						angryCucco5.setPosition(this.posX, this.posY + 5, this.posZ + 2);
   						worldObj.spawnEntityInWorld(angryCucco5);

   			            {
   			                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getBoundingBox().expand(32.0D, 32.0D, 32.0D));

   			                for (int i = 0; i < list.size(); ++i)
   			                {
   			                    Entity entity1 = (Entity)list.get(i);

   			                    if (entity1 instanceof EntityCucco)
   			                    {
   			                        EntityCucco cucco = (EntityCucco)entity1;
   			                        
   			                        Entity angryCuccos;angryCuccos = new EntityCuccoAngry(this.worldObj);
   			                        angryCuccos.setPosition(cucco.posX, cucco.posY, cucco.posZ);
   			                        worldObj.spawnEntityInWorld(angryCuccos);
   			                        
   			                        cucco.setDead();
   			                    }
   			                }
   			            }
   					}
   				}
   			}
   			}
        }
		return false;
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
	
	protected String getLivingSound()
    {
        return ZSSAddon.ModID + ":cuccoLiving";
    }
	
    protected String getHurtSound()
    {
        return ZSSAddon.ModID + ":cuccoHeld";
    }

    protected String getDeathSound()
    {
        return ZSSAddon.ModID + ":cuccoAngry";
    }
	
}
