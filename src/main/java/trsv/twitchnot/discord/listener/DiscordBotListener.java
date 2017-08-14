package trsv.twitchnot.discord.listener;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import trsv.TwitchNot;

public class DiscordBotListener
        extends ListenerAdapter {
    public void onReady(ReadyEvent e) {
        String onServers = "This bot running on following servers: \n";
        for (Guild g : e.getJDA().getGuilds()) onServers = onServers + "\t" + g.getName() + " (" + g.getId() + ") \n";
    }

    public void onMessageReceived(MessageReceivedEvent e) {
        if ((e.getMessage().getContent().startsWith("twitchnot.")) &&
                (e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId())) {
            TwitchNot.HANDLER.handleCommand(TwitchNot.HANDLER.PARSER.parse(e
                    .getMessage().getContent().toLowerCase(), e));
        }
    }
}
