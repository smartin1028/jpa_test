package com.hello.domain;

import javax.persistence.*;

@Entity
@Table(name = "shop_item")
public class Item {

	@Id @GeneratedValue
	@Column(name = "item_id")
	private Long id;
	private String name;
	private int price;
	private int stockQuantity;

}

