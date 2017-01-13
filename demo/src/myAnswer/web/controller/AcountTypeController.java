package myAnswer.web.controller;

import myAnswer.bean.AcountType;
import myAnswer.service.AcountTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcountTypeController {

	@Autowired
	private AcountTypeService acountTypeServiceImpl;
	
	@RequestMapping("/type/list")
	public String typeList(Model model)
	{
		model.addAttribute("types",acountTypeServiceImpl.getScrollData().getList());
		return "/addAcount";
	}
	
	@RequestMapping("/type/list_queryAcount")
	public String findtype(Model model)
	{
		model.addAttribute("types",acountTypeServiceImpl.getScrollData().getList());
		return "/query";
	}
	
	@RequestMapping("/type/add")
	public String add(Model model,String typename)
	{
		acountTypeServiceImpl.save(new AcountType(typename));
		model.addAttribute("message","添加帐号类型成功!");
		model.addAttribute("urladdress", "/demo/acount/list");
		return "/message";
	}
}
