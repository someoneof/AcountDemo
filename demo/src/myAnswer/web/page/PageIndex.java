package myAnswer.web.page;

public class PageIndex {
	
	private long firstIndex;
	private long endIndex;
	
	
	public PageIndex(long firstIndex, long endIndex)
	{
		this.firstIndex = firstIndex;
		this.endIndex = endIndex;
	}
	public long getFirstIndex()
	{
		return firstIndex;
	}
	public void setFirstIndex(long firstIndex)
	{
		this.firstIndex = firstIndex;
	}
	public long getEndIndex()
	{
		return endIndex;
	}
	public void setEndIndex(long endIndex)
	{
		this.endIndex = endIndex;
	}
	@Override
	public String toString()
	{
		return "PageIndex [firstIndex=" + firstIndex + ", endIndex=" + endIndex
				+ "]";
	}
	
	
	
}
