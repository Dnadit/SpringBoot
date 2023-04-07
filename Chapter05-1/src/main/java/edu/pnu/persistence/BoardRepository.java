package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String title);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String Title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}
