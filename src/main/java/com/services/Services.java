package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domains.Student;
import com.repositories.StudentRepository;

@Service
public class Services {
	
	@Autowired
	StudentRepository studRepo;
	
	public void insertData(int pid,String name)
	{
		Student stud = new Student();
		stud.setPid(pid);
		stud.setName(name);
		studRepo.save(stud);
	}
	
	public Iterable<Student> displayData()
	{
		Iterable<Student> list= studRepo.findAll();
//		List<Student> list = new ArrayList<>();
////		d.forEach(e -> System.out.println(e.getName()));
//		d.forEach(list :: add);
		return list;
	}

}