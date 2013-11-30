package com.tsystems.orm.entities;

// Generated 21.11.2013 9:18:21 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TeacherReview generated by hbm2java
 */
@Entity
@Table(name = "TEACHER_REVIEW", schema = "PUBLIC", catalog = "PUBLIC")
public class TeacherReview implements java.io.Serializable {

	private Integer id;
	private Student student;
	private Teacher teacher;
	private Date reviewDate;
	private String reviewText;
	private int rating;

	public TeacherReview() {
	}

	public TeacherReview(Student student, Teacher teacher, Date reviewDate,
			String reviewText, int rating) {
		this.student = student;
		this.teacher = teacher;
		this.reviewDate = reviewDate;
		this.reviewText = reviewText;
		this.rating = rating;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEACHER_ID", nullable = false)
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REVIEW_DATE", nullable = false, length = 26)
	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name = "REVIEW_TEXT", nullable = false, length = 4096)
	public String getReviewText() {
		return this.reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	@Column(name = "RATING", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
