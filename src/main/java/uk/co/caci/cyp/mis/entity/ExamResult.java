package uk.co.caci.cyp.mis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_result")
public class ExamResult {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="result")
	private Integer result;
	
	@Column(name="student_id")
	private int studentId;
	
	public ExamResult() {
		
	}
	public ExamResult(int id, String name, Integer result, int studentId) {
		this.id = id;
		this.name = name;
		this.result = result;
		this.studentId = studentId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	@Override
	public String toString() {
		return "ExamResult [id=" + id + ", name=" + name + ", result=" + result + ", studentId=" + studentId + "]";
	}

}
