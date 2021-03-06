package com.example.mottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberService;

@Service
//@ServiceQuality(QualityLevel.FAST)
@ConditionalOnProperty(name = "quality", havingValue = "fast")
public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int generate(int min, int max) {
		System.err.println("FastRandomNumberService::generate");
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
