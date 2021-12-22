package uk.co.caci.cyp.mis.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.caci.cyp.mis.entity.ExamResult;

@Repository
public class ExamResultDaoImpl implements ExamResultDAO {
private EntityManager entityManager;
	
	@Autowired
	public ExamResultDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<ExamResult> getAllExamResult() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<ExamResult> query = session.createQuery("from ExamResult", ExamResult.class);
		
		List<ExamResult> examResultList = query.getResultList();
		return examResultList;
	}

	@Override
	public List<ExamResult> getExamResultsByStudentID(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query examQuery= session.createQuery("from ExamResult e where e.studentId = : id",ExamResult.class);
		examQuery.setParameter("id", id);
		return examQuery.list();
	}

	@Override
	public String getResultByExamID(int id) {
		Session session = entityManager.unwrap(Session.class);
		ExamResult er = session.get(ExamResult.class, id);
		String grade = "";
		Integer res = er==null?-1:er.getResult()==null?-1:er.getResult();

		if(res == -1) {
			grade = "U";
		}
		else if(res < 60) {
			grade = "F";
		}
		else if(res >= 60 && res < 80) {
			grade = "B";
		}
		else {
			grade = "A";
		}
		JSONObject jo = new JSONObject();
		try {
			jo.put("grade", grade);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jo.toString();
		
	}

}
