package edu.pnu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberVO {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
}
