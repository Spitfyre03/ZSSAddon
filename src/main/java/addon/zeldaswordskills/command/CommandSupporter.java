package addon.zeldaswordskills.command;

import java.util.UUID;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import zeldaswordskills.util.PlayerUtils;
import addon.zeldaswordskills.items.AddonItems;

public class CommandSupporter extends CommandBase
{
	public static final ICommand INSTANCE = new CommandSupporter();
	private static String[] usernames;
    
	private CommandSupporter() {}

	@Override
	public String getCommandName() {
		return "zssa";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	/**
	 * grantsong <player> <song | all> <true>
	 */
	@Override
	public String getCommandUsage(ICommandSender player) {
		return "commands.supporter.usage";
	}

	@Override
	public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException
	{
		EntityPlayerMP player = getCommandSenderAsPlayer(arg0);
		//EntityPlayerMP player = getPlayer(sender, args[0]);
		int stack = player.inventory.getFirstEmptyStack();
		
		UUID uuid = player.getUniqueID();
		UUID uniqueId1 = UUID.fromString("14d87ed8-ce55-4a5e-9be7-ce3cc190232e"); //TheRedMajora
		UUID uniqueId2 = UUID.fromString("5bfe6ad3-8a19-42d8-9a88-392c57a61833"); //HotAssassinRose
		UUID uniqueId3 = UUID.fromString("746a65ff-e9b8-4ad6-830d-f36d50521d6b"); //kamtheman56
		UUID uniqueId4 = UUID.fromString("de14d4cc-6d2f-4e80-b363-2d01c2d408cb"); //BlazingMuffinz
		UUID uniqueId5 = UUID.fromString("7bbd8726-13f6-4d8a-85da-063bf46d8743"); //XxMCVidyaGamezxX
		UUID uniqueId6 = UUID.fromString("965c80e4-ac0d-41ef-84a9-116b88c6cedc"); //Icegod101
		UUID uniqueId7 = UUID.fromString("4f55fd94-feac-4409-832f-f034b6f400f4"); //Santi9101
		UUID uniqueId8 = UUID.fromString("1dd6652b-9046-4aca-b2bf-06a2aaf7325b"); //Starlight199
		UUID uniqueId9 = UUID.fromString("30411b26-0091-44e7-aacb-bee3c889f5e5"); //Kitty9292
		UUID uniqueId10 = UUID.fromString("db71c822-e608-4008-b04e-4ed974734d2e"); //coolAlias
		UUID uniqueId11 = UUID.fromString("a43107f2-cc89-412c-a72f-5940613cfafe"); //DarkMetaknight
		UUID uniqueId12 = UUID.fromString("f91b6fbd-18af-4204-afe0-cd5810db0b67"); //EthanGold60
		
		if((uniqueId1).equals(uuid) || (uniqueId2).equals(uuid) || (uniqueId3).equals(uuid) || (uniqueId4).equals(uuid) || (uniqueId5).equals(uuid) || (uniqueId6).equals(uuid) || (uniqueId7).equals(uuid) || (uniqueId8).equals(uuid) || (uniqueId9).equals(uuid) || (uniqueId10).equals(uuid) || (uniqueId11).equals(uuid) || (uniqueId12).equals(uuid))
		{
			PlayerUtils.sendTranslatedChat(player, "Thank you. Thank you a lot. -TheRedMajora");
			
			if(stack == -1)
			{
				PlayerUtils.sendTranslatedChat(player, "You don't have enough space.");
			}
			else
			{
				PlayerUtils.addItemToInventory(player, new ItemStack(AddonItems.swordSupport, 1));
					
				if(stack == -1)
				{
					PlayerUtils.sendTranslatedChat(player, "You don't have enough space.");
				}
				else
				{
					PlayerUtils.addItemToInventory(player, new ItemStack(AddonItems.shieldSupport, 1));
				}
			}
		}
		else
		{
			PlayerUtils.sendTranslatedChat(player, "I'm sorry, " + player.getDisplayName() + ", but you are not an official supporter!");
		}
	}
}
