package addon.zeldaswordskills;

import java.lang.reflect.Field;
import java.util.Map;

import com.google.common.collect.Maps;

import addon.zeldaswordskills.blocks.TileEntitySwitch;
import addon.zeldaswordskills.entity.EntityCucco;
import addon.zeldaswordskills.entity.EntityCuccoAngry;
import addon.zeldaswordskills.entity.EntityCuccoGolden;
import addon.zeldaswordskills.entity.EntityGoldOctorok;
import addon.zeldaswordskills.entity.EntityLandOctorok;
import addon.zeldaswordskills.entity.bugs.EntityBigBeetle;
import addon.zeldaswordskills.entity.bugs.EntitySmallBeetle;
import addon.zeldaswordskills.entity.bugs.EntityVolcanicLadybug;
import addon.zeldaswordskills.items.AddonItems;
import addon.zeldaswordskills.models.ModelDarknutArmor;
import addon.zeldaswordskills.renderer.RenderCucco;
import addon.zeldaswordskills.renderer.RenderGoldOctorok;
import addon.zeldaswordskills.renderer.RenderLandOctorok;
import addon.zeldaswordskills.renderer.TileEntitySwitchRenderer;
import addon.zeldaswordskills.renderer.bugs.RenderBigBeetle;
import addon.zeldaswordskills.renderer.bugs.RenderSmallBeetle;
import addon.zeldaswordskills.renderer.bugs.RenderVolcanicLadybug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import zeldaswordskills.ZSSMain;
import zeldaswordskills.client.ISwapModel;
import zeldaswordskills.item.IModItem;

public class AddonClientProxy extends AddonCommonProxy
{
	private final Minecraft mc = Minecraft.getMinecraft();
	/** Stores all models which need to be replaced during {@link ModelBakeEvent} */
	@SuppressWarnings("deprecation")
	public static final Map<ModelResourceLocation, Class<? extends net.minecraft.client.resources.model.IBakedModel>> smartModels = Maps.newHashMap();
	private static ModelDarknutArmor darknut = new ModelDarknutArmor(1.0f);
	private static ModelBiped tightArmor = new ModelBiped(0.4f);
	
	@Override
	public void preInit()
	{
		registerVariants();
	}
	
	@Override
	public void init()
	{
		registerRenderers();
	}
	
	@Override
	public ModelBiped getArmorModel(int id, String type)
	{	
		switch(id)
		{
			case 0:
				darknut = new ModelDarknutArmor(1.0f);
			case 1:
				darknut = new ModelDarknutArmor(1.1f);
			case 2:
				darknut = new ModelDarknutArmor(0.1f);
			case 3:
				tightArmor = new ModelBiped(0.4f);
			case 4:
				tightArmor = new ModelBiped(0.2f);
			default:
				tightArmor = new ModelBiped(0.4f);
		}
		
		if(type == "darknut") return darknut;
		if(type == "toonic") return tightArmor;
		return tightArmor;
	}
	
	public void registerRenderers()
    {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySwitch.class, new TileEntitySwitchRenderer());
       	
		RenderManager renderMngr = Minecraft.getMinecraft().getRenderManager();
    	RenderingRegistry.registerEntityRenderingHandler(EntityLandOctorok.class, new RenderLandOctorok(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGoldOctorok.class, new RenderGoldOctorok(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntitySmallBeetle.class, new RenderSmallBeetle(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBigBeetle.class, new RenderBigBeetle(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityVolcanicLadybug.class, new RenderVolcanicLadybug(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCucco.class, new RenderCucco(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCuccoAngry.class, new RenderCucco(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCuccoGolden.class, new RenderCucco(renderMngr));
    
    	try {
			for (Field f: AddonItems.class.getFields()) {
				if (Item.class.isAssignableFrom(f.getType())) {
					Item item = (Item) f.get(null);
					if (item instanceof IModItem) {
						((IModItem) item).registerRenderers(mc.getRenderItem().getItemModelMesher());
					}
					if (item instanceof ISwapModel) {
						addModelToSwap((ISwapModel) item);
					}
				}
			}
		} catch(Exception e) {
			ZSSMain.logger.warn("Caught exception while registering item renderers: " + e.toString());
			e.printStackTrace();
		}
    }
	
	private void addModelToSwap(ISwapModel swap)
	{
		for (ModelResourceLocation resource : swap.getDefaultResources()) {
			if (smartModels.containsKey(resource)) {
				if (smartModels.get(resource) != swap.getNewModel()) {
					ZSSMain.logger.warn("Conflicting models for resource " + resource.toString() + ": models=[old: " + smartModels.get(resource).getSimpleName() + ", new: " + swap.getNewModel().getSimpleName());
				}
			} else {
				ZSSMain.logger.debug("Swapping model for " + resource.toString() + " to class " + swap.getNewModel().getSimpleName());
				smartModels.put(resource, swap.getNewModel());
			}
		}
	}
	
	private void registerVariants()
	{
		try {
			for (Field f: AddonItems.class.getFields()) {
				if (Item.class.isAssignableFrom(f.getType())) {
					Item item = (Item) f.get(null);
					if (item instanceof IModItem) {
						((IModItem) item).registerVariants();
					}
				}
			}
		} catch(Exception e) {
			ZSSMain.logger.warn("Caught exception while registering item variants: " + e.toString());
			e.printStackTrace();
		}
	}
}