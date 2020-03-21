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




        public static void CreateJPG(URL url, int count,String path){
            HttpURLConnection urlconn;
            try {
                urlconn = (HttpURLConnection) url.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.connect();
                InputStream in = null;
                in = urlconn.getInputStream();
                OutputStream writer = new FileOutputStream(path+"//"+count+".jpg");
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
            String s1,s2,name,path = "";
            int count;
            try {
                Document doc = Jsoup.connect(s0).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get() ;
                Elements albums = doc.select("div.js-slide");
                for(Element element : albums.select("div.js-slide")){
                    count = 1;
                    name = element.select("h3.h3").text();
                    name = name.replaceAll("\"","");
                    File file = new File("F://Workspace//Photos//"+name);
                    path = file.getAbsoluteFile().toString();

                    if(!file.exists()) {
                        file.mkdir();
                    }
                    s1 = element.select("a[href$=Details]").attr("href");
                    s2 = s+s1;
                    Document doc2 = Jsoup.connect(s2).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get() ;
                    Elements images = doc2.select("div.row");
                    for(Element element2 : images.select("img[src$=.jpg]")){
                        s1 = element2.attr("src");
                        URL url = new URL(s+s1);
                        CreateJPG(url,count,path);
                        count++;
                    }
                }




            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            String s = "https://student.mirea.ru", s0 = "https://student.mirea.ru/media/photo/";//Достать ссылку на альбом, создать папку с именем альбома, скачать все туда
            int count = 1;
            GetImages(s0,s);
        }

    }

