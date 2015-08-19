package com.rajesh.galla;

import com.rajesh.galla.utils.ResourceHandler;
import com.rajesh.galla.utils.Utilities;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserSignUp {

    String json;

    public String getResponse() throws IOException {

        final String emailID = Utilities.getEmailID();
        final String name = Utilities.getName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", emailID);
        StringEntity stringEntity = new StringEntity(jsonObject.toString());

        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(ResourceHandler.getResource("url") + "users");
        httpPost.setEntity(stringEntity);

        HttpResponse httpResponse = httpclient.execute(httpPost);
        Assert.assertTrue(httpResponse.getStatusLine().getStatusCode() == 200);
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            json = reader.readLine();
            System.out.println("User Sign up response from server is " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
