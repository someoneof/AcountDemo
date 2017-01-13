package myAnswer.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class AcountType {

	private Integer typeid;
	
	private String typename;
	
	
	public AcountType()
	{
	}

	public AcountType(String typename)
	{
		this.typename = typename;
	}

	public AcountType(Integer typeid)
	{
		this.typeid = typeid;
	}


	public Integer getTypeid()
	{
		return typeid;
	}

	public void setTypeid(Integer typeid)
	{
		this.typeid = typeid;
	}


	public String getTypename()
	{
		return typename;
	}

	public void setTypename(String typename)
	{
		this.typename = typename;
	}

	
}
