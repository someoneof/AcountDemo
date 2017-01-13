package myAnswer.web.controller;

import java.util.LinkedHashMap;

import myAnswer.bean.Acount;
import myAnswer.service.AcountService;
import myAnswer.service.AcountTypeService;
import myAnswer.web.page.PageView;
import myAnswer.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcountController {

	@Autowired
	private AcountService acountImpl;
	@Autowired
	private AcountTypeService typeImpl;
	
	@RequestMapping("/acount/list")
	public ModelAndView acountList(Model model,Integer currpage)
	{
		int cur=(currpage==null?1:currpage);
		QueryResult<Acount> qr=acountImpl.getScrollData(getFirstIndex(cur), 10,getOrderBy());
		PageView<Acount> pageView=new PageView<Acount>(cur,10);
		pageView.setQueryResult(qr);
		model.addAttribute("pageView",pageView );
		model.addAttribute("currpage",cur);
		return new ModelAndView("/test");
	}
	
	@RequestMapping("/acount/add")
	public ModelAndView add(Model model,String username,String password,String remark,String typename)
	{
		
		Acount acount=new Acount(username,password,typename);
		if(!remark.equals("可以不填写备注") || remark!=null && remark.trim()!="") acount.setRemark(remark);
		acountImpl.save(acount);
		model.addAttribute("message","添加成功!");
		model.addAttribute("urladdress","/demo/acount/list");
		return new ModelAndView("/message");
	}
	@RequestMapping("/acount/edit")
	public ModelAndView edit(Model model,Integer acountid,String username,String password,String remark,String typename)
	{
		System.out.println("acountid="+acountid+"   typename="+typename+"  username="+username);
		Acount acount=acountImpl.getObject(acountid);
		acount.setUsername(username);
		acount.setPassword(password);
		acount.setRemark(remark);
		acount.setTypename(typename);
		if(remark!=null && remark.trim()!="") acount.setRemark(remark);
		acountImpl.update(acount);
		model.addAttribute("message","修改成功!");
		model.addAttribute("urladdress","/demo/acount/list");
		return new ModelAndView("/message");
		
	}
	
	@RequestMapping("/acount/editUI")
	public ModelAndView editUI(Model model,Integer acountid)
	{
		System.out.println("acountid="+acountid);
		Acount acount=acountImpl.getObject(acountid);
		model.addAttribute("username", acount.getUsername());
		model.addAttribute("password",acount.getPassword());
		model.addAttribute("remark", acount.getRemark());
		model.addAttribute("types",typeImpl.getScrollData().getList());
		model.addAttribute("acountid",acountid);
		return new ModelAndView("/edit");
	}
	
	@RequestMapping("/acount/setState")
	public ModelAndView setState(String method,String acountids)
	{
		acountids=acountids.substring(1,acountids.length()-2);
		String[] str=acountids.split("},");
		for (int i = 0; i < str.length; i++)
		{
			Acount o = acountImpl.getObject(Integer.parseInt(str[i].trim()));
			if(method.equals("visible")) o.setIsBan(true);
			else o.setIsBan(false);
			acountImpl.update(o);
		}
		return new ModelAndView("redirect:/acount/list");
	}
	
	@RequestMapping("/acount/query")
	public String query(Model model,Integer currpage,String code,String username,String createtime1,String createtime2,String typename)
	{
		String sql="";//select * from acount where username LIKE "%user%"
		int cur=(currpage==null?1:currpage);//2017-01-09 23:04:21
		PageView<Acount> pageView=new PageView<Acount>(cur,10);
		if(judge(code))  sql="where code like \"%"+code+"%\"";
		if(judge(username)) sql="where username like \"%"+username+"%\"";
		if(judge(createtime1) && judge(createtime2)) sql="where createdate between +'"+createtime1 +"'and'"+createtime2+"'";
		if(judge(createtime1)) sql="where createdate<='"+createtime1+"'";
		if(judge(createtime2)) sql="where createdate>='"+createtime2+"'";
		try{
		QueryResult<Acount> qr=acountImpl.getScrollData(getFirstIndex(cur), 10,sql,getOrderBy());
		pageView.setQueryResult(qr);
		model.addAttribute("pageView",pageView );
		model.addAttribute("currpage",cur);
		return "/test";
		}catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("message","查询失败!");
			model.addAttribute("urladdress","/index");
			return "/message";
		}
	}
	
	private Boolean judge(String name)
	{
		return name!=null && name.trim()!="";
	}
	@RequestMapping("/acount/addUI")
	public ModelAndView addUI() 
	{
		return new ModelAndView("/addAcount");
	}
	
	private Integer getFirstIndex(Integer cur)
	{
		return (cur-1)*10;
	}
	
	private LinkedHashMap<String, String> getOrderBy()
	{
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("acountid", "asc");
		orderby.put("isBan", "desc");
		return orderby;
	}
}
