package uk.co.caci.cyp.mis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uk.co.caci.cyp.mis.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDAO{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Student> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Student> query = session.createQuery("from Student", Student.class);
		
		List<Student> studentList = query.getResultList();
		return studentList;
	}
	@Override
	public Student getStudentByID(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Student.class, id);
	}
	@Override
	public void saveStudent(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);
		
	}

}
