package myAnswer.web.page;

public class WebTool {
//viewpagecount(jsp页面显示的页数1,2,3...viewpagecount),currenPage当前页,totalPage总页数.
	
	/*如果大于viewpagecount,那么只显示viewpagecount
	 * 如果小于viewpagecount,那么显示totalpage
	 * */
	public static PageIndex getPageIndex(long viewpagecount, int currenPage,
			long totalpage)
	{
		long startpage = currenPage
				- (viewpagecount % 2 == 0 ? viewpagecount / 2 - 1
						: viewpagecount / 2);
		long endpage = currenPage + viewpagecount / 2;
		if (startpage < 1)
		{
			startpage = 1;
			if (totalpage >= viewpagecount)
				endpage = viewpagecount;
			else
				endpage = totalpage;
		}
		if (endpage > totalpage)
		{
			endpage = totalpage;
			if ((endpage - viewpagecount) > 0)
				startpage = endpage - viewpagecount + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}
}
