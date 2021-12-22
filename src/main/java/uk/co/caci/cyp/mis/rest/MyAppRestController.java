package uk.co.caci.cyp.mis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.caci.cyp.mis.entity.ExamResult;
import uk.co.caci.cyp.mis.entity.Student;
import uk.co.caci.cyp.mis.service.ExamResultService;
import uk.co.caci.cyp.mis.service.StudentService;

@RestController
@RequestMapping("/api")
public class MyAppRestController {
	private StudentService studentService;
	private ExamResultService examResultService;
	
	@Autowired
	public MyAppRestController(StudentService theStudentService, ExamResultService theExamResultService) {
		studentService = theStudentService;
		examResultService = theExamResultService;
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return studentService.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudetnByID(@PathVariable int id){
		
		return studentService.getStudentByID(id);
	}
	
	@GetMapping("/exam-result")
	public List<ExamResult> getAllExamResult(){
		return examResultService.getAllExamResult();
	}
	
	@GetMapping("/student/{id}/exam-result")
	public List<ExamResult> getExamResultsByStudentID(@PathVariable int id){
		return examResultService.getExamResultsByStudentID(id);
	}
	
	@GetMapping("/exam-result/{id}/grade")
	public String getResultByExamID(@PathVariable int id) {
		return examResultService.getResultByExamID(id);
	}
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		studentService.save(student);
		return student;
	}

}
