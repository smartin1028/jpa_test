package com.hello;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "JPA_MEMBER_BY_TABLE_SEQ")
@TableGenerator(
		name = "MEMBER_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnValue = "MEMBER_SEQ"
//		, allocationSize = 1
)
public class MemberByTableSeq {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,
			generator = "MEMBER_SEQ_GENERATOR")
	private Long id;
//	@Column(unique = true, length = 10)
	@Column(name = "username", columnDefinition = "varchar(100) default 'empty'")
	private String name;
	private int age;

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

	public MemberByTableSeq() {
	}

	public MemberByTableSeq(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}