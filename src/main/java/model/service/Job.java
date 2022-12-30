package model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.MyConnection;
import model.bean.chars.CharsBean;
import model.bean.chars.Chars_qualityBean;
import model.bean.community.JobBean;
import model.dao.community.JobDAO;

public class Job {
	public JobBean selecet_job_for_job_id(int job_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		JobDAO dao = new JobDAO(con);
		JobBean job = dao.select_for_job_id(job_id);
		con.close();
		return job;
	}

	public JobBean selecet_job_for_char_id(int char_id) throws Exception {
		Chars charfun = new Chars();
		CharsBean mychar = charfun.select_CharsBycharID(char_id);
		JobBean job = selecet_job_for_job_id(mychar.getJob_id());
		return job;
	}

	public List<JobBean> select_by_job_lavel(int job_lavel) throws Exception {
		Connection con = MyConnection.getMyConnection();
		JobDAO dao = new JobDAO(con);
		List<JobBean> jobs = dao.select_list_for_job_lavel(job_lavel);
		con.close();
		return jobs;
	}

	public List<JobBean> select_by_job_lavel_job_type_id(int job_lavel, int job_type_id) throws Exception {
		Connection con = MyConnection.getMyConnection();
		JobDAO dao = new JobDAO(con);
		List<JobBean> jobs = dao.select_list_for_job_type_id_job_lavel(job_type_id, job_lavel);
		con.close();
		return jobs;
	}

	public List<JobBean> select_for_jobLise_by_char_id(int char_id) throws Exception {
		List<JobBean> jobs = new ArrayList<JobBean>();
		JobBean myjob = selecet_job_for_char_id(char_id);
		int job_lavel = myjob.getJob_lavel();
		int job_type_id = myjob.getJob_type_id();
		if (job_lavel == 0) {
			jobs = select_by_job_lavel(1);
		} else {
			jobs = select_by_job_lavel_job_type_id(job_lavel + 1, job_type_id);
		}
		return jobs;
	}

	public String changjob(int char_id, int job_id) throws Exception {
		String msg = "";
		Chars charfun = new Chars();
		Chars_qualityBean mychar_q = charfun.selectChar_qBycharid(char_id);
		int job_lv = mychar_q.getJob_lv();
		String job_name = selecet_job_for_job_id(job_id).getJob_name();
		int myjob_id = charfun.select_CharsBycharID(char_id).getJob_id();
		int job_lavel = selecet_job_for_job_id(myjob_id).getJob_lavel();
		System.out.println(job_lavel);
		if (job_lavel == 0 &&job_lv >=10) {
			charfun.update_Char_job(char_id, job_id);
			msg = "成功轉職為" + job_name + "。";
		} else if (job_lv < 30) {
			msg = "職業等級未滿30，無法轉職。";
		} else {
			charfun.update_Char_job(char_id, job_id);
			msg = "成功轉職為" + job_name + "。";
		}
		return msg;
	}
}
