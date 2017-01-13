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
	 * �õ���ҳ�����
	 * @param firstindex ��һ����¼
	 * @param pagecount ÿҳ��¼��
	 * @param wheresql ��ѯ����(ģ����ѯ,��ȷ��ѯ��)
	 * @param orderby ����˳��
	 */
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,String wheresql,LinkedHashMap<String, String> orderby);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,LinkedHashMap<String, String> orderby);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount,String wheresql);
	
	QueryResult<T> getScrollData(Integer firstindex, Integer pagecount);
	
	QueryResult<T> getScrollData();
	
}
