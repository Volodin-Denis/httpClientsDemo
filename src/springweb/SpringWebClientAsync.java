package springweb;

import org.springframework.web.reactive.function.client.WebClient;

public class SpringWebClientAsync {
    private final WebClient webClient;

    public SpringWebClientAsync() {
        this.webClient = WebClient.create("https://jsonplaceholder.typicode.com");
    }

    public void fetch() {
        webClient.get()
            .uri("/posts/1")
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
