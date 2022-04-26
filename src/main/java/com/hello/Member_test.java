package com.hello;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "JPA_MEMBER_TEST")
public class Member_test {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private String id;
	private String name;

	public Member_test() {
	}

	public Member_test(String name) {
		this.name = name;
	}
}