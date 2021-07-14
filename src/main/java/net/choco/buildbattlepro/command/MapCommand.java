package net.choco.buildbattlepro.command;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.base.CommandBase;
import net.choco.buildbattle.BuildBattle;
import net.choco.buildbattle.objects.arena.BBArena;
import net.choco.buildbattlepro.message.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("map")
public class MapCommand extends CommandBase {

    @Default
    public void defaultCommand(CommandSender commandSender) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            BBArena a = BuildBattle.getInstance().getPlayerManager().getPlayerArena(player);

            if (a != null) {
                    player.sendMessage(Message.PLAYING_MAP.getMessageWithPrefix().replace("{map}", a.getName()));
                    return;
                } else {
                    player.sendMessage(net.choco.buildbattle.objects.language.Message.NOT_IN_ARENA.getChatMessage());
                }
            }
    }
}