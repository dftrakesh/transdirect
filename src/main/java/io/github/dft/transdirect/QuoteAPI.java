package io.github.dft.transdirect;

import io.github.dft.transdirect.model.TransdirectCredentials;
import io.github.dft.transdirect.model.quote.response.QuoteResponse;
import io.github.dft.transdirect.model.quote.request.QuoteRequest;

import java.net.URI;
import java.net.http.HttpRequest;

import static io.github.dft.transdirect.constantcode.ConstantCodes.API_URL;
import static io.github.dft.transdirect.constantcode.ConstantCodes.BOOKING_API;

public class QuoteAPI extends TransdirectSDK {

    public QuoteAPI(TransdirectCredentials sendleCredentials) {
        super(sendleCredentials);
    }

    public QuoteResponse getQuote(QuoteRequest quoteRequest) {
        URI uri = URI.create(API_URL + BOOKING_API);
        HttpRequest post = post(uri, convertToJSON(quoteRequest));
        return getRequestWrapped(post, QuoteResponse.class);
    }
}