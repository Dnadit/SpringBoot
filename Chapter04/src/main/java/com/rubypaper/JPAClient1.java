package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient1 {
	
	public static void main(String[] args) {
		System.out.println("JPAClient");
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAClient");
		
		// 데이터를 입력
		insertBoard(emf);
		
		
	}
	
	private static void insertBoard (EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
	
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			for (int i=1; i <= 10; i++) {
//				if (i == 10) {
//					throw new Exception("예외 강제 발생");
//				}
				Board board = new Board();
				board.setTitle("JPA 제목" + i);
				board.setWriter("관리자");
				board.setContent("JPA 글 등록 잘 되네요.");
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				// 글 등록
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
			emf.close();
		}
	}
	
}
