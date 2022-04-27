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

	public List<Member> getMemberList() {
		return memberList;
	}

	// team으로 매핑된것
	@OneToMany(mappedBy = "team")
	List<Member> memberList = new ArrayList<>();

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
