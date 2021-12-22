package uk.co.caci.cyp.mis.dao;

import java.util.List;

import uk.co.caci.cyp.mis.entity.ExamResult;

public interface ExamResultDAO {
	public List<ExamResult> getAllExamResult();
	
	public List<ExamResult> getExamResultsByStudentID(int id);
	
	public String getResultByExamID(int id);

}
