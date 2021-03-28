package com.example.application;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class LegacyObserverApplication {

	public static void main(String[] args) {
		Observable observable = new TradeEventObservable();
		Observer slowObserver = (o, trade) -> {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
			}
			System.err.println("Slow observer: " + trade);
		};
		Observer fastObserver = (o, trade) -> {
			System.err.println("Fast observer: " + trade);
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		var trades = List.of(new TradeEvent("ORCL", 100.0, 50), new TradeEvent("IBM", 101.0, 60),
				new TradeEvent("MSFT", 102.0, 70), new TradeEvent("ORCL", 103.0, 80),
				new TradeEvent("MSFT", 104.0, 90));
		trades.forEach(observable::notifyObservers);
	}

}

@SuppressWarnings("deprecation")
class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}

}