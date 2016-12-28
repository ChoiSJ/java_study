package course;

import java.io.Serializable;

public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int proNo;
	private String name;
	private String major;
	private String position;
	private String proId;
	private String proPassword;
	
	public Professor() {}
	
	public Professor(int proNo, String name, String major, String position, String proId, String proPassword) {
		super();
		this.proNo = proNo;
		this.name = name;
		this.major = major;
		this.position = position;
		this.proId = proId;
		this.proPassword = proPassword;
	}
	
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProPassword() {
		return proPassword;
	}
	public void setProPassword(String proPassword) {
		this.proPassword = proPassword;
	}
}
