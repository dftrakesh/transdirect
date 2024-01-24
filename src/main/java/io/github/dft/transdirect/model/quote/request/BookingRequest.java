package io.github.dft.transdirect.model.quote.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingRequest {
    public String declaredValue;
    public Sender sender;
    public Receiver receiver;
    public List<Item> items;
    public Boolean tailgatePickup;
    public Boolean tailgateDelivery;
}
