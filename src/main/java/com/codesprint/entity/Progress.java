package com.codesprint.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="progress")
public class Progress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;
	 @ManyToOne
	 @JoinColumn(name="student_id")
	 private Student student;
	 
	 @ManyToOne
	 @JoinColumn(name="question_id")
	 private Question question;

	 public Progress() {
		super();
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getStatus() {
		 return status;
	 }

	 public void setStatus(String status) {
		 this.status = status;
	 }

	 public Student getStudent() {
		 return student;
	 }

	 public void setStudent(Student student) {
		 this.student = student;
	 }

	 public Question getQuestion() {
		 return question;
	 }

	 public void setQuestion(Question question) {
		 this.question = question;
	 }
	 

	 @Override
	public String toString() {
		return "Progress [id=" + id + ", status=" + status + ", student=" + student + ", question=" + question + "]";
	}

	 public Progress(Long id, String status, Student student, Question question) {
		super();
		this.id = id;
		this.status = status;
		this.student = student;
		this.question = question;
	 }
	 
	 

}
