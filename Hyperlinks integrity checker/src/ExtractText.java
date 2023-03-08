import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ExtractText extends Extract {

	public ExtractText(String Mlink) {
		super(Mlink);
		// TODO Auto-generated constructor stub
	}

	public String getText() throws IOException {
		String x;
		try {
			Document doc = Jsoup.connect(getMlink()).get();
			x = doc.title();
		} catch (Exception ex) {
			return " ";

		}
		return x;
	}
}
