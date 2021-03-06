package discordbot;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commands.*;

import java.util.Scanner;

import net.dv8tion.jda.*;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.utils.AvatarUtil;
import net.dv8tion.jda.utils.AvatarUtil.Avatar;

public class Main 
{
	private static JDA jda;
	public static final CommandParser parser = new CommandParser();
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	public static List<User> data;
	
	public static void main(String[] args) 
	{
		try
		{
			jda = new JDABuilder().addListener(new BotListener()).setBotToken("TOKEN").buildBlocking();
			jda.setAutoReconnect(true);
			jda.getAccountManager().setGame("with Fire");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		data = new ArrayList<User>();
		//commands.put("ping", new PingCommand());
		commands.put("eevee", new EeveeCommand());
		commands.put("server", new ServerCommand());
		commands.put("servers", new ServerCommand());
		commands.put("egg", new EggCommand());
		commands.put("eggs", new EggCommand());
		commands.put("ban", new BanCommand());
		commands.put("confirm", new ConfirmCommand());
		commands.put("undo", new UndoCommand());
		commands.put("unban", new UnbanCommand());
		commands.put("help", new HelpCommand());
		commands.put("valor", new ValorCommand());
		commands.put("praise", new PraiseCommand());
		commands.put("version", new VersionCommand());
		commands.put("whoami", new WhoAmICommand());
	}
	
	public static void handleCommand(CommandParser.CommandContainer cmd)
	{
		String invoke = cmd.invoke.toLowerCase();
		if(commands.containsKey(invoke))
		{
			boolean safe = commands.get(invoke).called(cmd.args, cmd.event);
			if(safe)
			{
				commands.get(invoke).action(cmd.args, cmd.event, data);
				commands.get(invoke).executed(safe, cmd.event);
			}
			else
			{
				commands.get(invoke).executed(safe, cmd.event);
			}
		}
	}
}
