package myAnswer.web.page;

import java.util.List;

public class QueryResult<T> {

	/**每一页的查询结果集**/
	private List<T> list;
	
	/**总记录数**/
	private long totalRecord;

	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}

	public long getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	@Override
	public String toString()
	{
		return list.toString();
	}
	
	
}
