package daf1rs.f1Interface.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class F1InterfaceTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        List<String> elements = Arrays.asList("tab", "bossbar", "scorebar", "actionbar");
        List<String> actions = Arrays.asList("create", "select", "change", "delete");

        if (args.length == 1) {
            return filterList(elements, args[0]);
        } else if (args.length == 2) {
            return filterList(actions, args[1]);
        } else if (args.length == 3) {
            return Collections.singletonList("<name>");
        } else if (args.length == 4 && args[1].equalsIgnoreCase("создать")) {
            // Возвращаем кастомную подсказку для имени
            return Collections.singletonList("<name>");
        }

        return new ArrayList<>();
    }

    private List<String> filterList(List<String> source, String input) {
        List<String> result = new ArrayList<>();
        for (String item : source) {
            if (item.toLowerCase().startsWith(input.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

}
