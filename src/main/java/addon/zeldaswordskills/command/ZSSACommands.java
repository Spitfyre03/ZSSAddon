package addon.zeldaswordskills.command;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ZSSACommands
{
	public static void registerCommands(FMLServerStartingEvent event)
	{
		event.registerServerCommand(CommandSupporter.INSTANCE);
		//event.registerServerCommand(CommandClass.INSTANCE);
		//event.registerServerCommand(CommandClass.INSTANCE);
		//event.registerServerCommand(CommandClass.INSTANCE);
	}
}
