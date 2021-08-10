package network.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * A complete Java class that demonstrates how to read content (text) from a URL
 * using the Java URL and URLConnection classes.
 * @author alvin alexander, alvinalexander.com
 */
public class UrlReader_JavaCore {
  public static void main(String[] args) {
    String output  = getUrlContents("https://www.utg.gm/login");
    System.out.println(output);
  }

  private static String getUrlContents(String theUrl) {
    StringBuilder content = new StringBuilder();

    try  {
      URL url = new URL(theUrl);

      URLConnection urlConnection = url.openConnection();

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

      String line;

      while ((line = bufferedReader.readLine()) != null) {
        content.append(line + "\n");
      }
      bufferedReader.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return content.toString();
  }
}
