package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.community.BattleBean;

public class BattleDAO {
	Connection con;

	public BattleDAO(Connection con) {
		this.con = con;
	}

	public void insert_battle_for_char_id(int char_id) throws SQLException {
		String sql = "insert into [MyGame].[dbo].[battle](char_id) values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ps.executeUpdate();
	}

	public BattleBean select_for_char_id(int char_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[battle] where char_id = ?";
		BattleBean battle = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int battle_id = rs.getInt("battle_id");
			char_id = rs.getInt("char_id");
			battle = new BattleBean(battle_id, char_id);
		}
		return battle;
	}
	public void delete_for_char_id(int char_id) throws SQLException {
		String sql = "delete from [MyGame].[dbo].[battle] where char_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ps.executeUpdate();
	}
}
