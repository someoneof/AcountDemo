package myAnswer.daoImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import myAnswer.bean.Acount;
import myAnswer.bean.AcountType;
import myAnswer.dao.AcountTypeDao;
import myAnswer.web.page.QueryResult;

@Repository("typeDaoImpl")
public class AcountTypeDaoImpl implements AcountTypeDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void save(AcountType entity)
	{
		List<AcountType> list =new ArrayList<AcountType>();
		list.add(entity);
		save(list);		
	}
	
	@Override
	public void save(List<AcountType> list)
	{
		String sql="insert into acounttype(typename) values(?)";
		List<Object[]> arr=new ArrayList<Object[]>();
		for(AcountType o:list) arr.add(new Object[]{o.getTypename()});
		jdbc.batchUpdate(sql,arr);
	}

	@Override
	public void update(AcountType o)
	{
		String sql="update acounttype set typename="+o.getTypename();
		jdbc.update(sql);
	}

	@Override
	public AcountType getObject(Integer id)
	{
		String sql="select typeid,typename from acounttype where typeid=?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<AcountType>(AcountType.class),id);
	}


	@Override
	public void delete(int id)
	{
		String sql="delete from acounttype where typeid="+id;
		jdbc.update(sql);
	}


	@Override
	public void delete(int[] id)
	{
		for(int i:id)
			delete(id[i]);
	}


	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,Integer pagecount, String wheresql,LinkedHashMap<String, String> orderby)
	{
		QueryResult<AcountType> qr=new QueryResult<AcountType>();
		String sql="select * from acounttype "+getWheresql(wheresql)+getOrderby(orderby)+" limit "+getIndex(firstindex)+","+(getIndex(pagecount)==0?getTotalCount():getIndex(pagecount));
		System.out.println(sql);
		qr.setList(jdbc.query(sql, new BeanPropertyRowMapper<AcountType>(AcountType.class)));
		qr.setTotalRecord(getTotalCount());
		return qr;
	}
	
	public Long getTotalCount()
	{
		String sql="select count(typeid) from acounttype";
		return (Long)jdbc.queryForObject(sql,Long.class);
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
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount, LinkedHashMap<String, String> orderby)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount, String wheresql)
	{
		return null;
	}


	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<AcountType> getScrollData()
	{
		return getScrollData(-1,-1,null,null);
	}


}
