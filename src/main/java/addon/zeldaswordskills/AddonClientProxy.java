package addon.zeldaswordskills;

import java.lang.reflect.Field;
import java.util.Map;

import com.google.common.collect.Maps;

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
import addon.zeldaswordskills.renderer.bugs.RenderBigBeetle;
import addon.zeldaswordskills.renderer.bugs.RenderSmallBeetle;
import addon.zeldaswordskills.renderer.bugs.RenderVolcanicLadybug;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import zeldaswordskills.ZSSMain;
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
						((IModItem)item).registerRenderers(mc.getRenderItem().getItemModelMesher());
					}
				}
			}
		} catch(Exception e) {
			ZSSMain.logger.warn("Caught exception while registering item renderers: " + e.toString());
			e.printStackTrace();
		}
    	
    	reg(AddonItems.blueSwitch);
    	reg(AddonItems.rustedSwitch);
    	reg(AddonItems.normalSwitch);
    	reg(AddonItems.metal1ore);
    	reg(AddonItems.metal2ore);
    	reg(AddonItems.metal3ore);
    	reg(AddonItems.phantomBlock);
    	reg(AddonItems.candle_block);
    }
	
	private void reg(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ZSSAddon.ModID + ":" + block.getUnlocalizedName().lastIndexOf("."), "inventory"));
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