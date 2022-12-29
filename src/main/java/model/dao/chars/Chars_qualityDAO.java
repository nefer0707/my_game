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
			rs.close();
		}
		ps.close();
		return mychar_q;
	}

	public void insert_Char_q(int char_id, int lv, int job_lv, int exp, int job_exp, int max_hp, int hp, int max_mp,
			int mp, int str, int inte, int dex, int agi, int luk, int vit, int points) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[chars_quality]"
				+ "([lv],[job_lv],[exp],[job_exp],[max_hp],[hp],[max_mp],[mp],[str],[inte],[dex],[agi],[luk],[vit],[points],[char_id])"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, lv);
		ps.setInt(2, job_lv);
		ps.setInt(3, exp);
		ps.setInt(4, job_exp);
		ps.setInt(5, max_hp);
		ps.setInt(6, hp);
		ps.setInt(7, max_mp);
		ps.setInt(8, mp);
		ps.setInt(9, str);
		ps.setInt(10, inte);
		ps.setInt(11, dex);
		ps.setInt(12, agi);
		ps.setInt(13, luk);
		ps.setInt(14, vit);
		ps.setInt(15, points);
		ps.setInt(16, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_lv(int lv, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [lv] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, lv);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_job_lv(int job_lv, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [job_lv] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, job_lv);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_exp(int exp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [exp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, exp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_job_exp(int job_exp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [job_exp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, job_exp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_max_hp(int max_hp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [max_hp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, max_hp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_hp(int hp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [hp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, hp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_max_mp(int max_mp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [max_mp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, max_mp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_mp(int mp, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [mp] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, mp);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_str(int str, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [str] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, str);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_inte(int inte, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [inte] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, inte);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_dex(int dex, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [dex] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dex);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_agi(int agi, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [agi] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, agi);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_luk(int luk, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [luk] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, luk);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_vit(int vit, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [vit] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, vit);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

	public void update_Char_q_points(int points, int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars_quality] SET [points] = ? WHERE [char_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, points);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
	}

}
