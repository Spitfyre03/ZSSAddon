package addon.zeldaswordskills.entity.bugs;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.entity.EntityBug;
import addon.zeldaswordskills.items.AddonItems;

public class EntityBigBeetle extends EntityBug
{

	public EntityBigBeetle(World world)
	{
		super(world);
	}

	public Item getItem()
	{
		return AddonItems.bigBeetle;
	}
	
	public int getStrength()
	{
		return 5;
	}
}
