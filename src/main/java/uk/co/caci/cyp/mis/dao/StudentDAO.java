package uk.co.caci.cyp.mis.dao;

import java.util.List;

import uk.co.caci.cyp.mis.entity.Student;

public interface StudentDAO {
	
	public List<Student> findAll();
	
	public Student getStudentByID(int id);

	public void saveStudent(Student student);

}
