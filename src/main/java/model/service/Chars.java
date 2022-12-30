package model.service;

import java.sql.Connection;
import java.util.Base64;
import java.util.List;
import javax.management.RuntimeErrorException;
import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.dao.chars.CharsDAO;
import model.dao.chars.Chars_qualityDAO;

public class Chars {
	public List<CharsBean> select_CharsByUID(int uid) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		List<CharsBean> mychars = null;
		mychars = dao.selectAllbyuid(uid);

		con.close();
		return mychars;
	}

	public CharsBean select_CharsBycharID(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsBean mychar = null;
		CharsDAO dao = new CharsDAO(con);
		mychar = dao.selectBycharid(char_id);
		con.close();
		return mychar;
	}

	public void insert_Chars(String char_name, byte[] b, int uid) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		String img_base64 = "data:image/jpeg;base64,";
		if (dao.selectAllbyuid(uid).size() < 3) {
//			@SuppressWarnings("resource")
//			byte[] bytes = new BufferedInputStream(new FileInputStream(img)).readAllBytes();
			img_base64 += Base64.getEncoder().encodeToString(b);
			dao.insertChars(uid, char_name, img_base64);
			int char_id = dao.selectBy_char_name(char_name, uid).getChar_id();
			insert_Char_q(char_id);
			new Item().insert_item_bag(3, char_id);
		} else {
			throw new RuntimeErrorException(null);
		}
		con.close();
	}

	public void delete_Chars(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		dao.delectChars(char_id);
		con.close();
	}

	public Chars_qualityBean selectChar_qBycharid(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		Chars_qualityBean mychar_q = dao.selectByChar_id(char_id);
		con.close();
		return mychar_q;
	}

	public void insert_Char_q(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		int lv = 1;
		int job_lv = 1;
		int exp = 0;
		int job_exp = 0;
		int max_hp = 50;
		int hp = 50;
		int max_mp = 50;
		int mp = 50;
		int str = 10;
		int inte = 10;
		int dex = 10;
		int agi = 10;
		int luk = 10;
		int vit = 10;
		int points = 0;
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.insert_Char_q(char_id, lv, job_lv, exp, job_exp, max_hp, hp, max_mp, mp, str, inte, dex, agi, luk, vit,
				points);
		con.close();
	}

	public void update_Char_q_lv(int char_id, int lv) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int nowlv = mychar_q.getLv();
		int nowpoint = mychar_q.getPoints();
		int uplv = lv - nowlv;
		if (lv >= 100) {
			lv = 100;
		}
		int lvup_point = nowpoint + (uplv * 6);
		if (!(lv >= 100)) {
			update_Char_q_points(char_id, lvup_point);
			dao.update_Char_q_lv(lv, char_id);
			mychar_q = selectChar_qBycharid(char_id);
			int max_hp = mychar_q.getMax_hp();
			int max_mp = mychar_q.getMax_mp();
			update_Char_q_hp(char_id, max_hp);
			update_Char_q_max_mp(char_id, max_mp);
		}
		con.close();
	}

	public void update_Char_q_job_lv(int char_id, int job_lv) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		if (job_lv > 30) {
			job_lv = 30;
		}
		dao.update_Char_q_job_lv(job_lv, char_id);
		con.close();
	}

	public void update_Char_job(int char_id, int job_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);

		dao.updateChars_job_id(job_id, char_id);
		con.close();
	}

	public void update_Char_q_exp(int char_id, int exp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int lv = selectChar_qBycharid(char_id).getLv();
		for (;;) {
			if (exp >= 100) {
				if (lv >= 100) {
					lv = 100;
					break;
				}
				exp = exp - 100;
				if (exp < 0) {
					exp = 0;
				}
				lv++;
			}
			if (lv >= 100) {
				lv = 100;
				break;
			}
			if (exp < 100) {
				break;
			}
		}
		if (lv != selectChar_qBycharid(char_id).getLv()) {
			update_Char_q_lv(char_id, lv);
		}
		dao.update_Char_q_exp(exp, char_id);
		con.close();
	}

	public void update_Char_q_job_exp(int char_id, int job_exp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int job_lv = selectChar_qBycharid(char_id).getJob_lv();
		for (;;) {
			if (job_exp >= 100) {
				job_exp = job_exp - 100;
				job_lv++;
			}
			if (job_exp < 100) {
				break;
			}
		}
		update_Char_q_job_lv(char_id, job_lv);
		dao.update_Char_q_job_exp(job_exp, char_id);
		con.close();

	}

	public void update_Char_q_max_hp(int char_id, int max_hp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int hp = selectChar_qBycharid(char_id).getHp();
		if (hp > max_hp) {
			hp = max_hp;
		}
		update_Char_q_hp(char_id, hp);
		dao.update_Char_q_max_hp(max_hp, char_id);
		con.close();
	}

	public void update_Char_q_hp(int char_id, int hp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int max_hp = selectChar_qBycharid(char_id).getMax_hp();
		if (hp >= max_hp) {
			hp = max_hp;
		}
		if (hp <= 0) {
			hp = 0;
		}
		dao.update_Char_q_hp(hp, char_id);
		con.close();
	}

	public void update_Char_q_max_mp(int char_id, int max_mp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int mp = selectChar_qBycharid(char_id).getMp();
		if (mp >= max_mp) {
			mp = max_mp;
		}
		if (mp <= 0) {
			mp = 0;
		}
		update_Char_q_mp(char_id, mp);
		dao.update_Char_q_max_mp(max_mp, char_id);
		con.close();
	}

	public void update_Char_q_mp(int char_id, int mp) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		int max_mp = selectChar_qBycharid(char_id).getMax_mp();
		if (mp >= max_mp) {
			mp = max_mp;
		}
		if (mp <= 0) {
			mp = 0;
		}
		dao.update_Char_q_mp(mp, char_id);
		con.close();
	}

	public void update_Char_q_str(int char_id, int str) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.update_Char_q_str(str, char_id);
		con.close();
	}

	public void update_Char_q_inte(int char_id, int inte) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int nowinte = mychar_q.getInte();
		int now_max_mp = mychar_q.getMax_mp();
		int upinte = inte - nowinte;
		int upmp = now_max_mp + (upinte * 5);
		update_Char_q_max_mp(char_id, upmp);
		dao.update_Char_q_inte(inte, char_id);
		con.close();
	}

	public void update_Char_q_dex(int char_id, int dex) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.update_Char_q_dex(dex, char_id);
		con.close();
	}

	public void update_Char_q_agi(int char_id, int agi) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.update_Char_q_agi(agi, char_id);
		con.close();
	}

	public void update_Char_q_luk(int char_id, int luk) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.update_Char_q_luk(luk, char_id);
		con.close();
	}

	public void update_Char_q_vit(int char_id, int vit) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int nowvit = mychar_q.getVit();
		int now_max_hp = mychar_q.getMax_hp();
		int upvit = vit - nowvit;
		int uphp = (now_max_hp + (upvit * 5));
		update_Char_q_max_hp(char_id, uphp);
		dao.update_Char_q_vit(vit, char_id);
		con.close();
	}

	public void update_Char_q_points(int char_id, int points) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Chars_qualityDAO dao = new Chars_qualityDAO(con);
		dao.update_Char_q_points(points, char_id);
		con.close();
	}

	public void update_Char_q_all(int char_id, int lv, int job_lv, int exp, int job_exp, int max_hp, int hp, int max_mp,
			int mp, int str, int inte, int dex, int agi, int luk, int vit, int points) throws Exception {
		update_Char_q_agi(char_id, agi);
		update_Char_q_dex(char_id, dex);
		update_Char_q_exp(char_id, exp);
		update_Char_q_inte(char_id, inte);
		update_Char_q_job_exp(char_id, job_exp);
		update_Char_q_job_lv(char_id, job_lv);
		update_Char_q_luk(char_id, luk);
		update_Char_q_max_hp(char_id, max_hp);
		update_Char_q_max_mp(char_id, max_mp);
		update_Char_q_mp(char_id, mp);
		update_Char_q_str(char_id, str);
		update_Char_q_vit(char_id, vit);
		update_Char_q_points(char_id, points);
		update_Char_q_hp(char_id, hp);
		update_Char_q_lv(char_id, lv);

	}

	public void update_char_money(int money, int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		CharsDAO dao = new CharsDAO(con);
		if (money <= 0) {
			money = 0;
		}
		dao.updateChars_money(money, char_id);
		con.close();
	}

	public String rest(int char_id) throws Exception {
		String text;
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		CharsBean mychar = select_CharsBycharID(char_id);
		int money = mychar.getMoney();
		int max_hp = mychar_q.getMax_hp();
		int max_mp = mychar_q.getMax_mp();
		update_Char_q_mp(char_id, max_mp);
		update_Char_q_hp(char_id, max_hp);
		if (money <= 1000) {
			text = "你太窮了，旅店老闆讓你免費休息。";
		} else {
			money = money - 1000;
			update_char_money(money, char_id);
			text = "你付款一千元，HP和MP都恢復完成了。";
		}
		return text;
	}

	public void update_froP_str(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int str = mychar_q.getStr();
		points -= addpoints;
		str += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_str(char_id, str);
	}

	public void update_froP_agi(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int agi = mychar_q.getAgi();
		points -= addpoints;
		agi += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_agi(char_id, agi);
	}

	public void update_froP_luk(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int luk = mychar_q.getLuk();
		points -= addpoints;
		luk += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_luk(char_id, luk);
	}

	public void update_froP_dex(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int dex = mychar_q.getDex();
		points -= addpoints;
		dex += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_dex(char_id, dex);
	}

	public void update_froP_vit(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int vit = mychar_q.getVit();
		points -= addpoints;
		vit += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_vit(char_id, vit);
	}

	public void update_froP_inte(int addpoints, int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = mychar_q.getPoints();
		int inte = mychar_q.getInte();
		points -= addpoints;
		inte += addpoints;
		update_Char_q_points(char_id, points);
		update_Char_q_inte(char_id, inte);
	}

	public void update_forP_All(int add_str, int add_inte, int add_dex, int add_agi, int add_luk, int add_vit,
			int char_id) throws Exception {
		Chars_qualityBean mychar_q = selectChar_qBycharid(char_id);
		int points = add_agi + add_dex + add_inte + add_luk + add_str + add_vit;
		if (points > mychar_q.getPoints()) {
			throw new RuntimeErrorException(null);
		}
		update_froP_agi(add_agi, char_id);
		update_froP_dex(add_dex, char_id);
		update_froP_inte(add_inte, char_id);
		update_froP_luk(add_luk, char_id);
		update_froP_str(add_str, char_id);
		update_froP_vit(add_vit, char_id);
	}

}
