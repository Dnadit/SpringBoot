package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.Person;

public class BoardService {
	
	private List<Person> list = new ArrayList<>();
	
	public BoardService() {
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍길동", 2000, "백수", "선플"));
	}
	
	public List<Person> getPersons() {
		return list;
	}
}
