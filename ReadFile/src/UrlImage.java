
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.HttpURLConnection;
import java.net.URL;  
import java.net.URLConnection; 

public class UrlImage {
 
        public static void main(String[] args) throws Exception {  
        // TODO Auto-generated method stub  
//         download("http://www2.gpmd.com/imagem/m/mmasq1634.jpg", "51bi.gif","c:\\image\\");  
        UrlImage u = new UrlImage();
        u.isConnect("http://static.flickr.com/51/151202443_5e9b5b91ca.jpg");
    }  
      
    private static URL url;  
private static HttpURLConnection con;  
private static int state = -1;  
  
/** 
   * 功能：检测当前URL是否可连接或是否有效, 
   * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用 
   * @param urlStr 指定URL网络地址 
   * @return URL 
   */  
public synchronized URL isConnect(String urlStr) {  
   int counts = 0;  
   if (urlStr == null || urlStr.length() <= 0) {                         
    return null;                   
   }  
   while (counts < 5) {  
    try {  
     url = new URL(urlStr);  
     con = (HttpURLConnection) url.openConnection();  
     state = con.getResponseCode();  
     System.out.println(counts +"= "+state);  
     if (state == 200) {  
      System.out.println("URL可用！");  
     }  
     break;  
    }catch (Exception ex) {  
     counts++;   
     System.out.println("URL不可用，连接第 "+counts+" 次");  
     urlStr = null;  
     continue;  
    }  
   }  
   return url;  
}  
  
} 

