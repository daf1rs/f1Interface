package daf1rs.f1Interface.commands;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class F1InterfaceCommand implements CommandExecutor {

    private static final HashMap<String, BossBar> bossBars = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if (args.length < 2) {
            player.sendMessage("§cИспользование: /f1interface <element> <action> <name>");
            return true;
        }

        String bossBarName = args[2];

        if (bossBars.containsKey(bossBarName)) {
            player.sendMessage("§cBossBar с таким именем уже существует!");
            return true;
        }

        // Создание BossBar с параметрами по умолчанию
        BossBar bossBar = Bukkit.createBossBar(
                "§a" + bossBarName,        // Название
                BarColor.BLUE,             // Цвет
                BarStyle.SOLID,            // Стиль
                BarFlag.CREATE_FOG         // Эффект мигания
        );

        bossBar.setProgress(0.5);  // Установим прогресс на 50%
        bossBar.addPlayer(player); // Показываем игроку

        bossBars.put(bossBarName, bossBar);
        player.sendMessage("§aBossBar §b" + bossBarName + " §aсоздан!");
        return true;
    }

}
