package trsv.twitchnot.discord.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandContainer {
    public final String raw;
    public final String beheaded;
    public final String[] splitBeheaded;
    public final String invoke;
    public final String[] args;
    public final MessageReceivedEvent e;

    public CommandContainer(String raw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent e) {
        this.raw = raw;
        this.beheaded = beheaded;
        this.splitBeheaded = splitBeheaded;
        this.invoke = invoke;
        this.args = args;
        this.e = e;
    }
}
