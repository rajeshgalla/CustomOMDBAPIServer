package com.rajesh.galla.bo.impl;

import com.rajesh.galla.bo.MovieBO;
import com.rajesh.galla.dao.MovieDAO;
import com.rajesh.galla.utils.PropertiesHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Calendar;

@Component
public class MovieBOImplementation implements MovieBO{

    public MovieBOImplementation() {

    }

    @Autowired
    private MovieDAO movieDAO;

    String json;

    public String searchForMovie(final String movieName, final String token,final Calendar calendar) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                CloseableHttpClient httpclient = HttpClients.createDefault();
                CloseableHttpResponse response = null;

                System.out.println("Searching for movie");
                HttpGet httpGet = new HttpGet(PropertiesHandler.getProperty("url") + "?t=" + movieName );
                try {
                    response = httpclient.execute(httpGet);
                } catch (IOException e) {
                    System.out.println("Unable to execute the GET ");
                    e.printStackTrace();
                }
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    json = reader.readLine();
                    System.out.println("JSON response from server is " + json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                movieDAO.saveTimeStamp(token,calendar);
                File file = new File("tokenTest.txt");
                try {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    fw.write(token);
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Unable to write token to file");
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Unable to join the thread");
            e.printStackTrace();
        }


        System.out.println("returning JSON is " + json);
        return json;
    }
}
