package myAnswer.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;

import myAnswer.bean.Acount;
import myAnswer.dao.AcountDao;
import myAnswer.service.AcountService;
import myAnswer.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("acountImpl")
public class AcountServicempl implements AcountService {

	@Autowired
	private AcountDao acountDaoImpl;
	
	@Override
	public void save(Acount entity)
	{
		acountDaoImpl.save(entity);
	}

	@Override
	public void save(List<Acount> list)
	{
		acountDaoImpl.save(list);
	}

	@Override
	public void update(Acount o)
	{
		acountDaoImpl.update(o);
	}

	@Override
	public Acount getObject(Integer id)
	{
		return acountDaoImpl.getObject(id);
	}

	@Override
	public void delete(int id)
	{
		acountDaoImpl.delete(id);
	}

	@Override
	public void delete(int[] id)
	{
		acountDaoImpl.delete(id);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex, Integer pagecount,
			String wheresql, LinkedHashMap<String, String> orderby)
	{
		return acountDaoImpl.getScrollData(firstindex, pagecount, wheresql, orderby);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex, Integer pagecount,
			LinkedHashMap<String, String> orderby)
	{
		return acountDaoImpl.getScrollData(firstindex, pagecount, orderby);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex, Integer pagecount,
			String wheresql)
	{
		return acountDaoImpl.getScrollData(firstindex, pagecount,wheresql);
	}

	@Override
	public QueryResult<Acount> getScrollData(Integer firstindex, Integer pagecount)
	{
		return acountDaoImpl.getScrollData();
	}

	@Override
	public QueryResult<Acount> getScrollData()
	{
		return acountDaoImpl.getScrollData();
	}
}
