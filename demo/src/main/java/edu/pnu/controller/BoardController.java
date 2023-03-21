package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post : " + name;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "선플");
	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍이동", 2001, "백수", "악플"));
		list.add(new Person("홍삼동", 2002, "백수", "없음"));
		return list;
	}
}
