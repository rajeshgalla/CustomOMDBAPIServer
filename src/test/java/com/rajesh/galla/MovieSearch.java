package com.rajesh.galla;

import com.rajesh.galla.utils.ResourceHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieSearch {

    UserSignUp userSignUp;

    @Test
    public void movieSearch() throws IOException {

        MovieSearch movieSearch = new MovieSearch();
        movieSearch.userSignUp = new UserSignUp();
        String json = movieSearch.userSignUp.getResponse();
        JSONObject jsonObject = new JSONObject(json);
        String token = jsonObject.getString("token");
        HttpGet httpGet = new HttpGet(ResourceHandler.getResource("url")+"movies/Titanic?token=" + token);
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            json = reader.readLine();
            System.out.println("Movie Search response from server is " + json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
