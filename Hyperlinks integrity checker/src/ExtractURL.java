import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ExtractURL extends Extract {

	public ExtractURL(String Mlink) {
		super(Mlink);
		// TODO Auto-generated constructor stub
	}

	public String[] extractLinks() throws IOException {

		Document doc = Jsoup.connect(getMlink()).get();
		Elements e = doc.select("a[href]"); // extract only links
		URL u = new URL(getMlink());
		String links[] = new String[e.size()];

		for (int i = 0; i < e.size(); i++) {
			String link = e.get(i).attr("href");
			String baseLINK = u.getProtocol() + "://" + u.getHost();
			if (!link.startsWith("http")) {
				link = baseLINK + link;

			}
			links[i] = link;
		}

		return links;
	}
}
