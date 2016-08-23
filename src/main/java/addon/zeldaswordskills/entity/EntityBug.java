package addon.zeldaswordskills.entity;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zeldaswordskills.api.block.IWhipBlock.WhipType;
import zeldaswordskills.api.entity.BombType;
import zeldaswordskills.api.entity.IEntityLootable;
import zeldaswordskills.entity.IEntityVariant;
import zeldaswordskills.entity.mobs.EntityOctorok;
import zeldaswordskills.entity.projectile.EntityBomb;
import zeldaswordskills.entity.projectile.EntityThrowingRock;
import zeldaswordskills.item.ZSSItems;
import zeldaswordskills.ref.Config;

public class EntityBug extends EntityCreature
{
	private EntityAITempt aiTempt;
	  
	public EntityBug(World world)
	{
		super(world);
        this.setSize(1.0F, 0.1F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiTempt = new EntityAITempt(this, 0.6D, Item.getItemFromBlock(Blocks.air), true));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, new Predicate()
        {
            private static final String __OBFID = "CL_00002243";
            public boolean func_179874_a(Entity p_179874_1_)
            {
                return p_179874_1_ instanceof EntityPlayer;
            }
            public boolean apply(Object p_apply_1_)
            {
                return this.func_179874_a((Entity)p_apply_1_);
            }
        }, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	public Item getItem()
	{
		return null;
	}
	
	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}	

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

	/**@Override
	protected void dropFewItems(boolean par1, int par2)
    {
		switch(par2)
		{
			case 1:
				entityDropItem(new ItemStack(Items.slime_ball,	1), 0.0F);
				break;
			default:
			{
				entityDropItem(new ItemStack(rand.nextInt(3) == 1 ? Items.emerald : ZSSItems.smallHeart), 0.0F);
			}
		}
	}*/

	public int getStrength()
	{
		return 1;
	}
}