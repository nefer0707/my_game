package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.community.BattleMapBean;

public class BattleMapDAO {
	Connection con;

	public BattleMapDAO(Connection con) {
		this.con = con;
	}
	
	public BattleMapBean select_for_battle_name(String battlemap_name) throws SQLException {
		String sql="select * from [MyGame].[dbo].[battlemap] where battlemap_name = ?";
		BattleMapBean choosemap = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, battlemap_name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int battlemap_id =rs.getInt("battlemap_id");
			battlemap_name=rs.getString("battlemap_name");
			choosemap = new BattleMapBean(battlemap_id, battlemap_name);
		}
		rs.close();
		ps.close();
		return choosemap;
	}
}