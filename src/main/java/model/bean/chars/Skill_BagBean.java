package model.bean.chars;

public class Skill_BagBean {
	private int skill_id;

	private int char_id;

	public Skill_BagBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Skill_BagBean(int skill_id, int char_id) {
		super();
		this.skill_id = skill_id;
		this.char_id = char_id;
	}


	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}


	public int getChar_id() {
		return char_id;
	}

	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}

}
