package commands;

import java.util.List;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.Role;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class UndoCommand implements Command 
{
	private final String HELP = "USAGE: `?undo`";
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
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " You don't have permission to unban users! Sorry bud.");
			return;
		}
		if(data.size() < 2 || !data.get(0).getId().equals(event.getAuthor().getId()))
		{
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " Unable to undo ban. Try manually unbanning with `?unban #xxxx`");
		}
		String str = "";
		for(int i = 1; i < data.size(); i ++)
		{
			User user = data.get(i);
			str += user.getUsername() + " #" + user.getId() + " ";
			event.getGuild().getManager().unBan(user);
		}
		System.out.println("UNBANNED USERS: " + str + "\nBY: " + event.getAuthor().getUsername());
		event.getAuthor().getPrivateChannel().sendMessage("UNBANNED USERS: " + str);
		event.getTextChannel().sendMessage("Unban successful!");
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
