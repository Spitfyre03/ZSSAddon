package addon.zeldaswordskills.entity.bugs;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import addon.zeldaswordskills.entity.EntityBug;
import addon.zeldaswordskills.items.AddonItems;

public class EntitySmallBeetle extends EntityBug
{

	public EntitySmallBeetle(World world)
	{
		super(world);
	}

	public Item getItem()
	{
		return AddonItems.smallBeetle;
	}
	
	public int getStrength()
	{
		return 3;
	}
}
