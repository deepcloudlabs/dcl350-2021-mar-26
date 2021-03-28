package com.example.application;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

public class ReactiveApplication {

	public static void main(String[] args) {
		try(SubmissionPublisher<TradeEvent> publisher = new SubmissionPublisher<>()){
			Flow.Subscriber<TradeEvent> slowSubscriber = new AlgoTrader();
			Flow.Subscriber<TradeEvent> fastSubscriber = new SignalProcessor();
			publisher.subscribe(slowSubscriber);
			publisher.subscribe(fastSubscriber);
			
			var trades = List.of(new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
					new TradeEvent("MSFT", 102.0, 70), new TradeEvent("ORCL", 103.0, 80),
					new TradeEvent("MSFT", 104.0, 90));
			trades.forEach(publisher::submit);			
		}
		try {TimeUnit.SECONDS.sleep(60);} catch (InterruptedException e) {}
	}

}

class AlgoTrader implements Flow.Subscriber<TradeEvent> {
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(2);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) {}
		System.err.println(Thread.currentThread().getName()+" - AlgoTrader::"+event);
		subscription.request(2);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error in AlgoTrader: "+throwable.getMessage());
		
	}

	@Override
	public void onComplete() {
		System.err.println("AlgoTrader is done.");
	}

}
class SignalProcessor implements Flow.Subscriber<TradeEvent> {
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(2);
	}
	
	@Override
	public void onNext(TradeEvent event) {
		System.err.println(Thread.currentThread().getName()+" - SignalProcessor::"+event);
		subscription.request(2);
	}
	
	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error in SignalProcessor: "+throwable.getMessage());
		
	}
	
	@Override
	public void onComplete() {
		System.err.println("SignalProcessor is done.");
	}
	
}