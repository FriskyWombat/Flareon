package commands;

import java.util.List;

import net.dv8tion.jda.Permission;
import net.dv8tion.jda.entities.Role;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class UnbanCommand implements Command 
{
	private final String HELP = "USAGE: `?unban #xxxxxxxxxxxxxxxxxx`";
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
		if(args == null || args.length < 1)
		{
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " " + HELP);
			return;
		}
		String userId = args[0];
		List<User> bannedUsers = event.getGuild().getManager().getBans();
		for(User u: bannedUsers)
		{
			if(userId.equals(u.getId()))
			{
				event.getGuild().getManager().unBan(u);
				System.out.println("UNBANNED USERS: " + u.getUsername() + "\nBY: " + event.getAuthor().getUsername());
				event.getAuthor().getPrivateChannel().sendMessage("UNBANNED USERS: " + u.getUsername());
				event.getTextChannel().sendMessage("Unban successful!");
				return;
			}
		}
		event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " ERROR: That user ID is broken, or the associated user is not banned. (Don't put the #)");
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
