package myAnswer.bean;

import java.util.Date;



public class Acount {
	
	private Integer acountid;
	/**±àÂë*/
	private String code;
	
	private String username;
	
	private String password;
	
	private String remark;
	/**×´Ì¬*/
	private Boolean state=false;
	
	private Date createdate=new Date();
	
	private Date lastlogin=new Date();
	/**ÊÇ·ñ·â´æ*/
	private Boolean isBan=false;
	
	private String typename;



	
	public Acount(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public Acount(String username, String password, String remark)
	{
		this.username = username;
		this.password = password;
		this.remark = remark;
	}

	public Acount(Integer acountid)
	{
		this.acountid = acountid;
	}

	public Acount()
	{
	}

	public Integer getAcountid()
	{
		return acountid;
	}

	public void setAcountid(Integer acountid)
	{
		this.acountid = acountid;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Boolean getState()
	{
		return state;
	}

	public void setState(Boolean state)
	{
		this.state = state;
	}

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}

	public Date getLastlogin()
	{
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin)
	{
		this.lastlogin = lastlogin;
	}
	public String getTypename()
	{
		return typename;
	}

	public void setTypename(String typename)
	{
		this.typename = typename;
	}

	public Boolean getIsBan()
	{
		return isBan;
	}

	public void setIsBan(Boolean isBan)
	{
		this.isBan = isBan;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}


}
