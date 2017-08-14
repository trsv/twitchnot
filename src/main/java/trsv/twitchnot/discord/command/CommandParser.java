package trsv.twitchnot.discord.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class CommandParser {
    public CommandContainer parse(String rw, MessageReceivedEvent e) {
        ArrayList<String> split = new ArrayList();
        String raw = rw;
        String beheaded = raw.replaceFirst("twitchnot.", "");
        String[] splitBeheaded = beheaded.split(" ");
        for (String s : splitBeheaded) {
            split.add(s);
        }
        String invoke = (String) split.get(0);
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, e);
    }
}
