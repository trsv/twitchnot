package trsv.twitchnot.discord.command.execute;

import trsv.TwitchNot;
import trsv.twitchnot.discord.DiscordBot;
import trsv.twitchnot.discord.command.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class StatusCommand
        implements Command {
    public boolean called(String[] args, MessageReceivedEvent e) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent e) {
        String status = (TwitchNot.discordBot.getStatus()) ? "work" : "stop";
        DiscordBot.sendPrivateMessage(e, "status: " + status);
    }

    public String help() {
        return "Get bot status";
    }

    public void executed(boolean success, MessageReceivedEvent e) {
        if (!success) {
            DiscordBot.sendPrivateMessage(e, help());
        }
    }
}
