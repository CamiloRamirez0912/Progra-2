package co.edu.uptc.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ManagerPeople {
    private int statusCode;
    private String responseString;
    public void loadPeople(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/prog2/202214307/people/all")).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode =  response.statusCode();
            responseString = response.body();
            if (statusCode ==200) {
                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Person>cloneList=
                mapper.readValue(responseString, new TypeReference<ArrayList<Person>>(){});

                for (Person person : cloneList) {
                    System.out.println(person.getName());
                }
            }else{
                Gson gson = new Gson();
                ErrorResponsive error = gson.fromJson(responseString, ErrorResponsive.class);
                System.out.println(error.getMessage());
            }


            System.out.println(statusCode);
            System.out.println(responseString);
        } catch (Exception e) {
            
        }
        

    }
}
