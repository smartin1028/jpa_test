package com.hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainByTableSeq {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			System.out.println("=============================");

			MemberByTableSeq member = new MemberByTableSeq("Hello");

			em.persist(member);
			em.persist(new MemberByTableSeq( "Hello2"));
			em.persist(new MemberByTableSeq( "Hello3"));

			member.setName("h1");

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
