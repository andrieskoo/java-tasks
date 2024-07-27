package utils;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class APIUtils {
    private static final String baseUrl = "https://jsonplaceholder.typicode.com";

    public String get(String url){
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(baseUrl + url);
            try(CloseableHttpResponse httpResponse = (CloseableHttpResponse) httpClient.execute(httpGet)){
               HttpEntity entity = httpResponse.getEntity();
               return EntityUtils.toString(entity);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String post(String url, String body){
        try(CloseableHttpClient httpClient = HttpClients.createDefault() ){
            HttpPost httpPost = new HttpPost(baseUrl + url);
            StringEntity entity = new StringEntity(body);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(entity);
            try(CloseableHttpResponse httpResponse = httpClient.execute(httpPost)){
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String patch(String url, String body){
        try(CloseableHttpClient httpClient = HttpClients.createDefault() ){
            HttpPatch httpPatch = new HttpPatch(baseUrl + url);
            StringEntity entity = new StringEntity(body);
            httpPatch.setHeader("Accept", "application/json");
            httpPatch.setHeader("Content-type", "application/json");
            httpPatch.setEntity(entity);
            try(CloseableHttpResponse httpResponse = httpClient.execute(httpPatch)){
                return EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int delete(String url){
        try(CloseableHttpClient httpClient = HttpClients.createDefault() ){
            HttpDelete httpDelete = new HttpDelete(baseUrl + url);
            httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-type", "application/json");
            try(CloseableHttpResponse httpDeleteResponse = httpClient.execute(httpDelete)){
                System.out.println("httpDeleteResponse = " + httpDeleteResponse);
                return httpDeleteResponse.getStatusLine().getStatusCode();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
