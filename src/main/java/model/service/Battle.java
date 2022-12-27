package model.service;

import java.sql.Connection;

import model.MyConnection;
import model.bean.community.MonsterBean;
import model.dao.community.MonsterDAO;

public class Battle {

	public MonsterBean select_monster_for_mapid(int battlemap_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		MonsterBean monster = null;
		MonsterDAO dao = new MonsterDAO(con);
		monster = dao.select_for_Battlemap_id(battlemap_id);
		con.close();
		return monster;
	}
	
}
