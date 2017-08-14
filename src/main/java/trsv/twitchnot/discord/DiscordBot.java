package trsv.twitchnot.discord;

import trsv.TwitchNot;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import trsv.twitchnot.config.Config;
import trsv.twitchnot.discord.listener.DiscordBotListener;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    private JDA api;
    private boolean status;

    public DiscordBot() {
        try {
            this.api = new JDABuilder(AccountType.BOT)
                    .setToken(Config.TOKEN)
                    .setAutoReconnect(true)
                    .addEventListener(new DiscordBotListener())
                    .setBulkDeleteSplittingEnabled(false)
                    .buildBlocking();
            this.status = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {

        this.status = status;
    }

    public void broadcast(String streamName, String displayName, String game, String url) {
        String text = TwitchNot.config.getNotification()
                .replaceAll("%name%", streamName)
                .replaceAll("%game%", game)
                .replaceAll("%channel%", displayName)
                .replaceAll("%url%", url);

        for (Guild g : api.getGuilds()) {
            g.getTextChannels().get(0).sendMessage(text).queue();
            //g.getTextChannels().get(0).sendMessage("Url: " + url).queue();
        }
    }

    public static void sendPrivateMessage(MessageReceivedEvent e, String text) {
        ((PrivateChannel) e.getAuthor().openPrivateChannel().complete()).sendMessage(text).queue();
    }
}
