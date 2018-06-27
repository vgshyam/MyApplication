package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domains.Student;
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
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public ModelAndView doViewSpecificRecord(@PathVariable("id") int pid)
	{	
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("list", serve.findSpecific(pid));
		return mv;		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView doUpdate(@RequestParam("p") int pid,@RequestParam("n") String nm)
	{	System.out.println("\n\n\n\t\t\t1");
		ModelAndView mv = new ModelAndView("redirect: /display");
		Student studUpdate = serve.findSpecific(pid);
		studUpdate.setName(nm);
		System.out.println("\n\n\n\t\t\t2");
		serve.updateRecord(studUpdate);
		System.out.println("\n\n\n\t\t\t3");
		return mv;		
	}
}
