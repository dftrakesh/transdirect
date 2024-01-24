package io.github.dft.transdirect.model.quote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.transdirect.model.quote.request.Item;
import io.github.dft.transdirect.model.quote.request.Receiver;
import io.github.dft.transdirect.model.quote.request.Sender;
import io.github.dft.transdirect.model.quote.util.LocalDateTimeDeserializer;
import io.github.dft.transdirect.model.quote.util.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingResponse {
    public Long id;
    public String bookedBy;
    public Double declaredValue;
    public Double insuredValue;
    public String description;
    public String label;
    public Sender sender;
    public String connote;
    public Integer chargedWeight;
    public Integer scannedWeight;
    public String specialInstructions;
    public String status;
    public String pickupInstructions;
    public Boolean tailgatePickup;
    public Boolean tailgateDelivery;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime createdAt;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime bookedAt;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime updatedAt;

    public List<Item> items;
    public Receiver receiver;
    public Notifications notifications;
    private HashMap<String, Allied> quotes;
}