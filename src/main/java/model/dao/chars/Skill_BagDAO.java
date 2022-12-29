package model.dao.chars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.chars.Skill_BagBean;

public class Skill_BagDAO {
	Connection con;

	public Skill_BagDAO(Connection con) {
		this.con = con;
	}

	public Skill_BagBean select_char_id_skill_id(int char_id, int skill_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[skill_bag] where char_id = ? and skill_id =?";
		Skill_BagBean myskill = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ps.setInt(2, skill_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			skill_id = rs.getInt("skill_id");
			char_id = rs.getInt("char_id");
			myskill = new Skill_BagBean(skill_id,char_id);
		}
		rs.close();
		ps.close();
		return myskill;
	}

	public void insert_skill_char_id(int char_id, int skill_id) throws SQLException {
		String sql ="INSERT INTO [MyGame].[dbo].[skill_bag]([skill_id],[char_id]) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, skill_id);
		ps.setInt(2, char_id);
		ps.executeUpdate();
		ps.close();
		
	}
}
