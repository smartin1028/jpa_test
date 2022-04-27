package com.hello.run;

import com.hello.Member;
import com.hello.Team;
import com.hello.domain.Order;
import com.hello.domain.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ShopMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			System.out.println("=============================");

			Order order = new Order();
			em.persist(order);

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);

			em.persist(orderItem);



			System.out.println("=============================");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

}
