package model.bean.community;

public class JobBean {
	private int job_id;
	private String job_name;
	private int job_lavel;
	private int job_type_id;
	private String job_type_name;
	public JobBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobBean(int job_id, String job_name, int job_lavel,int job_type_id,String job_type_name) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.job_lavel = job_lavel;
		this.job_type_id = job_type_id;
		this.job_type_name = job_type_name;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public int getJob_lavel() {
		return job_lavel;
	}
	public void setJob_lavel(int job_lavel) {
		this.job_lavel = job_lavel;
	}
	public int getJob_type_id() {
		return job_type_id;
	}
	public void setJob_type_id(int job_type_id) {
		this.job_type_id = job_type_id;
	}
	public String getJob_type_name() {
		return job_type_name;
	}
	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}
	@Override
	public String toString() {
		return "JobBean [job_id=" + job_id + ", job_name=" + job_name + ", job_lavel=" + job_lavel + ", job_type_id="
				+ job_type_id + ", job_type_name=" + job_type_name + "]";
	}
	
	
}
