package apachehc;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApacheHttpClientSync {
    public void fetch() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");
            CloseableHttpResponse response = client.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
