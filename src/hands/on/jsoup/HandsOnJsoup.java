/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hands.on.jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Watchanan
 */
public class HandsOnJsoup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www3.reg.cmu.ac.th/transcript/").get();
            String docTitle = doc.title();
            System.out.println(docTitle);
            Element updateAt = doc.select("p#update-at").first();
            System.out.println(updateAt.text());
        } catch (IOException e) {
        }
    }

}
