package trsv.twitchnot.discord.command.execute;

import trsv.TwitchNot;
import trsv.twitchnot.discord.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RestartCommand
        implements Command {
    public boolean called(String[] args, MessageReceivedEvent e) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent e) {
        TwitchNot.initialize();
    }

    public String help() {
        return "Restart the bot";
    }

    public void executed(boolean success, MessageReceivedEvent e) {
        if (success) {
            System.out.println("Bot restarted");
        } else {
            System.out.println("Bot not restarted");
        }
    }
}
