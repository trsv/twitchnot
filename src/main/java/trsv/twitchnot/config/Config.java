package trsv.twitchnot.config;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {
    public static final String TOKEN = "MzM5MDg1MTQ3NDI3MzA3NTIw.DFe1Og.Km60v4_Qkv-J2SgaFrfMKqCx4ig";
    public static final String CLIENT_ID = "339085147427307520";
    public static final String VERSION = "2.0";

    private String channel;
    private String notification;

    public Config() {
        try {
            String config = new String(Files.readAllBytes(Paths.get("TwitchNot" + File.separator + "config.json", new String[0])));

            JSONObject configJson = new JSONObject(config);

            this.channel = configJson.getString("channel");
            this.notification = configJson.getString("text");
        } catch (IOException e) {
            System.out.println("[WARN] Config not found");
        }
    }

    public String getNotification() {
        return this.notification;
    }

    public String getChannel() {
        return this.channel;
    }
}
