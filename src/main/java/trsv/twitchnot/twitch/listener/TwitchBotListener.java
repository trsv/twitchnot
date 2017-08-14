package trsv.twitchnot.twitch.listener;

import de.tobj.twitch.streamobserver.channel.event.StreamStatusEvent;
import de.tobj.twitch.streamobserver.channel.listener.StreamListener;
import de.tobj.twitch.streamobserver.channel.result.Channel;
import de.tobj.twitch.streamobserver.channel.result.Stream;
import trsv.TwitchNot;

/**
 * Created by GFY on 13.08.2017.
 */
public class TwitchBotListener extends StreamListener {
    @Override
    public void streamIsOnline(StreamStatusEvent event) {

        Stream stream = event.getStreamData();
        Channel channel = stream.getChannel();

        String streamName = channel.getStatus();
        String displayName = channel.getDisplayName();
        String url = channel.getUrl();
        String game = stream.getGame();

        TwitchNot.discordBot.broadcast(streamName, displayName, game, url);
    }
}