import java.io.IOException;

public class Threads extends Thread {

	private String link;
	private int depth;
	private int cutoff;

	public Threads(String link, int depth, int cutoff) {

		this.link = link;
		this.depth = depth;
		this.cutoff = cutoff;

	}

	@Override
	public void run() {
		ValidateURL validateURL = new ValidateURL();

		try {
			validateURL.validationURL(OptimimThreads.i, link, depth, cutoff);
		} catch (IOException | InterruptedException e) {

			e.printStackTrace();
		}

	}
}
