package Controller;

import java.io.*;

import java.net.*;


public class NetworkController {
    private static final String GET_URL="http://localhost:8080/api/rank";
    URL url;
    public  NetworkController(){
        try{
            url   = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println(response);
            in.close();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }



}
