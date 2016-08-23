package addon.zeldaswordskills;

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
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class AddonClientProxy extends AddonCommonProxy
{
	private static final ModelDarknutArmor darknut = new ModelDarknutArmor(1.0f);
	private static final ModelDarknutArmor darknutThin = new ModelDarknutArmor(0.1f);
	private static final ModelDarknutArmor darknutHelm = new ModelDarknutArmor(1.1f);
	/**
	private static final ModelBiped tightArmor = new ModelBiped(0.1f);
	 */
	
	@Override
	public ModelBiped getArmorModel(int id)
	{	
		switch(id)
		{
			case 0:
				return darknut;
			case 1:
				return darknutHelm;
			case 2:
				return darknutThin;
				/**
			case 3:
				return tightArmor;
				 */
			default:
				return darknut;
		}
	}
	
	@Override
	public void registerRenderers()
    {
		//These needs to be rendered.
		ItemRenderer.registerItemRenderer();
    	/**
		MinecraftForgeClient.registerItemRenderer(AddonItems.swordFierce, new RenderBigItem(0.75F));
		MinecraftForgeClient.registerItemRenderer(AddonItems.swordFairy, new RenderBigItem(0.75F));
		MinecraftForgeClient.registerItemRenderer(AddonItems.swordGilded, new RenderBigItem(0.60F));
		MinecraftForgeClient.registerItemRenderer(AddonItems.eightBitSwordWooden, new Render8BitSword(true));
		MinecraftForgeClient.registerItemRenderer(AddonItems.eightBitSwordWhite, new Render8BitSword(true));
		MinecraftForgeClient.registerItemRenderer(AddonItems.eightBitSwordMagical, new RenderBigItem(0.55F));*/
    	
		RenderManager renderMngr = Minecraft.getMinecraft().getRenderManager();
    	RenderingRegistry.registerEntityRenderingHandler(EntityLandOctorok.class, new RenderLandOctorok(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityGoldOctorok.class, new RenderGoldOctorok(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntitySmallBeetle.class, new RenderSmallBeetle(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBigBeetle.class, new RenderBigBeetle(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityVolcanicLadybug.class, new RenderVolcanicLadybug(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCucco.class, new RenderCucco(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCuccoAngry.class, new RenderCucco(renderMngr));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCuccoGolden.class, new RenderCucco(renderMngr));
     }
	
	@Override
	public void registerTabComparators()
	{
    	AddonItems.registerTabComparators();
	}
}