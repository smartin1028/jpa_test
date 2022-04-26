package com.hello;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "jpa_team")
public class Team {
	@Id @GeneratedValue
	@Column(name="team_id")
	private Long id;
	private String name;

//	@OneToMany
//	List<Member> memberList = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	public Team() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
