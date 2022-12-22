package model.service;

import java.sql.Connection;
import java.util.List;
import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.bean.chars.EquipmentBean;
import model.bean.chars.Item_BagBean;
import model.bean.community.ItemBean;
import model.dao.chars.EquipmentDAO;
import model.dao.chars.Item_BagDAO;
import model.dao.community.ItemDAO;

public class Item {
	public Item_BagBean select_item_bag(int char_id, int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Item_BagDAO dao = new Item_BagDAO(con);
		Item_BagBean myitem = dao.select_item_bag(char_id, item_id);
		con.close();
		return myitem;
	}

	public List<Item_BagBean> select_item_bag_all(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Item_BagDAO dao = new Item_BagDAO(con);
		List<Item_BagBean> myitems = dao.select_item_bag_all(char_id);
		con.close();
		return myitems;
	}

	public EquipmentBean select_equipment(int char_id, int item_type_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		EquipmentBean myequipment = dao.select_Equipment(char_id, item_type_id);
		con.close();
		return myequipment;
	}

	public void update_equipment(int char_id, int new_item_id, int old_item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		dao.update_Equipment(char_id, new_item_id, old_item_id);
		con.close();
	}

	public void insert_equipment(int char_id, int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		dao.insert_Equipment(char_id, item_id);
		con.close();
	}

	public List<EquipmentBean> select_equipment_all(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		List<EquipmentBean> myequipments = dao.select_Equipment_all(char_id);
		con.close();
		return myequipments;
	}

	public boolean have_arms(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		int item_type_id = 2;
		EquipmentBean myarms = dao.select_Equipment(char_id, item_type_id);
		con.close();
		return myarms != null;
	}

	public boolean have_armor(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		int item_type_id = 1;
		EquipmentBean myarmor = dao.select_Equipment(char_id, item_type_id);
		con.close();
		return myarmor != null;
	}

	public boolean is_arms(int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		ItemDAO dao = new ItemDAO(con);
		ItemBean item = dao.select_item(item_id);
		if (item.getItem_type_id() == 2) {
			System.out.println("此為武器。");
			con.close();
			return true;
		}
		con.close();
		return false;
	}

	public boolean is_armor(int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		ItemDAO dao = new ItemDAO(con);
		ItemBean item = dao.select_item(item_id);
		if (item.getItem_type_id() == 1) {
			System.out.println("此為防具。");
			con.close();
			return true;
		}
		con.close();
		return false;
	}

	public boolean is_supplies(int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		ItemDAO dao = new ItemDAO(con);
		ItemBean item = dao.select_item(item_id);
		if (item.getItem_type_id() == 3) {
			con.close();
			return true;
		}
		con.close();
		return false;
	}

	public ItemBean select_item_item_id(int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		ItemDAO dao = new ItemDAO(con);
		ItemBean item = dao.select_item(item_id);
		con.close();
		return item;
	}
	public void delete_equipment(int item_id,int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		EquipmentDAO dao = new EquipmentDAO(con);
		dao.delete_Equipment(char_id, item_id);
		con.close();
	}


