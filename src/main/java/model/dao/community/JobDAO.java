package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.community.JobBean;

public class JobDAO {
	Connection con;

	public JobDAO(Connection con) {
		this.con = con;
	}

	public void insert_Job(String job_name, int job_laval, int job_type_id) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[job]([job_name],[job_lavel],[job_type_id]) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, job_name);
		ps.setInt(2, job_laval);
		ps.setInt(3, job_type_id);
		ps.executeUpdate();
	}

	public JobBean select_for_job_id(int job_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[job] as a inner join [MyGame].[dbo].[job_type] as b on a.job_type_id = b.job_type_id where a.job_id = ?";
		JobBean job = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, job_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			job_id = rs.getInt("job_id");
			String job_name = rs.getString("job_name").trim();
			int job_lavel = rs.getInt("job_lavel");
			int job_type_id = rs.getInt("job_type_id");
			String job_type_name = rs.getString("job_type_name").trim();
			job = new JobBean(job_id, job_name, job_lavel, job_type_id, job_type_name);
		}
		return job;
	}

	public List<JobBean> select_all() throws SQLException {
		String sql = "select * from [MyGame].[dbo].[job] as a inner join [MyGame].[dbo].[job_type] as b on a.job_type_id = b.job_type_id";
		List<JobBean> jobs = new ArrayList<JobBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int job_id = rs.getInt("job_id");
			String job_name = rs.getString("job_name").trim();
			int job_lavel = rs.getInt("job_lavel");
			int job_type_id = rs.getInt("job_type_id");
			String job_type_name = rs.getString("job_type_name").trim();
			JobBean job = new JobBean(job_id, job_name, job_lavel, job_type_id, job_type_name);
			jobs.add(job);
		}
		return jobs;
	}

	public List<JobBean> select_for_job_type_id(int job_type_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[job] as a inner join [MyGame].[dbo].[job_type] as b on a.job_type_id = b.job_type_id where a.job_type_id = ?";
		List<JobBean> jobs = new ArrayList<JobBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, job_type_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int job_id = rs.getInt("job_id");
			String job_name = rs.getString("job_name").trim();
			int job_lavel = rs.getInt("job_lavel");
			job_type_id = rs.getInt("job_type_id");
			String job_type_name = rs.getString("job_type_name").trim();
			JobBean job = new JobBean(job_id, job_name, job_lavel, job_type_id, job_type_name);
			jobs.add(job);
		}
		return jobs;
	}
}
