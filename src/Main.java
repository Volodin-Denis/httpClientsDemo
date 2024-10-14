import apachehc.ApacheHttpClientAsync;
import apachehc.ApacheHttpClientSync;
import javaclient.JavaHttpClientAsync;
import javaclient.JavaHttpClientSync;
import springweb.SpringWebClientAsync;
import springweb.SpringWebClientSync;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting synchronous requests...");
        new ApacheHttpClientSync().fetch();
        new JavaHttpClientSync().fetch();
        new SpringWebClientSync().fetch();

        System.out.println("Starting asynchronous requests...");
        new ApacheHttpClientAsync().fetch();
        new JavaHttpClientAsync().fetch();
        new SpringWebClientAsync().fetch();

        Thread.sleep(5000);
    }
}
