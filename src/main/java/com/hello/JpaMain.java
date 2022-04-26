package com.hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			System.out.println("=============================");

//			Member member = new Member("Hello");
//
//			em.persist(member);
//			em.persist(new Member( "Hello2"));
//			em.persist(new Member( "Hello3"));
//
//			member.setName("h1");

//			List<Member> resultList = em.createQuery("select m from  Member  m", Member.class).getResultList();
			System.out.println("=============================");

			tx.commit();


		} catch (Exception e) {
			tx.rollback();
		}finally {
		}
		em.close();
		emf.close();








	}
}
