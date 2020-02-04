package com.sinc.intern.user.model.vo;

public class UserVO {
	private String id, pwd, name;
	private double point;
	private String depth;
	
	public UserVO() {
		super();
	}

	public UserVO(String id, String pwd, String name, double point, String depth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.depth = depth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", point=" + point + ", depth=" + depth + "]";
	}

}
