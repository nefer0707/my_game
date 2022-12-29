package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.community.SkillBean;

public class SkillDAO {
	Connection con;

	public SkillDAO(Connection con) {
		this.con = con;
	}

	public List<SkillBean> select_skill_by_job_id(int job_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[Skill] as a inner join [MyGame].[dbo].[Skill_type] as b on a.skill_type_id = b.skill_type_id where a.job_id = ?";
		List<SkillBean> skills =new ArrayList<SkillBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, job_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int skill_id=rs.getInt("skill_id");
			String skill_name=rs.getString("skill_name");
			String caption=rs.getString("caption");
			int skill_type_id=rs.getInt("skill_type_id");
			int power=rs.getInt("power");
			job_id=rs.getInt("job_id");
			int need_job_lv=rs.getInt("need_job_lv");
			int mp=rs.getInt("mp");
			String skill_type_name=rs.getString("skill_type_name");
			SkillBean skill = new SkillBean(skill_id, skill_name, caption, skill_type_id, power, job_id, need_job_lv, skill_type_name, mp);
			skills.add(skill);
		}
		rs.close();
		ps.close();
		return skills;
	}
	public List<SkillBean> select_skill_for_join_char_id(int char_id) throws SQLException {
		String sql = "select * from ([MyGame].[dbo].[Skill] as a inner join [MyGame].[dbo].[Skill_type] as b on a.skill_type_id = b.skill_type_id) inner join [MyGame].[dbo].[Skill_bag] as c on a.skill_id = c.skill_id where c.char_id = ?";
		List<SkillBean> skills =new ArrayList<SkillBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, char_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int skill_id=rs.getInt("skill_id");
			String skill_name=rs.getString("skill_name");
			String caption=rs.getString("caption");
			int skill_type_id=rs.getInt("skill_type_id");
			int power=rs.getInt("power");
			int job_id=rs.getInt("job_id");
			int need_job_lv=rs.getInt("need_job_lv");
			int mp=rs.getInt("mp");
			String skill_type_name=rs.getString("skill_type_name");
			SkillBean skill = new SkillBean(skill_id, skill_name, caption, skill_type_id, power, job_id, need_job_lv, skill_type_name, mp);
			skills.add(skill);
		}
		rs.close();
		ps.close();
		return skills;
	}
	public SkillBean select_skill_by_skill_id(int skill_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[Skill] as a inner join [MyGame].[dbo].[Skill_type] as b on a.skill_type_id = b.skill_type_id where a.skill_id = ?";
		SkillBean skill =null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, skill_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			skill_id=rs.getInt("skill_id");
			String skill_name=rs.getString("skill_name");
			String caption=rs.getString("caption");
			int skill_type_id=rs.getInt("skill_type_id");
			int power=rs.getInt("power");
			int job_id=rs.getInt("job_id");
			int need_job_lv=rs.getInt("need_job_lv");
			int mp=rs.getInt("mp");
			String skill_type_name=rs.getString("skill_type_name");
			skill = new SkillBean(skill_id, skill_name, caption, skill_type_id, power, job_id, need_job_lv, skill_type_name, mp);

		}
		rs.close();
		ps.close();
		return skill;
	}
}