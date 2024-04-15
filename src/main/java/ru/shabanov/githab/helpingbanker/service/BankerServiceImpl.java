package ru.shabanov.githab.helpingbanker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.shabanov.githab.helpingbanker.mapper.ClientMapper;
import ru.shabanov.githab.helpingbanker.model.ExternalClient;
import ru.shabanov.githab.helpingbanker.model.InternalClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Service
public class BankerServiceImpl implements BankerService {

    private final WireMockServer wireMock;
    private final RestTemplate restTemplate;
    private final ClientMapper mapper;

    public BankerServiceImpl(WireMockServer wireMock, RestTemplate restTemplate, ClientMapper mapper, ObjectMapper objectMapper) {
        this.wireMock = wireMock;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        configureWireMock();
    }

    @Override
    public InternalClient getClient(Long id) {
        String url = "http://localhost:8084/clients/id/" + id;
        System.out.println(restTemplate.getForEntity(url, ExternalClient.class));
        return mapper.toInternal(restTemplate.getForObject(url, ExternalClient.class));
    }

    private void configureWireMock() {
        wireMock.stubFor(get(urlPathMatching("/clients/id/1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"id\": 1, \"clientFirstName\": \"Иван\", \"clientLastName\": \"Иванов\"}")));
        wireMock.stubFor(get(urlPathMatching("/clients/id/2"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"id\": 2, \"clientFirstName\": \"Иван2\", \"clientLastName\": \"Иванов2\"}")));
    }
}
