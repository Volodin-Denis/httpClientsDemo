package apachehc;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

public class ApacheHttpClientAsync {
    public void fetch() {
        try (CloseableHttpAsyncClient client = HttpAsyncClients.createDefault()) {
            client.start();
            HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");
            Future<org.apache.http.HttpResponse> future = client.execute(request, null);
            byte[] response = future.get().getEntity().getContent().readAllBytes();
            System.out.println(new String(response, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
