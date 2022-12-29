package model.service;

import java.sql.Connection;
import java.util.List;

import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.bean.chars.Skill_BagBean;
import model.bean.community.SkillBean;
import model.dao.chars.Skill_BagDAO;
import model.dao.community.SkillDAO;

public class Skill {
	public List<SkillBean> select_skillList_by_job_id(int job_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		SkillDAO dao = new SkillDAO(con);
		List<SkillBean> skills = dao.select_skill_by_job_id(job_id);
		con.close();
		return skills;
	}
	public List<SkillBean> select_skillList_by_char_id_charbag(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		SkillDAO dao = new SkillDAO(con);
		List<SkillBean> skills = dao.select_skill_for_join_char_id(char_id);
		con.close();
		return skills;
	}

	public void insert_skill_char_id(int skill_id, int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Skill_BagDAO dao = new Skill_BagDAO(con);
		dao.insert_skill_char_id(char_id, skill_id);
		con.close();
	}

	public List<SkillBean> select_skillList_by_char_id(int char_id) throws Exception {
		Chars charfun = new Chars();
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		List<SkillBean> skills = select_skillList_by_job_id(mychar.getJob_id());
		return skills;
	}

	public SkillBean select_skill_by_skill_id(int skill_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		SkillDAO dao = new SkillDAO(con);
		SkillBean skill = dao.select_skill_by_skill_id(skill_id);
		con.close();
		return skill;
	}

	public Skill_BagBean select_skill_by_char_id_skill_id(int char_id, int skill_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		Skill_BagDAO dao = new Skill_BagDAO(con);
		Skill_BagBean myskill = dao.select_char_id_skill_id(char_id, skill_id);
		con.close();
		return myskill;
	}

	public boolean has_skill(int char_id, int skill_id) throws Exception {
		boolean flag = false;
		if (select_skill_by_char_id_skill_id(char_id, skill_id) != null) {
			flag = true;
		}
		return flag;
	}

	public String study_skill(int char_id, int skill_id) throws Exception {
		String msg = "";
		Chars charfun = new Chars();
		Chars_qualityBean mychar_q = charfun.selectChar_qBycharid(char_id);
		int job_lv = mychar_q.getJob_lv();
		int need_job_lv = select_skill_by_skill_id(skill_id).getNeed_job_lv();
		if (job_lv < need_job_lv) {
			msg = "你的職業等級不足，無法學習該技能。";
		} else if (has_skill(char_id, skill_id)) {
			msg += "你已經學習過這個技能了。";
		} else {
			insert_skill_char_id(skill_id, char_id);
			String skill_name = select_skill_by_skill_id(skill_id).getSkill_name();
			msg = "學習了" + skill_name + "技能。";
		}
		return msg;
	}
}
