package edu.uoengland.courses.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="id")
	private UUID id;
	
	@Column(name="full_Name", nullable=false)
	private String fullName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_address", unique=true)
	private String emailAddress;
	
	@Column(name="gpa")
	private float gpa;

	@ManyToMany(mappedBy = "students")
	private Set<CourseFaculty> courseFaculty;
	
	public Student() {
		super();
	}

	public Student(UUID id, String fullName, String address, String phoneNumber, String emailAddress, float gpa) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.gpa = gpa;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public Set<CourseFaculty> getCourseFaculty() {
		return courseFaculty;
	}

	public void setCourseFaculty(Set<CourseFaculty> courseFaculty) {
		this.courseFaculty = courseFaculty;
	}
	
}
