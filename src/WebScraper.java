import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println("SKRT");

        String webText = urlToString("http://erdani.com/tdpl/hamlet.txt");

        //System.out.println(webText);

        String[] words = webText.split(" ");

        System.out.println("The number of words is: " + words.length);

        String word = "the";
        int wordCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                wordCount++;
            }
        }

        System.out.println("The number of times the word " + word + " appears is: " + wordCount);
    }


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
}