package model.bean.chars;

public class Skill_BagBean {
	private int skill_id;
	private String skill_name;
	private String caption;
	private int skill_type_id;
	private int power;
	private String skill_type_name;
	private int char_id;

	public Skill_BagBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill_BagBean(int skill_id, String skill_name, String caption, int skill_type_id, int power,
			String skill_type_name, int char_id) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.caption = caption;
		this.skill_type_id = skill_type_id;
		this.power = power;
		this.skill_type_name = skill_type_name;
		this.char_id = char_id;
	}

	public int getSkill_id() {
		return skill_id;
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

	public String getSkill_type_name() {
		return skill_type_name;
	}

	public void setSkill_type_name(String skill_type_name) {
		this.skill_type_name = skill_type_name;
	}

	public int getChar_id() {
		return char_id;
	}

	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}

}
