package trsv.twitchnot.discord.command;

import trsv.twitchnot.discord.DiscordBot;
import trsv.twitchnot.discord.command.execute.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class CommandHandler {
    public final CommandParser PARSER = new CommandParser();
    public HashMap<String, Command> commands = new HashMap();

    public CommandHandler() {
        this.commands.put("restart", new RestartCommand());
        this.commands.put("status", new StatusCommand());
        this.commands.put("help", new HelpCommand());
        this.commands.put("start", new StartCommand());
        this.commands.put("stop", new StopCommand());
    }

    public void handleCommand(CommandContainer cmd) {
        if (this.commands.containsKey(cmd.invoke)) {
            Command command = (Command) this.commands.get(cmd.invoke);
            if (!hasPermission(cmd.e)) {
                DiscordBot.sendPrivateMessage(cmd.e, "Sorry, You do not have permissions");
                return;
            }
            boolean safe = command.called(cmd.args, cmd.e);
            if (safe) {
                command.action(cmd.args, cmd.e);
                command.executed(safe, cmd.e);
            } else {
                command.executed(safe, cmd.e);
            }
        }
    }

    private static boolean hasPermission(MessageReceivedEvent e) {
        return e.getAuthor().getId().equals("278623497742450688");
    }
}
