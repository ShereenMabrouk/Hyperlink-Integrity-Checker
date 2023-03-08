import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidateURL {
	static int h = 0;
	static int invalid = 0;
	static int valid = 0;

	public void validationURL(int j, String link, int currentdepth, int totaldepth)
			throws IOException, InterruptedException {
		Thread t1;
		ExecutorService executor = Executors.newFixedThreadPool(j);
		int x = validateSingleURL(link);
		if (x != -1) {
			ExtractText extractTxt = new ExtractText(link);
			System.out.println("Valid Link " + (h++) + " " + Thread.currentThread().getName() + " " + link + "\nText:"
					+ extractTxt.getText());
			valid++;
			if (currentdepth == totaldepth) {

				return;

			}
			if (x != 0) {
				ExtractURL extract = new ExtractURL(link);
				String[] links = extract.extractLinks();
				System.err.println("Count of Links:" + (links.length));

				for (int i = 0; i < links.length; i++) {
					t1 = new Threads(links[i], currentdepth + 1, totaldepth);
					executor.execute(t1);
				}
			}
		} else {
			invalid++;
			System.err.println("Invalid Link " + (h++) + Thread.currentThread().getName() + " " + link);
		}
		executor.shutdown();

	}

	public int validateSingleURL(String link) throws IOException {
		int valid = -1;
		try {
			Jsoup.connect(link).get();
			valid = 1;
		} catch (HttpStatusException ex) { // when returns 404 page not found

			valid = -1;
		} catch (IOException ex) { // when timeout to connect to server not found

			valid = -1;
		} catch (IllegalArgumentException ex) {

			valid = -1;
		}
		if (valid == -1) {
			if (pdf(link))
				valid = 0;
			else
				valid = -1;
		}

		return valid;
	}

	public boolean pdf(String link) {
		URL u = null;
		try {
			u = new URL(link);
		} catch (MalformedURLException e) {

		} catch (Exception e) {
		}

		URLConnection x = null;
		try {
			x = u.openConnection();
			if (x.getContentType() != null) {
				if (x.getContentType().startsWith("application"))
					return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		} catch (Exception e) {
		}

		return false;
	}
}
