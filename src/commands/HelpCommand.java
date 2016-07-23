package commands;

import java.util.List;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.Role;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class HelpCommand implements Command 
{
	private final String HELP = "Usage: `?help`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		List<Role> authorRoles = event.getGuild().getRolesForUser(event.getAuthor());
		boolean flag = false;
		for(Role r: authorRoles)
		{
			if(r.hasPermission(Permission.BAN_MEMBERS))
				flag = true;
		}
		if(!flag)
		{
			event.getTextChannel().sendMessage(
					"I'm Flareon, here to help the mods do their jobs, and also provide some useful info! I know these moves:\n"
					+ "```\n"
					+ "?eevee         : Display information about the Eevee nicknaming trick.\n"
					+ "?servers       : Display a website that shows the server status. WIP.\n"
					+ "?egg <2,5,10>  : Display all the Pokémon that can be hatched by a specific Egg.\n"
					+ "?egg <Pokémon> : Display which type of egg a specific Pokémon can be hatched.\n"
					+ "?praise        : Display your love and affection for me.\n"
					+ "?version       : Displays the current version of Flareon.\n"
					+ "```\n"
					+ "These are all of the commands you have access to. A mod can say `?help` to display even more options."
					);
		}
		else
		{
			event.getTextChannel().sendMessage(
					"I'm Flareon, here to help the mods do their jobs, and also provide some useful info! I know these moves:\n"
					+ "```\n"
					+ "?eevee         : Display information about the Eevee nicknaming trick.\n"
					+ "?servers       : Display a website that shows the server status. WIP.\n"
					+ "?egg <2,5,10>  : Display all the Pokémon that can be hatched by a specific Egg.\n"
					+ "?egg <Pokémon> : Display which type of egg a specific Pokémon can be hatched.\n"
					+ "?praise        : Display your love and affection for me.\n"
					+ "?version       : Displays the current version of Flareon.\n"
					+ "MOD ONLY COMMANDS:\n"
					+ "?ban @user  : Ban the mentioned user(s). Must be ?confirmed!\n"
					+ "?confirm    : This will actually finalize the banning.\n"
					+ "?undo       : This will undo the previous ban.\n"
					+ "?unban xxxxxxxxxxxxxxxxxx : This will unban a specific user given their\n                            18-digit User ID.\n"
					+ "```"
					);
		}
		event.getMessage().deleteMessage();
	}

	@Override
	public String help() 
	{
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) 
	{
		
	}

}
