package addon.zeldaswordskills.entity.bugs;

import addon.zeldaswordskills.entity.EntityBug;
import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityVolcanicLadybug extends EntityBug
{

	public EntityVolcanicLadybug(World world)
	{
		super(world);
	}

	public Item getItem()
	{
		return AddonItems.volcanicLadybug;
	}
	
	public int getStrength()
	{
		return 3;
	}
}
