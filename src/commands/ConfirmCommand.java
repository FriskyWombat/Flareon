package commands;

import java.util.List;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.Role;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class ConfirmCommand implements Command 
{
	private final String HELP = "USAGE: `?confirm`";
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
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " You don't have permission to ban users! Sorry bud.");
			return;
		}
		if(data.size() < 2)
		{
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " Make sure you use the `?ban @user` command first!");
			return;
		}
		if(!event.getMessage().getAuthor().getId().equals(data.get(0).getId()))
		{
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " Make sure you use the `?ban @user` command first!");
			return;
		}
		String str = "";
		for(int i = 1; i < data.size(); i ++)
		{
			User user = data.get(i);
			str += user.getUsername() + " #" + user.getId() + " ";
			event.getGuild().getManager().ban(user, 1);
		}
		System.out.println("BANNED USERS: " + str + "\nBY: " + event.getAuthor().getUsername());
		event.getAuthor().getPrivateChannel().sendMessage("BANNED USERS: " + str + "\nIf this was a mistake, you can use `?undo` or `?unban #xxxx` to reverse it.\nMessage @FriskyWombat for any further questions.");
		event.getTextChannel().sendMessage("Flareon used ban hammer! It's super effective!");
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
