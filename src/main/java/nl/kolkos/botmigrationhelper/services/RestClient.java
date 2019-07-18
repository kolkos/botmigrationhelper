package nl.kolkos.botmigrationhelper.services;


import nl.kolkos.botmigrationhelper.configuration.RestTemplateResponseErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private RestTemplate restTemplate;

    private final static Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    @Autowired
    public RestClient(RestTemplateBuilder restTemplateBuilder, RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(restTemplateResponseErrorHandler)
                .build();
    }

    public String doRestRequest(HttpHeaders httpHeaders, HttpMethod httpMethod, String url) {
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
        try {
            return restTemplate.exchange(url, httpMethod, entity, String.class).getBody();
        } catch (ResourceAccessException e) {
            LOGGER.error("Error calling REST Service: {}", e.getMessage());
            return null;
        }

    }


}
