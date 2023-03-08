import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OptimimThreads {

	static int i = 1;
	static int j = 0;
	static ArrayList<Long> timearr = new ArrayList<Long>();
	static String link = "null";
	static int cutoff = 1;

	public void input() {

		if (!link.equals("null")) {

			try {

				optimimThreads();
				for (int i = 0; i < timearr.size(); i++)
					System.out
							.println("Thread number + main thread  " + (i + 2) + " time " + timearr.get(i).toString());
				System.out.println("Number of invalid links " + ValidateURL.invalid);
				ViewTime.newScreen();
				GraphPanel.newScreen();

			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void optimimThreads() throws IOException, InterruptedException {

		long time = start(1, link, cutoff);
		timearr.add(time);
		long currentTime = 0;
		for (i = 2; i < 30; i++) {
			currentTime = start(i, link, cutoff);
			timearr.add(currentTime);
			if (currentTime <= time) {
				time = currentTime;
			} else
				break;
		}
		System.err.println("Current time = " + currentTime + " last Time = " + time + " Number of threads = " + i);
		System.out.println("--------------------------------------------------------------------------------------");

	}

	public static long start(int i, String link, int cutoff) throws IOException, InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(i);
		long start = System.currentTimeMillis();

		ValidateURL v = new ValidateURL();
		v.validationURL(i, link, 0, cutoff);

		System.out.println(Thread.activeCount());

		while (Thread.activeCount() > 2) {
			// System.out.println("I am waiting");
		}
		executor.shutdown();

		System.out.println(Thread.activeCount() + Thread.currentThread().getName());
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println(end - start);

		return time;
	}
}
