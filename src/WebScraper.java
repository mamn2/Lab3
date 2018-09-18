import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordIterations(String text, String word) {
        String[] arrayOfText = text.split("\\s+");
        int counter = 0;
        for (int i = 0; i < arrayOfText.length; i++) {
            if (arrayOfText[i].equals(word)) {
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] unused) {
        String text = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String[] textArray = text.split("\\s+");
        int wordCount= textArray.length;

        System.out.println(wordCount);
        System.out.println(wordIterations(text, "and"));

    }
}
