package myAnswer.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import myAnswer.bean.Acount;
import myAnswer.web.page.QueryResult;
import myAnswer.bean.*;


public interface baseDao<T> {
	
	public void save(T entity);
	
	public void save(List<T> list);

	void update(T o);

	public T getObject(Integer id);
	
	
	void delete(int id);

	void delete(int[] id);

	/**
	 * 得到分页结果集
	 * @param firstindex 第一条记录
	 * @param pagecount 每页记录数
	 * @param wheresql 查询条件(模糊查询,精确查询等)
	 * @param orderby 排列顺序
	 */
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,String wheresql,LinkedHashMap<String, String> orderby);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,LinkedHashMap<String, String> orderby);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,String wheresql);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount);
	
	QueryResult<T> getScrollData();
	
}
