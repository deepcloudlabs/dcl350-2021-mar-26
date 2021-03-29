package com.example.lottery.application;

import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApplication {
	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		ServiceLoader<RandomNumberService> randomNumberServices = 
				ServiceLoader.load(RandomNumberService.class);
		Predicate<Provider<RandomNumberService>> isFast =  
				service -> {
					    var clazz = service.get().getClass();
					    if ( clazz.isAnnotationPresent(Quality.class)) {
					    	var quality = clazz.getAnnotation(Quality.class);
					    	return quality.value().equals(QualityLevel.SECURE);
					    }
					    return false;
					};
		
		var randomNumberService = randomNumberServices.stream().filter(isFast).findFirst().get();
		lotteryService.setRandomNumberService(randomNumberService.get());
		IntStream.range(0, 10)
		         .mapToObj( i -> lotteryService.draw(60, 6))
		         .forEach(System.out::println);
	}
}
