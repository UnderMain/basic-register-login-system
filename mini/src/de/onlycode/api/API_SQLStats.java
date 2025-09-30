package de.onlycode.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.onlycode.TemplateMain;

public class API_SQLStats {

	public static boolean playerExists(String uuid) {

		try {
			ResultSet rs = TemplateMain.main.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");

			if (rs.next()) {

				return rs.getString("UUID") != null;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void createPlayer(String uuid) {

		if (!(playerExists(uuid))) {
			TemplateMain.main.mysql.update("INSERT INTO Stats(UUID, KILLS, DEATHS) VALUES ('" + uuid + "', '0', '0');");
		}

	}

	public static Integer getKills(String uuid) {
		Integer i = 0;

		if (playerExists(uuid)) {

			try {
				ResultSet rs = TemplateMain.main.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				if ((!rs.next()) || (Integer.valueOf(rs.getInt("KILLS")) == null))
					;

				i = rs.getInt("KILLS");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			createPlayer(uuid);
			getKills(uuid);
		}

		return i;
	}

	public static Integer getDeaths(String uuid) {
		Integer i = 0;

		if (playerExists(uuid)) {

			try {
				ResultSet rs = TemplateMain.main.mysql.query("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				if ((!rs.next()) || (Integer.valueOf(rs.getInt("DEATHS")) == null))
					;

				i = rs.getInt("DEATHS");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			createPlayer(uuid);
			getDeaths(uuid);
		}

		return i;
	}

	public static void setKills(String uuid, Integer kills) {
		if (playerExists(uuid)) {
			TemplateMain.main.mysql.update("UPDATE Stats SET KILLS= '" + kills + "'WHERE UUID= '" + uuid + "';");

		} else {
			createPlayer(uuid);
			setKills(uuid, kills);
		}

	}

	public static void setDeaths(String uuid, Integer deaths) {
		if (playerExists(uuid)) {
			TemplateMain.main.mysql.update("UPDATE Stats SET DEATHS= '" + deaths + "'WHERE UUID= '" + uuid + "';");

		} else {
			createPlayer(uuid);
			setDeaths(uuid, deaths);
		}

	}

	public static void addKills(String uuid, Integer kills) {
		if (playerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() + kills.intValue()));

		} else {
			createPlayer(uuid);
			addKills(uuid, kills);
		}
	}

	public static void addDeaths(String uuid, Integer deaths) {
		if (playerExists(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() + deaths.intValue()));

		} else {
			createPlayer(uuid);
			addDeaths(uuid, deaths);
		}
	}

	public static void removeKills(String uuid, Integer kills) {
		if (playerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() - kills.intValue()));

		} else {
			createPlayer(uuid);
			removeKills(uuid, kills);
		}
	}

	public static void removeDeaths(String uuid, Integer deaths) {
		if (playerExists(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid).intValue() - deaths.intValue()));

		} else {
			createPlayer(uuid);
			removeDeaths(uuid, deaths);
		}
	}

}
