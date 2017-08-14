package trsv;

import trsv.twitchnot.config.Config;
import trsv.twitchnot.discord.DiscordBot;
import trsv.twitchnot.discord.command.CommandHandler;
import trsv.twitchnot.twitch.TwitchBot;

public class TwitchNot {

    public static final CommandHandler HANDLER = new CommandHandler();

    public static DiscordBot discordBot;
    public static Config config;
    public static TwitchBot twitchBot;

    public TwitchNot() {
        initialize();
    }

    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        config = new Config();
        discordBot = new DiscordBot();
        twitchBot = new TwitchBot();

    }
}
