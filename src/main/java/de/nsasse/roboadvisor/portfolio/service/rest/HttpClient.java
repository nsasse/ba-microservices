package de.nsasse.roboadvisor.portfolio.service.rest;

import de.nsasse.roboadvisor.portfolio.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class HttpClient {

    //TODO Build Frontend Listener
    public void sendProductToFrontend(Product product) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI url = new URI("http://localhost:4201");

            HttpEntity<Product> request = new HttpEntity<>(product);
            ResponseEntity<Product> response = restTemplate
                    .exchange(url, HttpMethod.POST, request, Product.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
