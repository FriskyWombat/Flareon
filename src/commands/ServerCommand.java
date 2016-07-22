package commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class ServerCommand implements Command 
{
	private final String HELP = "Usage: `?servers`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		event.getTextChannel().sendMessage("You can check on the server status at this website: http://cmmcd.com/PokemonGo/");
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