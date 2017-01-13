package myAnswer.web.page;

import java.util.List;

/**
 * 每一页信息应该包含的数据:PageIndex(jsp页面显示的首尾页),QueryResult(每一页的结果集,总记录数)
 * 					 每一页的记录条数maxresult,总页数totalPage
 * @author 海峰
 *
 * @param <T>
 */
public class PageView<T> {

	/**每一页的结果集**/
	private List<T> record;
	/**当前页**/
	private int currpage;
	/**总页数**/
	private long totalPage;
	/**首尾页*/
	private PageIndex pageIndex;
	/**总记录数*/
	private long totalRecord;
	/**每一页记录数*/
	private int maxresult=12;
	
	public PageView(int currpage, int maxresult)
	{
		this.currpage = currpage;
		this.maxresult = maxresult;
	}
	
	public void setQueryResult(QueryResult<T> qr)
	{
		setTotalRecord(qr.getTotalRecord());
		setRecord(qr.getList());
	}
	
	public List<T> getRecord()
	{
		return record;
	}

	public void setRecord(List<T> records)
	{
		this.record = records;
	}

	public void setPageIndex(PageIndex pageIndex)
	{
		this.pageIndex = pageIndex;
	}

	public int getCurrpage()
	{
		return currpage;
	}
	public void setCurrpage(int currpage)
	{
		this.currpage = currpage;
	}
	public long getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(long totalPage)
	{	
		this.totalPage = totalPage;
		this.pageIndex=WebTool.getPageIndex(maxresult, currpage, totalPage);
	}
	public PageIndex getPageIndex()
	{
		return pageIndex;
	}
	public long getTotalRecord()
	{
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord)
	{	
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord%maxresult==0?this.totalRecord/maxresult:this.totalRecord/maxresult+1);
	}
	public int getMaxresult()
	{
		return maxresult;
	}
	public void setMaxresult(int maxresult)
	{
		this.maxresult = maxresult;
	}

}
