package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.services.Services;

@Controller
public class MainController {

	@Autowired 
	Services serve;
	@RequestMapping("/")
	public String doHome()
	{		
		return "index.html";		
	}
	
	@RequestMapping("/insert")
	public String doHome(@RequestParam("sid") int id,@RequestParam("sname")String name)
	{		
		serve.insertData(id,name);
		return "index.html";		
	}
	
	@RequestMapping("/display")
	public ModelAndView doDisplay()
	{	
		ModelAndView mv = new ModelAndView("viewData");
		/*Iterable<Student> s=serve.displayData();
		s.forEach(e -> System.out.println(e.getName()));*/
		mv.addObject("list", serve.displayData());
		return mv;		
	}
}
