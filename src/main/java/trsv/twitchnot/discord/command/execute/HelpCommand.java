package trsv.twitchnot.discord.command.execute;

import trsv.TwitchNot;
import trsv.twitchnot.discord.DiscordBot;
import trsv.twitchnot.discord.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Map;

public class HelpCommand
        implements Command {
    private final String TEXT = "Commands: \ntwitchnot.restart\ntwitchnot.status\ntwitchnot.help <command> - get help for command";

    public boolean called(String[] args, MessageReceivedEvent e) {
        if ((args.length > 0) && (!TwitchNot.HANDLER.commands.containsKey(args[0]))) {
            return false;
        }
        return true;
    }

    public void action(String[] args, MessageReceivedEvent e) {
        if (args.length == 0) {
            String list = "Commands:";
            for (Map.Entry<String, Command> entry : TwitchNot.HANDLER.commands.entrySet()) {
                list += "\n" + entry.getKey() + " - " + entry.getValue().help();
            }
            DiscordBot.sendPrivateMessage(e, list);
        } else {
            DiscordBot.sendPrivateMessage(e, ((Command) TwitchNot.HANDLER.commands.get(args[0])).help());
        }
    }

    public String help() {
        return "Get commands list. Use twitchnot.help <command> for command help";
    }

    public void executed(boolean success, MessageReceivedEvent e) {
        if (!success) {
            DiscordBot.sendPrivateMessage(e, "Sorry, command not found. Use twitchnot.help to get help");
        }
    }
}

