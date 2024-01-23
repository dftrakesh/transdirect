package io.github.dft.transdirect.model.quote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReceiverResponse {
    public Long id;
    public String address;
    public String companyName;
    public String email;
    public String name;
    public String postcode;
    public String phone;
    public String state;
    public String suburb;
    public String type;
    public String country;
}
