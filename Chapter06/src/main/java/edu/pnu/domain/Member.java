package edu.pnu.domain;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Member {
	
	@Id
	private String id;
	private String name;
	private String password;
	private String role;
	
}
