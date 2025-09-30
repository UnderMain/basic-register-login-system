package de.onlycode.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.onlycode.TemplateMain;
import de.onlycode.api.API_SQLStats;

public class CMD_stats implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("stats")) {
				if (args.length == 0) {

					int deaths = API_SQLStats.getDeaths(p.getUniqueId().toString());
					int kills = API_SQLStats.getKills(p.getUniqueId().toString());

					double KD = ((double) kills) / ((double) deaths);
					String kd = Double.valueOf(KD).toString();

					p.sendMessage("§7—• §7- §9§nDeine§9 Stats §7- §7•—");
					p.sendMessage("");
					p.sendMessage("§7Deine Kills:§6 " + API_SQLStats.getKills(p.getUniqueId().toString()));
					p.sendMessage("§7Deine Tode:§6 " + API_SQLStats.getDeaths(p.getUniqueId().toString()));
					p.sendMessage("§7Deine KD: §6" + kd.replace("Infinity", "0").replace("NaN", "0"));
					p.sendMessage("");
					p.sendMessage("§7—• §7- §9§nDeine§9 Stats §7- §7•—");

				}

			}

		} else {
			sender.sendMessage(TemplateMain.main.pr + "§cERROR");
		}

		return false;
	}

}
