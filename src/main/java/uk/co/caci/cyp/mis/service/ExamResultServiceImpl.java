package uk.co.caci.cyp.mis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uk.co.caci.cyp.mis.dao.ExamResultDAO;
import uk.co.caci.cyp.mis.entity.ExamResult;

@Service
public class ExamResultServiceImpl implements ExamResultService {
	private ExamResultDAO examResultDao;
	
	@Autowired
	public ExamResultServiceImpl(ExamResultDAO theExamResultDao) {
		examResultDao = theExamResultDao;
	}

	@Override
	@Transactional
	public List<ExamResult> getAllExamResult() {
		return examResultDao.getAllExamResult();
	}

	@Override
	@Transactional
	public List<ExamResult> getExamResultsByStudentID(int id) {
		return examResultDao.getExamResultsByStudentID(id);
	}

	@Override
	@Transactional
	public String getResultByExamID(int id) {
		return examResultDao.getResultByExamID(id);
	}

}