	public void update_item_bag_count(int item_id, int char_id, int count) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Item_BagDAO dao = new Item_BagDAO(con);
		dao.update_item_bag(char_id, item_id, count);
		con.close();
	}

	public void insert_item_bag(int item_id, int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Item_BagDAO dao = new Item_BagDAO(con);
		dao.insert_item_bag(char_id, item_id, 1);
		con.close();
	}

	public void delete_item_bag(int char_id, int item_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Item_BagDAO dao = new Item_BagDAO(con);
		dao.delete_item_bag(char_id, item_id);
		con.close();
	}

	public void use_supplies(int item_id, int char_id) throws Exception {
		if (is_supplies(item_id)) {
			Item_BagBean item = select_item_bag(char_id, item_id);
			use_or_equipment(item_id, char_id);
			if (item.getCount() > 1) {
				update_item_bag_count(item_id, char_id, item.getCount() - 1);
			} else {
				delete_item_bag(char_id, item_id);
			}
		}
	}

	public void use_arms(int item_id, int char_id) throws Exception {
		if (is_arms(item_id)) {
			Item_BagBean item = select_item_bag(char_id, item_id);
			use_or_equipment(item_id, char_id);
			if (item.getCount() > 1) {
				update_item_bag_count(item_id, char_id, item.getCount() - 1);
			} else {
				delete_item_bag(char_id, item_id);
			}
			if (have_arms(char_id)) {
				EquipmentBean equipment = select_equipment(char_id, item.getItem_type_id());
				update_equipment(char_id, item_id, equipment.getItem_id());
				take_off_equipment(equipment.getItem_id(), char_id);
				Item_BagBean olditem = select_item_bag(char_id, equipment.getItem_id());
				if (olditem != null) {
					update_item_bag_count(equipment.getItem_id(), char_id, olditem.getCount() + 1);
				} else {
					insert_item_bag(equipment.getItem_id(), char_id);
				}
			} else {
				insert_equipment(char_id, item_id);
			}
		}
	}

	public void use_armor(int item_id, int char_id) throws Exception {
		if (is_armor(item_id)) {
			Item_BagBean item = select_item_bag(char_id, item_id);
			use_or_equipment(item_id, char_id);
			if (item.getCount() > 1) {
				update_item_bag_count(item_id, char_id, item.getCount() - 1);
			} else {
				delete_item_bag(char_id, item_id);
			}
			if (have_armor(char_id)) {
				EquipmentBean equipment = select_equipment(char_id, item.getItem_type_id());
				update_equipment(char_id, item_id, equipment.getItem_id());
				take_off_equipment(equipment.getItem_id(), char_id);
				Item_BagBean olditem = select_item_bag(char_id, equipment.getItem_id());
				if (olditem != null) {
					update_item_bag_count(equipment.getItem_id(), char_id, olditem.getCount() + 1);
				} else {
					insert_item_bag(equipment.getItem_id(), char_id);
				}
			} else {
				insert_equipment(char_id, item_id);
			}
		}
	}

	public void take_off_equipment_f(int item_id, int char_id) throws Exception {
		Item_BagBean myitem = select_item_bag(char_id, item_id);
		take_off_equipment(item_id, char_id);
		delete_equipment(item_id, char_id);
		if (myitem == null) {
			insert_item_bag(item_id, char_id);
		} else {
			update_item_bag_count(item_id, char_id, myitem.getCount()+1);
		}
	}

	public void take_off_equipment(int item_id, int char_id) throws Exception {
		Chars charfun = new Chars();
		ItemBean item = select_item_item_id(item_id);
		Chars_qualityBean mychar_q = charfun.selectChar_qBycharid(char_id);
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		if (item.getAdd_agi() != 0) {
			int agi = mychar_q.getAgi() - item.getAdd_agi();
			charfun.update_Char_q_agi(char_id, agi);
		}
		if (item.getAdd_dex() != 0) {
			int dex = mychar_q.getDex() - item.getAdd_dex();
			charfun.update_Char_q_dex(char_id, dex);
		}
		if (item.getAdd_exp() != 0) {
			int exp = mychar_q.getExp() - item.getAdd_exp();
			charfun.update_Char_q_exp(char_id, exp);
		}
		if (item.getAdd_hp() != 0) {
			int hp = mychar_q.getHp() - item.getAdd_hp();
			charfun.update_Char_q_hp(char_id, hp);
		}
		if (item.getAdd_inte() != 0) {
			int inte = mychar_q.getInte() - item.getAdd_inte();
			charfun.update_Char_q_inte(char_id, inte);
		}
		if (item.getAdd_job_exp() != 0) {
			int job_exp = mychar_q.getJob_exp() - item.getAdd_job_exp();
			charfun.update_Char_q_job_exp(char_id, job_exp);
		}
		if (item.getAdd_luk() != 0) {
			int luk = mychar_q.getLuk() - item.getAdd_luk();
			charfun.update_Char_q_luk(char_id, luk);
		}
		if (item.getAdd_max_hp() != 0) {
			int max_hp = mychar_q.getMax_hp() - item.getAdd_max_hp();
			charfun.update_Char_q_max_hp(char_id, max_hp);
		}
		if (item.getAdd_max_mp() != 0) {
			int max_mp = mychar_q.getMax_mp() - item.getAdd_max_mp();
			charfun.update_Char_q_max_mp(char_id, max_mp);
		}
		if (item.getAdd_money() != 0) {
			int money = mychar.getMoney() - item.getAdd_money();
			charfun.update_char_money(char_id, money);
		}
		if (item.getAdd_mp() != 0) {
			int mp = mychar_q.getMp() - item.getAdd_max_mp();
			charfun.update_Char_q_mp(char_id, mp);
		}
		if (item.getAdd_points() != 0) {
			int points = mychar_q.getPoints() - item.getAdd_points();
			charfun.update_Char_q_points(char_id, points);
		}
		if (item.getAdd_str() != 0) {
			int str = mychar_q.getStr() - item.getAdd_str();
			charfun.update_Char_q_str(char_id, str);
		}
		if (item.getAdd_vit() != 0) {
			int vit = mychar_q.getVit() - item.getAdd_vit();
			charfun.update_Char_q_vit(char_id, vit);
		}
		if (item.getAdd_lv() != 0) {
			int lv = mychar_q.getLv() - item.getAdd_lv();
			charfun.update_Char_q_lv(char_id, lv);
		}
		if (item.getAdd_job_lv() != 0) {
			int job_lv = mychar_q.getJob_lv() - item.getAdd_job_lv();
			charfun.update_Char_q_job_lv(char_id, job_lv);
		}
//		charfun.update_Char_q_all(char_id, lv, job_lv, exp, job_exp, max_hp, hp, max_mp, mp, str, inte, dex, agi, luk,
//				vit, points);
//		charfun.update_char_money(money, char_id);
	}

	public void use_or_equipment(int item_id, int char_id) throws Exception {
		Chars charfun = new Chars();
		ItemBean item = select_item_item_id(item_id);
		Chars_qualityBean mychar_q = charfun.selectChar_qBycharid(char_id);
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		if (item.getAdd_agi() != 0) {
			int agi = item.getAdd_agi() + mychar_q.getAgi();
			charfun.update_Char_q_agi(char_id, agi);
		}
		if (item.getAdd_dex() != 0) {
			int dex = item.getAdd_dex() + mychar_q.getDex();
			charfun.update_Char_q_dex(char_id, dex);
		}
		if (item.getAdd_exp() != 0) {
			int exp = item.getAdd_exp() + mychar_q.getExp();
			charfun.update_Char_q_exp(char_id, exp);
		}
		if (item.getAdd_hp() != 0) {
			int hp = item.getAdd_hp() + mychar_q.getHp();
			charfun.update_Char_q_hp(char_id, hp);
		}
		if (item.getAdd_inte() != 0) {
			int inte = item.getAdd_inte() + mychar_q.getInte();
			charfun.update_Char_q_inte(char_id, inte);
		}
		if (item.getAdd_job_exp() != 0) {
			int job_exp = item.getAdd_job_exp() + mychar_q.getJob_exp();
			charfun.update_Char_q_job_exp(char_id, job_exp);
		}
		if (item.getAdd_luk() != 0) {
			int luk = item.getAdd_luk() + mychar_q.getLuk();
			charfun.update_Char_q_luk(char_id, luk);
		}
		if (item.getAdd_max_hp() != 0) {
			int max_hp = item.getAdd_max_hp() + mychar_q.getMax_hp();
			charfun.update_Char_q_max_hp(char_id, max_hp);
		}
		if (item.getAdd_max_mp() != 0) {
			int max_mp = item.getAdd_max_mp() + mychar_q.getMax_mp();
			charfun.update_Char_q_max_mp(char_id, max_mp);
		}
		if (item.getAdd_money() != 0) {
			int money = item.getAdd_money() + mychar.getMoney();
			charfun.update_char_money(money, char_id);
			;
		}
		if (item.getAdd_mp() != 0) {
			int mp = item.getAdd_mp() + mychar_q.getMp();
			charfun.update_Char_q_mp(char_id, mp);
		}
		if (item.getAdd_points() != 0) {
			int points = item.getAdd_points() + mychar_q.getPoints();
			charfun.update_Char_q_points(char_id, points);
		}
		if (item.getAdd_str() != 0) {
			int str = item.getAdd_str() + mychar_q.getStr();
			charfun.update_Char_q_str(char_id, str);
		}
		if (item.getAdd_vit() != 0) {
			int vit = item.getAdd_vit() + mychar_q.getVit();
			charfun.update_Char_q_vit(char_id, vit);
		}
		if (item.getAdd_lv() != 0) {
			int lv = item.getAdd_lv() + mychar_q.getLv();
			charfun.update_Char_q_lv(char_id, lv);
		}
		if (item.getAdd_job_lv() != 0) {
			int job_lv = item.getAdd_job_lv() + mychar_q.getJob_lv();
			charfun.update_Char_q_job_lv(char_id, job_lv);
		}
//		charfun.update_Char_q_all(char_id, lv, job_lv, exp, job_exp, max_hp, hp, max_mp, mp, str, inte, dex, agi, luk,
//				vit, points);
//		charfun.update_char_money(money, char_id);

	}

}
