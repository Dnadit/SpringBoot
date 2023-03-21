package edu.pnu.domain;

public class Person {
	
	private String name;
	private int year;
	private String job;
	private String hobby;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int year, String job, String hobby) {
		super();
		this.name = name;
		this.year = year;
		this.job = job;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", year=" + year + ", job=" + job + ", hobby=" + hobby + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
