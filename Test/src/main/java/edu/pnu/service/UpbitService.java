package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.pnu.domain.UpbitTicker;
import edu.pnu.persistence.UpbitRepository;

@Service
public class UpbitService {
	
	private final UpbitRepository upRepo;
	
	@Autowired
	public UpbitService(UpbitRepository upRepo) {
		this.upRepo = upRepo;
	}
	
    @Scheduled(fixedDelay = 60000) // 1분마다 호출
    public void getTicker() {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "https://api.upbit.com/v1/ticker?markets=KRW-BTC";
        UpbitTicker[] response = restTemplate.getForObject(url, UpbitTicker[].class);
        
        System.out.println(response[0]);
        
        upRepo.save(response[0]);
    }   
    
    
   
}
