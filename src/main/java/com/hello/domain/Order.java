package com.hello.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_order")
public class Order {

	@Id @GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;


	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItemList = new ArrayList<>();


	private LocalDateTime orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
