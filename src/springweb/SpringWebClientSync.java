package springweb;

import org.springframework.web.reactive.function.client.WebClient;

public class SpringWebClientSync {
    private final WebClient webClient;

    public SpringWebClientSync() {
        this.webClient = WebClient.create("https://jsonplaceholder.typicode.com");
    }

    public void fetch() {
        String responseBody = webClient.get()
            .uri("/posts/1")
            .retrieve()
            .bodyToMono(String.class)
            .block();
        System.out.println(responseBody);
    }
}
