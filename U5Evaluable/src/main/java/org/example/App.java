package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Document doc = Jsoup.connect("https://www.elcorteingles.es/ordenadores-baratos/electronica/").get();
            Elements links = doc.getElementsByClass("js_product_preview product_preview   _on_sale js_has_bazaar_voice  c12");
             for (Element link: links) {
                System.out.print(link.getElementsByClass("product_preview-desc").text() + " ");
                System.out.println(link.getElementsByClass("price _big _sale").text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
