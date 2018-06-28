package com.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.domains.Student;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long>{
	
	public Student findByPid(int pid);
	public Long deleteByPid(int pid);
}
