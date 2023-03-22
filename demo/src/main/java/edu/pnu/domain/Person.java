package edu.pnu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	private String name;
	private int year;
	private String job;
	private String hobby;
	
//	public Person() {
//		
//	}
//	public Person(String name, int year, String job, String hobby) {
//		super();
//		this.name = name;
//		this.year = year;
//		this.job = job;
//		this.hobby = hobby;
//	}
//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", year=" + year + ", job=" + job + ", hobby=" + hobby + "]";
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getYear() {
//		return year;
//	}
//	public void setYear(int year) {
//		this.year = year;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public String getHobby() {
//		return hobby;
//	}
//	public void setHobby(String hobby) {
//		this.hobby = hobby;
//	}
	
}
