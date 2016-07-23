package commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class WhoAmICommand implements Command 
{
	private final String HELP = "Usage: `?WhoAmI`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		List<User> users = event.getGuild().getUsers();
		String friskyMention = "FriskyWombat";
		for(User u: users)
		{
			if(u.getUsername().equals("FriskyWombat"))
			{
				friskyMention = u.getAsMention();
				break;
			}
		}
		event.getTextChannel().sendMessage("I am the **pride** and **joy** of the great trainer, " + friskyMention + " who hatched me and raised me as his own!");
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
