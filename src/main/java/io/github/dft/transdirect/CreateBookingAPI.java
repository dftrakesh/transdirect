package io.github.dft.transdirect;

import io.github.dft.transdirect.model.TransdirectCredentials;
import io.github.dft.transdirect.model.quote.response.BookingResponse;
import io.github.dft.transdirect.model.quote.request.BookingRequest;

import java.net.URI;
import java.net.http.HttpRequest;

import static io.github.dft.transdirect.constantcode.ConstantCodes.API_URL;
import static io.github.dft.transdirect.constantcode.ConstantCodes.BOOKING_API;

public class CreateBookingAPI extends TransdirectSDK {

    public CreateBookingAPI(TransdirectCredentials sendleCredentials) {
        super(sendleCredentials);
    }

    public BookingResponse getQuote(BookingRequest bookingRequest) {
        URI uri = URI.create(API_URL + BOOKING_API);
        HttpRequest post = post(uri, convertToJSON(bookingRequest));
        return getRequestWrapped(post, BookingResponse.class);
    }
}