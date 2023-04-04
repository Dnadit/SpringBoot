package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board_builder;

public class JPAClient2 {
	
	public static void main(String[] args) {
		System.out.println("JPAClient");
		// EntityManagerFactory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");		
		
		// 데이터를 입력
		insertBoard(emf);
		// id가 1인 데이터 출력
		findBoardOne(emf, 1L);
		// 입력된 전체 데이터를 출력(JPA Query)
		findBoardManyJPAQuery(emf);
		// 입력된 전체 데이터를 출력(Native Query)
		findBoardManyNativeQuery(emf);
		
		emf.close();
	}
	
	private static void insertBoard (EntityManagerFactory emf) {
		System.out.println("insertBoard");
		EntityManager em = emf.createEntityManager();	
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {			
			tx.begin();
			for (int i=1; i <= 10; i++) {
				Board_builder board = Board_builder.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer")
								.createDate(new Date())
								.build();
				em.persist(board);
			}
			// Transaction commit
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();			
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();			
		}
	}
	
	private static void findBoardOne(EntityManagerFactory emf, Long seq) {
		System.out.println("findBoardOne");
		EntityManager em = emf.createEntityManager();
		try {
			Board_builder searchBoard = em.find(Board_builder.class, seq);
			System.out.println("--->" + searchBoard.toString());			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();			
		}
	}
	
	private static void findBoardManyJPAQuery(EntityManagerFactory emf) {
		System.out.println("findBoardManyJPAQuery");
		EntityManager em = emf.createEntityManager();
		String jpql = "select b from Board_builder b order by b.seq desc";		
		
		TypedQuery<Board_builder> result = em.createQuery(jpql, Board_builder.class);
		List<Board_builder> list = result.getResultList();
		// List<Board> list = em.createQuery("select b from board b", Board.class).getResultList();
		for (Board_builder b : list)
			System.out.println("--->" + b);
		em.close();
	}
	
	private static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		System.out.println("findBoardManyNativeQuery");
		EntityManager em = emf.createEntityManager();
		
		// 방법 3-1
		List<?> list1 = em.createNativeQuery("select * from Board_builder", Board_builder.class).getResultList();
		for (Object b : list1)
			System.out.println(b);
		System.out.println("-".repeat(60));
		// 방법 3-2
		@SuppressWarnings("unchecked")
		List<Object[]> list2 = em.createNativeQuery("select * from Board_builder").getResultList();
		for (Object[] b : list2) {
			for (int i = 0; i < b.length; i++) {
				if (i != 0) System.out.print(",");
				System.out.print(b[i]);
			}
			System.out.println();
		}
		System.out.println("=".repeat(80));
		em.close();
	}
}
