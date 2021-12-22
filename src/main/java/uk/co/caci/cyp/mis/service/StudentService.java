package uk.co.caci.cyp.mis.service;

import java.util.List;

import uk.co.caci.cyp.mis.entity.Student;

public interface StudentService {
	public List<Student> findAll();
	
	public Student getStudentByID(int id);

	public void save(Student student);

}
