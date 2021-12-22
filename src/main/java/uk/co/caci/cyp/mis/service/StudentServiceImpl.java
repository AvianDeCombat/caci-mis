package uk.co.caci.cyp.mis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.co.caci.cyp.mis.dao.StudentDAO;
import uk.co.caci.cyp.mis.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDao;
	
	public StudentServiceImpl(StudentDAO theStudentDao) {
		studentDao = theStudentDao;
		
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public Student getStudentByID(int id) {
		return studentDao.getStudentByID(id);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDao.saveStudent(student);
		
	}

}
