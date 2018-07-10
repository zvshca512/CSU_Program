package ReadFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage {

    String[] aryS;
    URL url;
    
    public void read() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\Github\\CSU_Program\\ReadFile\\file\\image.txt"); //read file
        BufferedReader br = new BufferedReader(fr);
        String message = "", eachLine = "";
        while ((eachLine = br.readLine()) != null) {
            message += eachLine + " ";
        }
        aryS = message.split(" ");
        String downloadDir = "C:\\Github\\CSU_Program\\ReadFile\\imagesU\\";
        try {    
            for (int k = 0; k < aryS.length; k++) {
                
                url = new URL(aryS[k]);
                java.net.HttpURLConnection uc = (java.net.HttpURLConnection) url.openConnection();
                uc.setRequestProperty("User-agent", "IE/6.0");
                uc.setReadTimeout(10000);// 設定timeout時間
                uc.connect();// 連線
//                System.out.println("網址/ip位置:"+java.net.Inet4Address.getByName(url.getHost()));
                int status = uc.getResponseCode();
                System.out.println(status);
                switch (status) {
                case java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT://504
                System.out.println("連線網址逾時!");
                break;
                case java.net.HttpURLConnection.HTTP_FORBIDDEN://403
                System.out.println("連線網址禁止!");
                break;
                case java.net.HttpURLConnection.HTTP_INTERNAL_ERROR://500
                System.out.println("連線網址錯誤或不存在!");
                break;
                case java.net.HttpURLConnection.HTTP_NOT_FOUND://404
                System.out.println("連線網址不存在!");
                break;
                case java.net.HttpURLConnection.HTTP_MOVED_TEMP://302
                System.out.println("連線網址不存在!");
                break;
                case java.net.HttpURLConnection.HTTP_OK:
                System.out.println("OK!");
                
                break;
                 }
                String FILENAME = downloadDir + "\\" + (k+1) + ".jpg";//(aryS[k].length()-4);      //生成新的照片名  
                System.out.println(FILENAME);
                OutputStream os = new FileOutputStream(FILENAME, false);  // 开始读取  
//                FileOutputStream fos = new FileOutputStream(aryS[k].substring(aryS[k].length()-14),false); //pic[k].substring(pic[k].length()-14),   
//                OutputStream os = new FileOutputStream(downloadDir+aryS[k].substring(aryS[k].length()-14),false);  //開始讀取            
//                System.out.println(aryS[k +1 ]);
                InputStream is = url.openStream();
//                System.out.println("Downloading:" + (k + 1));
                int chunkSize = 1024 * 8;
                byte[] buf = new byte[chunkSize];
                int readLen;
                while ((readLen = is.read( buf, 0, buf.length)) != -1) {
                    os.write(buf, 0, readLen);
                }
                is.close();
                os.close();
                
            }
            System.out.println("Download Finished. ");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    
//    public void s(){
//    try {
//            java.net.URL url = new java.net.URL(
//                    "http://www.onera.fr/onera-business/images/019-helice-anibal.jpg");
//            java.net.HttpURLConnection uc = (java.net.HttpURLConnection) url
//                    .openConnection();
//            uc.setRequestProperty("User-agent", "IE/6.0");
//            uc.setReadTimeout(1000);// 設定timeout時間
//            uc.connect();// 連線
//            System.out.println("網址/ip位置:"+java.net.Inet4Address.getByName(url.getHost()));
//            int status = uc.getResponseCode();
//            System.out.println(status);
//            switch (status) {
//            case java.net.HttpURLConnection.HTTP_GATEWAY_TIMEOUT://504
//                System.out.println("連線網址逾時!");
//                break;
//            case java.net.HttpURLConnection.HTTP_FORBIDDEN://403
//                System.out.println("連線網址禁止!");
//                break;
//            case java.net.HttpURLConnection.HTTP_INTERNAL_ERROR://500
//                System.out.println("連線網址錯誤或不存在!");
//                break;
//            case java.net.HttpURLConnection.HTTP_NOT_FOUND://404
//                System.out.println("連線網址不存在!");
//                break;
//            case java.net.HttpURLConnection.HTTP_MOVED_TEMP://404
//                System.out.println("連線網址不存在!");
//                break;    
//            case java.net.HttpURLConnection.HTTP_OK:
//                System.out.println("OK!");
//                break;
// 
//            }
// 
//        } catch (java.net.MalformedURLException e) {
//            System.out.println("網址格式錯誤!!!");
//            e.printStackTrace();
//        } catch (java.io.IOException e) {
//            System.out.println("連線有問題!!!!!!");
//            e.printStackTrace();
//        }    
//    }
//    
    public static void main(String[] args) throws IOException {
        DownloadImage di = new DownloadImage();
        di.read();
//        di.s();
         
    }

}
