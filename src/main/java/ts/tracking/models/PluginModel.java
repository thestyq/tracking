package ts.tracking.models;

import org.bson.Document;

public class PluginModel implements Model {
    private boolean activeX;
    private boolean component;
    private boolean devalVR;
    private boolean flash;
    private boolean quickTime;
    private boolean realPlayer;
    private boolean shockwave;
    private boolean silverlight;
    private boolean vLCPlayer;
    private boolean windowsMediaPlayer;

    public PluginModel() {
    }

    public Document getAsDocument() {
        return new Document()
                .append("activeX", activeX)
                .append("component", component)
                .append("devalVR", devalVR)
                .append("flash", flash)
                .append("quickTime", quickTime)
                .append("realPlayer", realPlayer)
                .append("shockwave", shockwave)
                .append("silverlight", silverlight)
                .append("vLCPlayer", vLCPlayer)
                .append("windowsMediaPlayer", windowsMediaPlayer);
    }
}
