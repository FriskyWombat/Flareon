package commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class PraiseCommand implements Command 
{
	private final String HELP = "Usage: `?praise`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		event.getTextChannel().sendMessage("*Accepts head rub from " + (event.getAuthor().getAsMention()) + ". Flareon is pleased.*");
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
