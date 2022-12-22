package model.bean.chars;

public class CharsBean {
	private int uid;
	private int char_id;
	private String char_name;
	private String img;
	private int job_id;
	private int money;

	public CharsBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharsBean(int uid, int char_id, String char_name, String img, int job_id, int money) {
		super();
		this.uid = uid;
		this.char_id = char_id;
		this.char_name = char_name;
		this.img = img;
		this.job_id = job_id;
		this.money = money;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getChar_id() {
		return char_id;
	}

	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}

	public String getChar_name() {
		return char_name;
	}

	public void setChar_name(String char_name) {
		this.char_name = char_name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
