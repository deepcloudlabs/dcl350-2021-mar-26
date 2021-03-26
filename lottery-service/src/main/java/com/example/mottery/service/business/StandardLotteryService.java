package com.example.mottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

//@Service
//@Named
//@Singleton
public class StandardLotteryService implements LotteryService {

	// @Autowired
	private RandomNumberService service;

	public StandardLotteryService(RandomNumberService service) {
		this.service = service;
	}

	/*
	 * @Value("${service.name}") private String serviceName;
	 * 
	 * @Autowired
	 * 
	 * @ServiceQuality(QualityLevel.FAST) private RandomNumberService
	 * randomNumberService;
	 * 
	 * @Autowired private Map<String,RandomNumberService> services; private
	 * AtomicInteger counter = new AtomicInteger();
	 * 
	 * @PostConstruct public void init() { services.entrySet().forEach(entry ->
	 * System.err.println(entry.getKey()+": "+entry.getValue().getClass().
	 * getSimpleName())); }
	 */
	@Override
	public List<Integer> draw(int max, int size) {
		// int index = counter.getAndIncrement() % services.size();
		// var service = services.get(index ); // round-robin
		// var service = services.get(serviceName);
		return IntStream.generate(() -> service.generate(1, max)).distinct().limit(size).sorted().boxed()
				.collect(Collectors.toList());
	}

}
