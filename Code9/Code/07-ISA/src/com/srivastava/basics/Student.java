package com.srivastava.basics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
@DiscriminatorValue(value="stud")
public class Student extends Person{
private String course;
private String collegeName;
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
@Override
public String toString() {
	return "Student [course=" + course + ", collegeName=" + collegeName + "]";
}

}
