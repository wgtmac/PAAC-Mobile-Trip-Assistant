package controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleDirectionAPI {
	private HttpClient mClient;  
    private HttpResponse mRes = null;  
    private String method, url;  
    private JSONObject json,data;  
    private static final String errorMessage = "Something wrong!";  
    private static final String invalidKeyMessage = "no such key exists!";
    
    public GoogleDirectionAPI(String method, String url) {
    	this.method = method;  
        this.url = url; 
    }
    
    public void execute() {
    	mClient = HttpClientBuilder.create().build();  
        try {  
            switch(method){  
            case "GET":  
                mRes = mClient.execute(new HttpGet(url));  
                break;  
            case "POST":  
                mRes = mClient.execute(new HttpPost(url));  
            }  
            
            json = new JSONObject(EntityUtils.toString(mRes.getEntity())); 
            System.out.println(json);
            data = json.getJSONObject("bustime-response");  
            
            
            
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }
    }
    
    
    public static void main(String[] args) {
    	String method = "GET";  
    	String server_url = "http://maps.googleapis.com/maps/api/directions/";
    	String url = server_url + "json?origin=Brooklyn&destination=Queens&sensor=false&departure_time=1343605500&mode=transit";
    	GoogleDirectionAPI hu = new GoogleDirectionAPI(method, url);
    	hu.execute();  
    }
}
