package com.hello;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "JPA_MEMBER")
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR_01",
		sequenceName = "MEMBER_SEQ_01",	// 매핑할 데이터베이스 시퀀스 이름
		initialValue = 1, allocationSize = 1
//		, allocationSize = 50
)
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
	,generator = "MEMBER_SEQ")
	private Long id;
//	@Column(unique = true, length = 10)
	@Column(name = "username", columnDefinition = "varchar(100) default 'empty'")
	private String name;
	private int age1;

//	@Column(name="team_id")
//	private Long teamId;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	private LocalDateTime createDate;

	private LocalDateTime updateDate;

	@Temporal(TemporalType.TIME)
	private Date createDateT;

	private LocalDate localDate;



	@Lob
	private String description;

	// 매핑 안하는 컬럼
	@Transient
	private String tmp;

	public Member() {
	}

	public Member(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void changeTeam(Team team) {
		this.team = team;
		this.team.getMemberList().add(this);
	}

	public Team getTeam() {
		return team;
	}

	public Long getId() {
		return id;
	}
}