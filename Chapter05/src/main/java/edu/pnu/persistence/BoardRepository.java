package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Board;

// Spring Boot가 컴파일 할 때 Body를 추가하여 컴파일 한다 ?
// JPARepository는 대표적으로 페이징 기능을 제공함.
public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitleContaining(String s);
	List<Board> findByTitleContainingAndCntGreaterThan(String s, Long n);
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderByCntAsc(Long n1, Long n2);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String s1, String s2);
	
	//@Query("select b from Board b")
	@Query(value = "select * from board", nativeQuery = true)
	List<Board> queryAnnotationTest(Pageable paging);
	
//	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
//	List<Board> queryAnnotationTest(@Param("searchKeyword") String searchKeyword, Pageable paging);
	
}
