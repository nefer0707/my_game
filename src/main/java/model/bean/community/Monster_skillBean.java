package model.bean.community;

public class Monster_skillBean {
	private int skill_id;
	private int monster_id;
	public Monster_skillBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Monster_skillBean(int skill_id, int monster_id) {
		super();
		this.skill_id = skill_id;
		this.monster_id = monster_id;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public int getMonster_id() {
		return monster_id;
	}
	public void setMonster_id(int monster_id) {
		this.monster_id = monster_id;
	}
	
}
