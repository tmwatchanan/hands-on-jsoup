/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hands.on.jsoup;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Connection;
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
            Connection conn = Jsoup.connect("https://www3.reg.cmu.ac.th/transcript/");
            Document doc = conn.get();
            
            String docTitle = doc.title();
            System.out.println(docTitle);
            Element updateAt = doc.select("#update-at").first();
            String updateAtMessage = updateAt.text();
            System.out.println(updateAtMessage);
            String targetUpdateAtMessage = "ข้อมูลอัพเดทเมื่อวันที่ 23 ธันวาคม 2560";
//            if (updateAtMessage == targetUpdateAtMessage) {
//                System.out.println(true);
//            }
            System.out.println(updateAtMessage == targetUpdateAtMessage);
            
            Element captcha = doc.select(".hashimg").first();
            if (captcha == null) {
                throw new RuntimeException("CAPTCHA not found!");
            }
            // Fetch the captcha image
            Connection.Response response = Jsoup //
                .connect(captcha.absUrl("src")) // Extract image absolute URL
                .cookies(conn.response().cookies()) // Grab cookies
                .ignoreContentType(true) // Needed for fetching image
                .execute();
            // Load captcha image from Jsoup response
            ImageIcon image = new ImageIcon(ImageIO.read(new ByteArrayInputStream(response.bodyAsBytes())));
            // Show captcha image
            JOptionPane.showMessageDialog(null, image, "Captcha image", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
