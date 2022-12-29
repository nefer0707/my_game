package model.service;

import java.sql.Connection;
import java.util.List;

import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.community.SkillBean;
import model.dao.community.SkillDAO;

public class Skill {
	public List<SkillBean> select_skillList_by_job_id(int job_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		SkillDAO dao = new SkillDAO(con);
		List<SkillBean> skills = dao.select_skill_by_job_id(job_id);
		con.close();
		return skills;
	}

	public List<SkillBean> select_skillList_by_char_id(int char_id) throws Exception {
		Chars charfun = new Chars();
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		List<SkillBean> skills = select_skillList_by_job_id(mychar.getJob_id());
		return skills;
	}
}
