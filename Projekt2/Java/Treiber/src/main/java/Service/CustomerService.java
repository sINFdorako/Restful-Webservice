package Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Customer;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Objects;

public class CustomerService {

    public static Customer get(int id) throws IOException {

        URI uri = Service.buildURI("/config/Customer" + id);

        CloseableHttpClient httpclient = HttpClients.createDefault();


        //make a new request
        HttpGet request = new HttpGet(uri);

        try {
            //execute request
            CloseableHttpResponse response = httpclient.execute(request);

            //make sure a customer with the given id was found
            if (response.getStatusLine().getStatusCode() == 404) {
                return null;
            }

            //get response body
            String responseJSON = EntityUtils.toString(Objects.requireNonNull(response).getEntity());
            response.close();

            //Map json to object
            return new ObjectMapper().readValue(responseJSON, Customer.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Customer create(Customer c) {
        URI uri = Service.buildURI("config/Customer");

        CloseableHttpClient httpclient = HttpClients.createDefault();

        //convert customer to json
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpPost request = new HttpPost(uri);
        try {
            //add the body
            request.setEntity(new StringEntity(json));
            request.setHeader("Content-type", "application/json");

            //execute
            CloseableHttpResponse response = httpclient.execute(request);

            //something went wrong
            if (response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200) {
                return null;
            }

            //parse body and return new customer (including id)
            String responseJSON = EntityUtils.toString(Objects.requireNonNull(response).getEntity());
            response.close();
            return new ObjectMapper().readValue(responseJSON, Customer.class);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
