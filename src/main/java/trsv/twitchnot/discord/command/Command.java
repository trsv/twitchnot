package trsv.twitchnot.discord.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract interface Command {
    public abstract boolean called(String[] paramArrayOfString, MessageReceivedEvent paramMessageReceivedEvent);

    public abstract void action(String[] paramArrayOfString, MessageReceivedEvent paramMessageReceivedEvent);

    public abstract String help();

    public abstract void executed(boolean paramBoolean, MessageReceivedEvent paramMessageReceivedEvent);
}
