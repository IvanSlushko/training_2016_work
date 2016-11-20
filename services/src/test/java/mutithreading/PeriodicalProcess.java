package mutithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodicalProcess {

	public static void main(String[] args) {

		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("Processing!!!!!");
			}
		};

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(task, 5, 5, TimeUnit.SECONDS);

	}
}