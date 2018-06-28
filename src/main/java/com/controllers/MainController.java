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
@RequestMapping(value="/")
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
		ModelAndView mv = new ModelAndView("updateData");
		mv.addObject("list", serve.findSpecific(pid));
		return mv;		
	}
	
	@RequestMapping(value="/upd", method=RequestMethod.POST)
	public ModelAndView doUpdate(@RequestParam("p") int pid,@RequestParam("n") String nm)
	{	
		ModelAndView mv = new ModelAndView("message");
		Student studUpdate = serve.findSpecific(pid);
		studUpdate.setName(nm);
		serve.updateRecord(studUpdate);
		return mv;		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView doDelete(@PathVariable("id") int pid)
	{	
		ModelAndView mv = new ModelAndView("message");
		serve.deleteNode(pid);
		return mv;		
	}
}
