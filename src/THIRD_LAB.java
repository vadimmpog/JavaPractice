import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class THIRD_LAB {




        public static void CreateJPG(URL url, int count){
            HttpURLConnection urlconn;
            try {
                urlconn = (HttpURLConnection) url.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.connect();
                InputStream in = null;
                in = urlconn.getInputStream();
                OutputStream writer = new FileOutputStream("C://Users//VADIM//Documents//Workspace//pop//"+count+".jpg");
                byte buffer[] = new byte[10];
                int c = in.read(buffer);
                while (c > 0) {
                    writer.write(buffer, 0, c);
                    c = in.read(buffer);
                }
                writer.flush();
                writer.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void GetImages(String s0, String s){
            String s1;
            int count= 1;
            try {
                Document doc = Jsoup.connect(s0).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get() ;
                Elements images = doc.select("div.row");
                for(Element element : images.select("img[src$=.jpg]")){
                    s1 = element.attr("src");
                    URL url = new URL(s+s1);
                    CreateJPG(url,count);
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        public static void main(String[] args) {
            String s = "https://student.mirea.ru", s0 = "https://student.mirea.ru/media/photo/?ELEMENT_ID=25#photoDetails";// сайт и альбом
            int count = 1;
            GetImages(s0,s);
        }

    }

