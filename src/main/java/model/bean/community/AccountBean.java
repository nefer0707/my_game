package model.bean.community;

public class AccountBean {
	private String account;
	private String password;
	private int uid;
	private int lv;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public AccountBean(String account, String password, int uid, int lv) {
		super();
		this.account = account;
		this.password = password;
		this.uid = uid;
		this.lv = lv;
	}

	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
