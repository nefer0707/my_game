package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.community.Battle_monsterBean;

public class Battle_monsterDAO {
	Connection con;

	public Battle_monsterDAO(Connection con) {
		this.con = con;
	}

	public void insert_for_battle_id(int battle_id, int monster_id, String monster_name, String monster_img, int lv,
			int exp, int job_exp, int max_hp, int hp, int max_mp, int mp, int str, int inte, int agi, int dex, int luk,
			int vit) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[battle_monster]([battle_id],[monster_id],[monster_name],[monster_img],[lv],[exp],[job_exp],[max_hp],[hp],[max_mp],[mp],[str],[inte],[agi],[dex],[luk],[vit]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, battle_id);
		ps.setInt(2, monster_id);
		ps.setString(3, monster_name);
		ps.setString(4, monster_img);
		ps.setInt(5, lv);
		ps.setInt(6, exp);
		ps.setInt(7, job_exp);
		ps.setInt(8, max_hp);
		ps.setInt(9, hp);
		ps.setInt(10, max_mp);
		ps.setInt(11, mp);
		ps.setInt(12, str);
		ps.setInt(13, inte);
		ps.setInt(14, agi);
		ps.setInt(15, dex);
		ps.setInt(16, luk);
		ps.setInt(17, vit);
		ps.executeUpdate();
		ps.close();
	}

	public void update_hp_for_battle_id(int battle_id, int hp) throws SQLException {
		String sql = "update [MyGame].[dbo].[battle_monster] set hp = ? where battle_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, hp);
		ps.setInt(2, battle_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_mp_for_battle_id(int battle_id, int mp) throws SQLException {
		String sql = "update [MyGame].[dbo].[battle_monster] set mp = ? where battle_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, mp);
		ps.setInt(2, battle_id);
		ps.executeUpdate();
		ps.close();
	}

	public void detele_for_battle_id(int battle_id) throws SQLException {
		String sql = "delete from [MyGame].[dbo].[battle_monster] where battle_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, battle_id);
		ps.executeUpdate();
		ps.close();
	}

	public Battle_monsterBean select_for_battle_id(int battle_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[battle_monster] where battle_id =?";
		Battle_monsterBean battle_monster = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, battle_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int monster_id = rs.getInt("monster_id");
			String monster_name = rs.getString("monster_name");
			String monster_img = rs.getString("monster_img");
			int lv = rs.getInt("lv");
			int exp = rs.getInt("exp");
			int job_exp = rs.getInt("job_exp");
			int max_hp = rs.getInt("max_hp");
			int hp = rs.getInt("hp");
			int max_mp = rs.getInt("max_mp");
			int mp = rs.getInt("mp");
			int str = rs.getInt("str");
			int inte = rs.getInt("inte");
			int agi = rs.getInt("agi");
			int dex = rs.getInt("dex");
			int luk = rs.getInt("luk");
			int vit = rs.getInt("vit");
			battle_id = rs.getInt("battle_id");
			battle_monster = new Battle_monsterBean(monster_id, monster_name, monster_img, lv, exp, job_exp, max_hp, hp,
					max_mp, mp, str, inte, agi, dex, luk, vit, battle_id);
		}
		rs.close();
		ps.close();
		return battle_monster;
	}
}
