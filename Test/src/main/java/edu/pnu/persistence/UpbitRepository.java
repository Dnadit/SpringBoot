package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.UpbitTicker;

public interface UpbitRepository extends JpaRepository<UpbitTicker, String> {

}
