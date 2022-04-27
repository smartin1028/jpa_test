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
			Team team = new Team("teamA");
			em.persist(team);

			Member member = new Member("name");
			member.changeTeam(team);

			em.persist(member);

			Member member2 = new Member("name2");
			member2.changeTeam(team);
			em.persist(member2);


//
//			em.flush();
//			em.clear();

			Member member1 = em.find(Member.class, member.getId());
			List<Member> memberList = member1.getTeam().getMemberList();
			for (Member member3 : memberList) {
				System.out.println("member3 = " + member3.getTeam().getName());
			}

//			Team team1 = em.find(Team.class, member.getTeam().getId());
//			System.out.println("team1.getName() = " + team1.getName());





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
