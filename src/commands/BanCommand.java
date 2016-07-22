package commands;

import java.util.List;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.Role;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class BanCommand implements Command 
{
	private final String HELP = "USAGE: `?ban @user`";
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
		List<User> users = event.getMessage().getMentionedUsers();
		if(users.size() < 1)
		{
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " " + HELP);
			return;
		}
		String str = "";
		for(User u: users)
			str += u.getUsername() + " ";
		data.clear();
		data.addAll(users);
		data.add(0, event.getAuthor());
		event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + 
				" Are you sure you want to ban " + str +"?\nType `?confirm` to finalize.");
		
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
