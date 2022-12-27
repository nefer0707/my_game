package model.bean.community;

public class SkillBean {
	private int skill_id;
	private String skill_name;
	private String caption;
	private int skill_type_id;
	private int power;
	private int job_id;
	private int need_job_lv;
	private int mp;
	private String skill_type_name;
	public SkillBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillBean(int skill_id, String skill_name, String caption, int skill_type_id, int power, int job_id,
			int need_job_lv, String skill_type_name,int mp) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.caption = caption;
		this.skill_type_id = skill_type_id;
		this.power = power;
		this.job_id = job_id;
		this.need_job_lv = need_job_lv;
		this.skill_type_name = skill_type_name;
		this.mp = mp;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getSkill_type_id() {
		return skill_type_id;
	}
	public void setSkill_type_id(int skill_type_id) {
		this.skill_type_id = skill_type_id;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getNeed_job_lv() {
		return need_job_lv;
	}
	public void setNeed_job_lv(int need_job_lv) {
		this.need_job_lv = need_job_lv;
	}
	public String getSkill_type_name() {
		return skill_type_name;
	}
	public void setSkill_type_name(String skill_type_name) {
		this.skill_type_name = skill_type_name;
	}
	
}
