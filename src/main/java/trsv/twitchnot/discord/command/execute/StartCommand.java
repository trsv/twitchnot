package trsv.twitchnot.discord.command.execute;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import trsv.TwitchNot;
import trsv.twitchnot.discord.command.Command;

/**
 * Created by GFY on 13.08.2017.
 */
public class StartCommand implements Command {
    @Override
    public boolean called(String[] paramArrayOfString, MessageReceivedEvent paramMessageReceivedEvent) {
        return true;
    }

    @Override
    public void action(String[] paramArrayOfString, MessageReceivedEvent paramMessageReceivedEvent) {
        TwitchNot.twitchBot.start();
    }

    @Override
    public String help() {
        return "Start check stream";
    }

    @Override
    public void executed(boolean paramBoolean, MessageReceivedEvent paramMessageReceivedEvent) {

    }
}
