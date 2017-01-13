package junittest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import myAnswer.bean.Acount;
import myAnswer.bean.AcountType;
import myAnswer.dao.AcountDao;
import myAnswer.dao.AcountTypeDao;
import myAnswer.daoImpl.AcountDaoImpl;
import myAnswer.web.page.QueryResult;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AcountTest {

	static AcountDao dao;
	JdbcTemplate jdbc;
	AcountTypeDao typeImpl;
	static ApplicationContext ct;
	
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(AcountDaoImpl)ct.getBean("acountDaoImpl");
		jdbc=(JdbcTemplate)ct.getBean(JdbcTemplate.class);
		typeImpl=(AcountTypeDao) ct.getBean("typeDaoImpl");
//		classImpl=(ClassDaoImpl)ct.getBean("classDaoImpl");
	}
	
	@Test
	public void test()
	{
		/*String sql="insert into acount(username,code,remark,state,createdate,lastlogin,isBan,acounttype) "
				+ "values('"+o.getUsername()+"','"+o.getCode()+"','"+o.getRemark()+"','"+o.getState()+"','"+
				o.getCreatedate()+"','"+o.getLastlogin()+"','"+o.getIsBan()+"','"+o.getAcounttype()+"')";
		System.out.println(sql);*/
	}
	
	@Test
	public void testsave() throws ParseException
	{
		for(int i=0;i<20;i++){
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH");
		Acount acount=new Acount();
		acount.setLastlogin(df.parse(df.format(new Date())));
		acount.setRemark("sdf");
		acount.setUsername(i+"username");
		acount.setPassword("password");
		acount.setTypename(typeImpl.getObject(1).getTypename());
		try{
		dao.save(acount);
		}catch(Exception e)
		{
			e.printStackTrace();
		}}
		// 删除外键约束ALTER TABLE acount DROP FOREIGN KEY FK7492516E95B45FFF
	}
	
	@Test
	public void testfidn()
	{
//		String sql="select count(acountid) from acount where createdate >=Mon Jan 09 00:00:00 CST 2017";
		String sql="select count(acountid) from acount createdate>=";
		long count=jdbc.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testupdate()
	{
		try
		{
			Acount acount = dao.getObject(1);
			System.out.println(acount.getUsername());
			dao.update(acount);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testdelete()
	{
		dao.delete(8);
	}
	@Test
	public void testgetScrollData()
	{
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("isBan", "desc");
		orderby.put("acountid", "asc");
		//查询两个时间段的数据
		String sql="where createdate between '2017-01-09 23:04:21' and '2017-01-10 00:52:12'";
		QueryResult<Acount> qr=dao.getScrollData(-1,-1,sql);
		System.out.println(qr.getList().size());
		for(Acount a:qr.getList())
			System.out.println(a.getUsername());
	}
	
	@Test
	public void testtype()
	{
		String sql="select * from acount where username LIKE \"%user%\"";
		System.out.println(sql);
		List<Acount> list=jdbc.query(sql, new BeanPropertyRowMapper<Acount>(Acount.class));
	}
	@Test
	public void testnotClear()
	{
		//一个%绑定一个
		String sql="select * from acount where username LIKE \"%user%\"";
		System.out.println(sql);
		List<Acount> list=jdbc.query(sql, new BeanPropertyRowMapper<Acount>(Acount.class));
		for(Acount a:list)
		System.out.println(a.getUsername());
	}
	@Test
	public void testselectfromdate()
	{
//		String sql="select count(acountid) from acount where createdate >=\"Mon Jan 09 00:00:00 CST 2017\"";
		//查询昨天的记录
//		String sql="select count(acountid) from acount where TO_DAYS(createdate) =TO_DAYS(NOW())-1";
		//查询当天的记录
		String sql="select count(acountid) from acount where TO_DAYS(createdate) =TO_DAYS(NOW())";
		
		System.out.println(sql);
		long count=jdbc.queryForObject(sql,Long.class);
	/*	for(Acount a:list)
		System.out.println(a.getAcountid());*/
		System.out.println(count);
	}
	
	
	
	@Test
	public void testfindBytype()
	{
		String sql="where typeid=1";
		QueryResult<Acount> qr=dao.getScrollData(0, 12, sql);
		for(Acount a:qr.getList())
			System.out.println(a.getAcountid());
	}
	@Test
	public void testfind()
	{
		String sql = "select acountid,code,createdate,isBan,lastlogin,remark,state,username,password,typeid from acount where typeid= ?";
		System.out.println(sql);
		Acount type=jdbc.queryForObject(sql, new BeanPropertyRowMapper<Acount>(Acount.class),1);
		System.out.println(type.getUsername());
	}
	//,1 },2 },3 },4 },5 },6 },7 },8 },9 },10 }
	@Test
	public void testsubString()
	{
		String str=",1 },2 },3 },4 },5 },6 },7 },8 },9 },10 }";
		str=str.substring(1,str.length()-2);
		String[] s=str.split("},");
		for(String t:s)
			System.out.println(Integer.parseInt(t));
	}
}
