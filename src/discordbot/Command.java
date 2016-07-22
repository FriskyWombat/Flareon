package discordbot;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public interface Command 
{
	public boolean called(String[] args, MessageReceivedEvent event);
	public void action(String[] args, MessageReceivedEvent event, List<User> data);
	public String help();
	public void executed(boolean success, MessageReceivedEvent event);
}
