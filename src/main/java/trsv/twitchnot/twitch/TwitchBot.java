package trsv.twitchnot.twitch;

import de.tobj.twitch.streamobserver.TwitchStreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trsv.TwitchNot;
import trsv.twitchnot.twitch.listener.TwitchBotListener;

/**
 * Created by GFY on 13.08.2017.
 */
public class TwitchBot {
    private static final Logger logger = LogManager.getLogger(TwitchBot.class);

    private TwitchStreamObserver bot = new TwitchStreamObserver("TwitchNot");

    public TwitchBot() {
        bot.addChannel(TwitchNot.config.getChannel());
        bot.addListener(new TwitchBotListener());
        bot.start();
    }

    public void start() {
        bot.resume();
        TwitchNot.discordBot.setStatus(true);
        logger.info("Bot resumed");
    }

    public void stop() {
        bot.stop();
        TwitchNot.discordBot.setStatus(false);
        logger.info("Bot stopped");
    }
}
