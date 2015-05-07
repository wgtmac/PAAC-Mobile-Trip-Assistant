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
  
public class HttpUtil {  
    private HttpClient mClient;  
    private HttpResponse mRes = null;  
    private String method, url;  
    private JSONObject json,data;  
    private static final String errorMessage = "Something wrong!";  
    private static final String invalidKeyMessage = "no such key exists!";    
    public HttpUtil(String method, String url){  
        this.method = method;  
        this.url = url;  
    }  
    public void excute(){  
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
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
    /* 
     * 检查返回值是否有效，检查json值是否有效 
     */  
    private boolean checkValid(){  
        return mRes == null || json == null;  
    }  
    /* 
     * 取得服务端回复的状态. 
     */  
    public String getStatus(){  
        if (checkValid()) return errorMessage;  
        return mRes.getStatusLine().toString();  
    }  
    /* 
     * 取得状态码 
     */  
    public String getStatusCode(){  
        if (checkValid()) return errorMessage;  
        return Integer.valueOf(mRes.getStatusLine().getStatusCode()).toString();  
    }  
    /* 
     * 取得返回的message信息 
     */  
    public String getMessage(){  
        if (checkValid()) return errorMessage;  
        try {  
            return json.getString("message");  
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return errorMessage;  
    }  
    /* 
     * 返回整个data信息，字符串表示 
     */  
    public String getDataString(){  
        if (checkValid()) return errorMessage;  
        return data.toString();  
    }  
    /* 
     * 默认返回数据是json格式，主json中有一个子树data，默认data是我们的要处理的json数据 
     * 此处返回data的一个键key的值 
     */  
    public String getDataItem(String key){  
        if (checkValid()) return errorMessage;  
        if (data.isNull(key)) return key+": "+invalidKeyMessage;  
        try {  
            return data.getString(key);  
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return errorMessage;  
    }  
    
    
    public static void main(String[] args) {
    	String method = "GET";  
    	String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
    	String url = server_url + "gettime?key=E9FnEmgTkNcyY6nrJAkzXBZeR&format=json";
    	HttpUtil hu = new HttpUtil(method, url);
    	hu.excute();  
    }
}  
