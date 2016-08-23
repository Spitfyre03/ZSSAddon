package addon.zeldaswordskills;

import addon.zeldaswordskills.command.ZSSACommands;
import addon.zeldaswordskills.entity.AddonEntities;
import addon.zeldaswordskills.handler.AddonOreGenerator;
import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zeldaswordskills.creativetab.ZSSCreativeTabs.ZSSCreativeTab;

@Mod(modid = ZSSAddon.ModID, version = ZSSAddon.Version)
public class ZSSAddon
{	
	@Instance(ZSSAddon.ModID)
	public static ZSSAddon instance;
	
	@SidedProxy(serverSide="addon.zeldaswordskills.AddonCommonProxy", clientSide="addon.zeldaswordskills.AddonClientProxy")
	public static AddonCommonProxy proxy;
	
    public static final String ModID = "zssaddon";
    public static final String Version = "1.8-beta-0.1";
    
    public static ZSSCreativeTab combatTab = new ZSSCreativeTab("combatTab")
    {
		public Item getTabIconItem()
		{
			return AddonItems.swordFierce;
		}
	};
	
	public static ZSSCreativeTab miscTab = new ZSSCreativeTab("miscTab")
    {
		public Item getTabIconItem()
		{
			return AddonItems.fierceFragment;
		}
	};
	
	public static ZSSCreativeTab bugTab = new ZSSCreativeTab("bugTab")
    {
		public Item getTabIconItem()
		{
			return AddonItems.bigBugNet;
		}
	};
    
	@EventHandler public void preInit(FMLPreInitializationEvent event) { AddonConfig.preInit(event); AddonEntities.preInit(); }
	@EventHandler public void postInit(FMLPostInitializationEvent event) { AddonConfig.postInit(); AddonEntities.postInit(AddonConfig.config); }
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	System.out.print("[Zelda Sword Skills Addon] Succesfully Loaded!"
    			+ "");
		AddonItems.init();
		//ZSSAddon.registerVillageTrades();
		proxy.registerRenderers();
		proxy.registerTabComparators();
		
		//What would be the other way to achieve the pure metals?
    	GameRegistry.registerWorldGenerator(new AddonOreGenerator(), 10);
    	//Aheam...? FMLCommonHandler.instance().bus().register(new ZeldaAddonHandler());
        AddonAchievements.loadAchievements();
    }
    
    @Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
    {
		ZSSACommands.registerCommands(event);
	}
    
    /**public static void registerVillageTrades()
    {
    	for (int i = 0; i < 5; ++i)
    	{
    		VillagerRegistry.instance().registerVillageTradeHandler(i, new AddonTradeHandler());
    	}
	}*/
}
