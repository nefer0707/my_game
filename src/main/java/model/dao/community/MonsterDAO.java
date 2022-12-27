package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.community.MonsterBean;

public class MonsterDAO {
	Connection con;

	public MonsterDAO(Connection con) {
		this.con = con;
	}

	public MonsterBean select_for_Battlemap_id(int battlemap_id) throws SQLException {
		String sql = "select top1 * from [MyGame].[dbo].[monster] where battlemap_id = ?";
		MonsterBean monster = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, battlemap_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int monster_id = rs.getInt("monster_id");
			String monster_name = rs.getString("monster_name").trim();
			String monster_img = rs.getString("monster_img").trim();
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
			battlemap_id = rs.getInt("battlemap_id");
			monster = new MonsterBean(monster_id, monster_name, monster_img, lv, exp, job_exp, max_hp, hp,
					max_mp, mp, str, inte, agi, dex, luk, vit, battlemap_id);
		}
		return monster;
	}
	public MonsterBean select_for_monster_id(int monster_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[monster] where monster_id = ?";
		MonsterBean monster = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, monster_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			monster_id = rs.getInt("monster_id");
			String monster_name = rs.getString("monster_name").trim();
			String monster_img = rs.getString("monster_img").trim();
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
			int battlemap_id = rs.getInt("battlemap_id");
			monster = new MonsterBean(monster_id, monster_name, monster_img, lv, exp, job_exp, max_hp, hp,
					max_mp, mp, str, inte, agi, dex, luk, vit, battlemap_id);
		}
		return monster;
	}
}
