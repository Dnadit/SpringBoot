package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UpbitTicker {
	@Id
    private String market;
    private String trade_date;
    private Double opening_price;
    private Double high_price;
    private Double low_price;
    private Double trade_price;
   
}
