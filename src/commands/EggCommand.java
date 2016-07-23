package commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import discordbot.Command;

public class EggCommand implements Command 
{
	private static final String[] eggList2km = 
		{"Bulbasaur","Charmander", "Squirtle","Caterpie","Weedle","Pidgey","Rattata",
		 "Spearow","Pikachu","Clefairy","Jigglypuff","Zubat","Geodude","Magikarp"};
	private static final String[] eggList5km = 
		{"Ekans","Sandshrew","NidoranF","NidoranM","Vulpix","Oddish","Paras","Venonat","Diglett",
		 "Meowth","Psyduck","Mankey","Growlithe","Poliwag","Abra","Machop","Bellsprout",
		 "Tentacool","Ponyta","Slowpoke","Magnemite","Farfetch'd","Doduo","Seel",
		 "Grimer","Shellder","Gastly","Drowzee","Krabby","Voltorb","Exeggcute","Cubone",
		 "Lickitung","Koffing","Rhyhorn","Tangela","Kangaskhan","Horsea","Goldeen",
		 "Staryu","Mr.Mime", "Tauros", "Porygon"};
	private static final String[] eggList10km = 
		{"Onix", "Hitmonlee","Hitmonchan","Chansey","Scyther","Jynx","Electabuzz","Magmar",
		"Pinsir","Lapras","Eevee","Omanyte","Kabuto","Aerodactyl","Snorlax","Dratini"};
	
	private final String HELP = "Usage: `?egg <2,5,10>`  or  `?egg <Pokémon>`";
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event, List<User> data) 
	{
		if(args == null || args.length == 0 || args[0] == null || args[0] == "")
		{
			event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " " + HELP);
			event.getMessage().deleteMessage();
			return;
		}
		String[] list = {};
		String dist = "";
		if(args[0].equals("2") || args[0].equals("2k") || args[0].equals("2km"))
		{
			list = eggList2km;
			dist = "2km";
		}
		if(args[0].equals("5") || args[0].equals("5k") || args[0].equals("5km"))
		{
			list = eggList5km;
			dist = "5km";
		}
		if(args[0].equals("10") || args[0].equals("10k") || args[0].equals("10km"))
		{
			list = eggList10km;
			dist = "10km";
		}
		if(!dist.equals(""))  //Print a list of all Pokémon that hatch within the given egg distances.
		{
			String str = "These " + list.length +" Pokémon can be hatched in " + dist + " eggs:\n```\n";
			for(int i = 0; i < list.length; i++)
			{
				str += list[i];
				for(int j = list[i].length(); j < 11; j++)
				{
					str += " ";
				}
				//if(i%8==0 && i>0)
				//	str+="\n";
			}
			str += "```";
			event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + " " + str);
			event.getMessage().deleteMessage();
		}
		else  //Search for the given Pokémon and print out its egg group
		{
			String in = Util.baseEvolution(args[0]);
			String out = event.getAuthor().getAsMention() + " Unable to find that Pokémon. Are you sure you spelled it right?";
			
			
			for(String s: eggList2km)
				if(s.toLowerCase().equals(in.toLowerCase()))
					out = s + " can be hatched from 2km eggs!";
			for(String s: eggList5km)
				if(s.toLowerCase().equals(in.toLowerCase()))
					out = s + " can be hatched from 5km eggs!";
			for(String s: eggList10km)
				if(s.toLowerCase().equals(in.toLowerCase()))
					out = s + " can be hatched from 10km eggs!";
			event.getTextChannel().sendMessage(out);
			event.getMessage().deleteMessage();
		}
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
