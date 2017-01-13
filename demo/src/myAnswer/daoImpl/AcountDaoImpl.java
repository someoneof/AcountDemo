package myAnswer.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import myAnswer.bean.Acount;
import myAnswer.dao.AcountDao;
import myAnswer.dao.abstractDao;
import myAnswer.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("acountDaoImpl")
public class AcountDaoImpl extends abstractDao<Acount> implements AcountDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void save(Acount entity)
	{
		List<Acount> list =new ArrayList<Acount>();
		list.add(entity);
		save(list);
	}
	
	@Override
	public void save(List<Acount> list)
	{	
		String sql="insert into acount(code,createdate,isBan,lastlogin,remark,state,username,password,typename) values(?,?,?,?,?,?,?,?,?)";
		List<Object[]> arr=new ArrayList<Object[]>();
		for (Acount o : list)
		{
			o.setCode(getAcountcode(o.getCreatedate()));
			arr.add(new Object[] { o.getCode(), o.getCreatedate(),o.getIsBan(), 
			o.getLastlogin(), o.getRemark(),o.getState(), o.getUsername(),o.getPassword(),o.getTypename()});
		}
		jdbc.batchUpdate(sql,arr);
	}
	
	
	
	public Acount getObject(Integer id)
	{
		String sql = "select acountid,code,createdate,isBan,lastlogin,remark,state,username,password,typename from acount where acountid= ?";
		return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Acount>(Acount.class), id);
	}
	
	@Override
	public void update(Acount o)
	{
		//the type of boolean  can't bring '',
		//update acount set isBan=false, lastlogin='2017-01-09 21:00:00.0', remark='sdf',state=false, username='username', typeid='1' where acountid=1
		String sql="update acount set isBan="+o.getIsBan()+ ", lastlogin='"+o.getLastlogin()+"', remark='"+o.getRemark()+"',state="+o.getState()+", username='"+o.getUsername()+"', password='"+o.getPassword()+"', typename='"+o.getTypename()
					+"' where acountid="+o.getAcountid();
		System.out.println(sql);
		jdbc.update(sql);
	}
	
	/**
	 * 生成帐号编码
	 * 组成:年月日+(当天注册帐号总数+1),如果帐号编码长度不够5位,则在前面添0
	 * @param date
	 */
	private synchronized String getAcountcode(Date date)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMdd");
		StringBuilder sb=new StringBuilder(dateFormat.format(date));
		try{
			sb.append(fillZero(5,String.valueOf(getTotalCount()+1)));
		}catch(Exception e)
		{
			throw new RuntimeException("添加失败!");
		}
		return sb.toString();
	}
	
	public Long getTotalrecord()
	{
		String sql="select count(acountid) from acount";
		return (Long)jdbc.queryForObject(sql,Long.class);
	}
	
	
	public Long getTotalCount()
	{
		String sql="select count(acountid) from acount where TO_DAYS(createdate) =TO_DAYS(NOW())";
		return (Long)jdbc.queryForObject(sql,Long.class);
	}
	

	private String fillZero(int Length, String source)
	{
		StringBuilder result=new StringBuilder(source);
		for(int i=result.length();i<Length;i++)
			result.insert(0, '0');  //在第一位插入0
		return result.toString();
	}

	@Override
	public void delete(int id)
	{	//update acount set isBan=false where acountid=id
		jdbc.update("update acount set isBan=false where acountid="+id);
	}

	@Override
	public void delete(int[] id)
	{
		for(int i=0;i<id.length;i++){
			delete(id[i]);
		}
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex, Integer pagecount,String wheresql,LinkedHashMap<String, String> orderby)
	{
		// select * from userdetail where userid limit 0,20
		
		QueryResult<Acount> qr=new QueryResult<Acount>();
		String sql="select * from acount "+getWheresql(wheresql)+getOrderby(orderby)+" limit "+getIndex(firstindex)+","+(getIndex(pagecount)==0?getTotalrecord():getIndex(pagecount));
		System.out.println(sql);
		qr.setList(jdbc.query(sql, new BeanPropertyRowMapper<Acount>(Acount.class)));
		qr.setTotalRecord(getTotalrecord());
		return qr;
	}
	private String getWheresql(String wheresql)
	{
		return wheresql==null?"":wheresql;
	}
	
	private Integer getIndex(Integer index)
	{
		return (index!=null && index>-1?index:0);
	}
	
	private String getOrderby(LinkedHashMap<String, String> orderby)
	{
		// desc
		StringBuffer buffer = new StringBuffer();
		buffer.append(" order by ");
		if (orderby != null && orderby.size() > 0)
		{
			for (String key : orderby.keySet())
				buffer.append(key).append(" ").append(orderby.get(key)).append(" ,");
			buffer.deleteCharAt(buffer.length() - 1);
			return buffer.toString();
		} else
			return "";
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex,
			Integer pagecount, LinkedHashMap<String, String> orderby)
	{
		return getScrollData(firstindex,pagecount,null,orderby);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex,
			Integer pagecount, String wheresql)
	{
		return getScrollData(firstindex,pagecount,wheresql,null);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex,
			Integer pagecount)
	{
		return getScrollData(firstindex,pagecount,null,null);
	}

	@Override
	public QueryResult<Acount> getScrollData()
	{
		return getScrollData(-1,-1);
	}
}
