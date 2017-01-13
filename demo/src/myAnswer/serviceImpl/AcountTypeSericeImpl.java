package myAnswer.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;

import myAnswer.bean.AcountType;
import myAnswer.dao.AcountTypeDao;
import myAnswer.service.AcountTypeService;
import myAnswer.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("acountTypeSericeImpl")
public class AcountTypeSericeImpl implements AcountTypeService {

	@Autowired 
	private AcountTypeDao typeImpl; 
	
	@Override
	public void save(AcountType entity)
	{
		typeImpl.save(entity);
	}

	@Override
	public void save(List<AcountType> list)
	{
		typeImpl.save(list);
	}

	@Override
	public void update(AcountType o)
	{
		typeImpl.update(o);
	}

	@Override
	public AcountType getObject(Integer id)
	{
		return typeImpl.getObject(id);
	}

	@Override
	public void delete(int id)
	{
		typeImpl.delete(id);
	}

	@Override
	public void delete(int[] id)
	{
		typeImpl.delete(id);
	}

	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,Integer pagecount, String wheresql,LinkedHashMap<String, String> orderby)
	{
		return typeImpl.getScrollData(firstindex, pagecount, wheresql, orderby);
	}

	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount, LinkedHashMap<String, String> orderby)
	{
		return typeImpl.getScrollData(firstindex, pagecount, orderby);
	}

	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount, String wheresql)
	{
		return typeImpl.getScrollData(firstindex, pagecount, wheresql);
	}

	@Override
	public QueryResult<AcountType> getScrollData(Integer firstindex,
			Integer pagecount)
	{
		return typeImpl.getScrollData(firstindex, pagecount);
	}

	@Override
	public QueryResult<AcountType> getScrollData()
	{
		return typeImpl.getScrollData();
	}
}
