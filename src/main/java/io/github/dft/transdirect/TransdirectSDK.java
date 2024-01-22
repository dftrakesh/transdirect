package io.github.dft.transdirect;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.transdirect.model.TransdirectCredentials;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.transdirect.constantcode.ConstantCodes.*;

public class TransdirectSDK {

    protected HttpClient client;
    protected final ObjectMapper objectMapper;
    protected TransdirectCredentials transdirectCredentials;

    public TransdirectSDK(TransdirectCredentials transdirectCredentials) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.transdirectCredentials = transdirectCredentials;
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenComposeAsync(CompletableFuture::completedFuture)
            .thenApplyAsync(HttpResponse::body)
            .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
            .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    protected String convertToJSON(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    protected HttpRequest post(URI uri, String payload) {
        return HttpRequest.newBuilder(uri)
            .POST((HttpRequest.BodyPublishers.ofString(payload)))
            .header(APIKEY_HEADER, transdirectCredentials.getAccessToken())
            .header(CONTENT_TYPE, HTTP_REQUEST_CONTENT_TYPE_JSON)
            .header(ACCEPT, HTTP_REQUEST_CONTENT_TYPE_JSON)
            .build();
    }
}