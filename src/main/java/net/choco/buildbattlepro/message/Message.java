package net.choco.buildbattlepro.message;

import lombok.Getter;
import lombok.Setter;
import net.choco.buildbattlepro.Main;
import org.bukkit.ChatColor;

public enum Message {

    PLAYING_MAP("messages.playing_map");

    @Getter
    @Setter
    private String message;
    @Getter
    private String path;

    Message(String path) {
        this.path = path;
        this.message = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getFileManager().getConfig("translates.yml").get().getString(this.path));
    }

    public String getMessageWithPrefix() {
        return Main.getInstance().getSettings().getPrefix() + this.message;
    }

    public static void reloadMessages() {
        for (Message m : values()) {
            m.setMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getFileManager().getConfig("translates.yml").get().getString(m.getPath())));
        }
    }

}