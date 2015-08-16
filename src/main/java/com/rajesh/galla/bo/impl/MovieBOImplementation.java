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
import java.util.HashMap;
import java.util.Map;

@Component
public class MovieBOImplementation implements MovieBO{

    public MovieBOImplementation() {
        movieToResponse = new HashMap<String,String>();
    }

    @Autowired
    private MovieDAO movieDAO;

    String json;
    Map<String,String> movieToResponse;
    public String searchForMovie(final String movieName, final String token,final Calendar calendar) {

        movieDAO.saveQuery(token, movieName, calendar);

        if (movieToResponse.containsKey(movieName)) {
            System.out.println("returning cached JSON : " + movieToResponse.get(movieName));
            return movieToResponse.get(movieName);
        }
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
            movieToResponse.put(movieName,json);
            System.out.println("JSON response from server is " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("returning JSON is " + json);
        return json;
    }
}
