package model.dao.chars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.chars.Chars_qualityBean;

public class Chars_qualityDAO {
	Connection con;

	public Chars_qualityDAO(Connection con) {
		this.con = con;
	}

	public Chars_qualityBean selectByChar_id(int char_id) throws SQLException {
		String sql = "SELECT * FROM [MyGame].[dbo].[chars_quality] where char_id  = ?";
		Chars_qualityBean mychar_q = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			char_id = rs.getInt("char_id");
			int lv = rs.getInt("lv");
			int job_lv = rs.getInt("job_lv");
			int exp = rs.getInt("exp");
			int job_exp = rs.getInt("job_exp");
			int max_hp = rs.getInt("max_hp");
			int hp = rs.getInt("hp");
			int max_mp = rs.getInt("max_mp");
			int mp = rs.getInt("mp");
			int str = rs.getInt("str");
			int inte = rs.getInt("inte");
			int dex = rs.getInt("dex");
			int agi = rs.getInt("agi");
			int luk = rs.getInt("luk");
			int vit = rs.getInt("vit");
			int points = rs.getInt("points");
			mychar_q = new Chars_qualityBean(char_id, lv, job_lv, exp, job_exp, max_hp, hp, max_mp, mp, str, inte, dex,
					agi, luk, vit, points);
		}
		return mychar_q;
	}
}
