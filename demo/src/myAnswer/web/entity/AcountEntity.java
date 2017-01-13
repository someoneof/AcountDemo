package myAnswer.web.entity;

import java.io.Serializable;

public class AcountEntity implements Serializable{

	private static final long serialVersionUID = -2543896439216612452L;

	private String username;
	private String password;
	private String remark;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
}
