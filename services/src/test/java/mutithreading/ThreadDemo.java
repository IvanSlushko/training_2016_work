package mutithreading;

public class ThreadDemo {
	public static void main(String[] args) {
		Talk talk = new Talk();
		Thread walk = new Thread(new Walk());
		walk.setDaemon(true);

		talk.start();
		walk.start();

		System.out.println("Done!!!");
		// Walk w = new Walk(); // просто объект, не поток
		// w.run(); //выполнится метод, но поток не запустится!
	}
}