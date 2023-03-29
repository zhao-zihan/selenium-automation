package Scenarios;

import java.io.*;
import java.net.URL;

public class URLDownloader {

    public static void downloadURL(String urlString, String fileName) throws IOException {
        URL url = new URL(urlString);
        try (InputStream inp = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(inp);
             FileOutputStream fops = new FileOutputStream(fileName)){

            byte[] d = new byte[1024];
            int i;
            while ((i = bis.read(d, 0, 1024)) != -1){
                fops.write(d, 0, i);
            }
        }
    }

}