package edu.pnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	public List<Board> findByTitleContaining(String title);
}
