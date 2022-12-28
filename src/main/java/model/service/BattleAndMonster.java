package model.service;

import java.sql.Connection;
import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.bean.community.BattleBean;
import model.bean.community.BattleMapBean;
import model.bean.community.Battle_monsterBean;
import model.bean.community.MonsterBean;
import model.dao.community.BattleDAO;
import model.dao.community.BattleMapDAO;
import model.dao.community.Battle_monsterDAO;
import model.dao.community.MonsterDAO;

public class BattleAndMonster {

	public MonsterBean select_monster_for_mapid(int battlemap_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		MonsterBean monster = null;
		MonsterDAO dao = new MonsterDAO(con);
		monster = dao.select_for_Battlemap_id(battlemap_id);
		con.close();
		return monster;
	}

	public BattleMapBean select_map_for_battlemap_name(String battlemap_name) throws Exception {
		Connection con = MyConnection.getMyConnection();
		BattleMapBean choosemap = null;
		BattleMapDAO dao = new BattleMapDAO(con);
		choosemap = dao.select_for_battle_name(battlemap_name);
		con.close();
		return choosemap;
	}

	public BattleBean select_battle_char_id(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		BattleDAO dao = new BattleDAO(con);
		BattleBean battle = dao.select_for_char_id(char_id);
		con.close();
		return battle;
	}

	public void delete_battle_monster(int battle_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Battle_monsterDAO dao = new Battle_monsterDAO(con);
		dao.detele_for_battle_id(battle_id);
		con.close();
	}

	public void insert_battle_char_id(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		BattleDAO dao = new BattleDAO(con);
		dao.insert_battle_for_char_id(char_id);
		con.close();
	}

	public void delete_battle(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		BattleDAO dao = new BattleDAO(con);
		dao.delete_for_char_id(char_id);
		con.close();
	}

	public void insert_battle_monster(MonsterBean monster, int battle_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Battle_monsterDAO dao = new Battle_monsterDAO(con);
		int monster_id = monster.getMonster_id();
		String monster_name = monster.getMonster_name();
		String monster_img = monster.getMonster_img();
		int lv = monster.getLv();
		int exp = monster.getExp();
		int job_exp = monster.getJob_exp();
		int max_hp = monster.getMax_hp();
		int hp = monster.getHp();
		int max_mp = monster.getMax_mp();
		int mp = monster.getMp();
		int str = monster.getStr();
		int inte = monster.getInte();
		int agi = monster.getAgi();
		int dex = monster.getDex();
		int luk = monster.getLuk();
		int vit = monster.getVit();
		dao.insert_for_battle_id(battle_id, monster_id, monster_name, monster_img, lv, exp, job_exp, max_hp, hp, max_mp,
				mp, str, inte, agi, dex, luk, vit);
		con.close();
	}

	public Battle_monsterBean select_battle_monster(int battle_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Battle_monsterDAO dao = new Battle_monsterDAO(con);
		Battle_monsterBean battle_monster = dao.select_for_battle_id(battle_id);
		con.close();
		return battle_monster;
	}

	public void update_monster_hp(int hp, int battle_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Battle_monsterDAO dao = new Battle_monsterDAO(con);
		dao.update_hp_for_battle_id(battle_id, hp);
		con.close();
	}

	public void update_monster_mp(int mp, int battle_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Battle_monsterDAO dao = new Battle_monsterDAO(con);
		dao.update_hp_for_battle_id(battle_id, mp);
		con.close();
	}

	public Battle_monsterBean battle_insert_select_monster(String battlemap_name, int char_id) throws Exception {
		if (select_battle_char_id(char_id)!=null) {
			int battle_id = select_battle_char_id(char_id).getBattle_id();
			delete_battle_monster(battle_id);
			delete_battle(char_id);
		}
		insert_battle_char_id(char_id);
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int battlemap_id = select_map_for_battlemap_name(battlemap_name).getBattlemap_id();
		MonsterBean monster = select_monster_for_mapid(battlemap_id);
		insert_battle_monster(monster, battle_id);
		Battle_monsterBean battle_monster = select_battle_monster(battle_id);
		return battle_monster;
	}

	public boolean charhit(int char_id) throws Exception {
		boolean flag = false;
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int mychar_dex = new Chars().selectChar_qBycharid(char_id).getDex();
		int monster_dex = select_battle_monster(battle_id).getDex();
		if (mychar_dex >= monster_dex) {
			flag = true;
		} else {
			int hit = (monster_dex - mychar_dex) * 5;
			int num = (int) (Math.random() * 100);
			if (num >= hit) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean monsterhit(int char_id) throws Exception {
		boolean flag = false;
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int mychar_dex = new Chars().selectChar_qBycharid(char_id).getDex();
		int monster_dex = select_battle_monster(battle_id).getDex();
		if (mychar_dex <= monster_dex) {
			flag = true;
		} else {
			int hit = (mychar_dex - monster_dex) * 5;
			int num = (int) (Math.random() * 100);
			if (num >= hit) {
				flag = true;
			}
		}
		return flag;
	}

	public void att_monster(int char_id) throws Exception {
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int str = new Chars().selectChar_qBycharid(char_id).getStr();
		int hp = select_battle_monster(battle_id).getHp();
		if (hp - str <= 0) {
			hp = 0;
		} else {
			hp -= str;
		}
		update_monster_hp(hp, battle_id);
	}

	public void att_mychar(int char_id) throws Exception {
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int str = select_battle_monster(battle_id).getStr();
		int hp = new Chars().selectChar_qBycharid(char_id).getHp();
		if (hp - str <= 0) {
			hp = 0;
		} else {
			hp -= str;
		}
		new Chars().update_Char_q_hp(char_id, hp);
	}

	public String att(int char_id) throws Exception {
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int mychar_agi = new Chars().selectChar_qBycharid(char_id).getAgi();
		int monster_agi = select_battle_monster(battle_id).getAgi();
		int monster_hp = select_battle_monster(battle_id).getHp();
		String msg = "";
		if(monster_hp!=0) {
		if (mychar_agi >= monster_agi) {
			if (charhit(char_id))
				att_monster(char_id);
			if (select_battle_monster(battle_id).getHp() == 0) {
				msg = battle_end_monster_die(char_id);
			} else {
				if (monsterhit(char_id))
					att_mychar(char_id);
			}
		}}
		else {
			msg="<form method=\"post\" action=\"/MyGame/Backhome\"><input  class=\"btn btn-outline-secondary\" type=\"submit\" value=\"回主畫面\"> </form>";
		}
		return msg;
	}

	public String battle_end_monster_die(int char_id) throws Exception {
		Chars charsfun = new Chars();
		CharsBean mychar = charsfun.select_CharsBycharID(char_id);
		Chars_qualityBean mychar_q = charsfun.selectChar_qBycharid(char_id);
		int battle_id = select_battle_char_id(char_id).getBattle_id();
		int exp = select_battle_monster(battle_id).getExp();
		int job_exp = select_battle_monster(battle_id).getJob_exp();
		int money = (int) (Math.random() * 1000 + 1);
		charsfun.update_char_money(mychar.getMoney() + money, char_id);
		charsfun.update_Char_q_exp(char_id, mychar_q.getExp() + exp);
		charsfun.update_Char_q_job_exp(char_id, mychar_q.getJob_exp() + job_exp);
		return "<p>獲得經驗值：" + exp + "<p>獲得職業經驗值：" + job_exp + "<p> 獲得金幣：" + money
				+ "<p><form method=\"post\" action=\"/MyGame/Backhome\"><input  class=\"btn btn-outline-secondary\" type=\"submit\" value=\"回主畫面\"> </form>";
	}

}
