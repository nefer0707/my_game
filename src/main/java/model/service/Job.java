package model.service;

import java.sql.Connection;

import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.community.JobBean;
import model.dao.community.JobDAO;

public class Job {
	public JobBean selecet_job_for_char_id(int char_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		JobBean job = null;
		Chars charfun = new Chars();
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		JobDAO dao = new JobDAO(con);
		job = dao.select_for_job_id(mychar.getJob_id());
		con.close();
		return job;
	}
}
