package commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class EeveeCommand implements Command 
{
	private final String HELP = "Usage: `?eevee`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		event.getTextChannel().sendMessage("Eeveelutions can be controlled by nicknaming your Eevee before evolving!\n"
				+ "THIS ONLY WORKS ONCE PER EEVEELUTION!\n"
										+ "Nickname your Eevee one of the following:\nRainer -> Vaporeon\nSparky -> Jolteon\nPyro -> Flareon");
		
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
