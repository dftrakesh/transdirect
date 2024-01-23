package io.github.dft.transdirect.model.quote.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receiver {
    public String type;
    public String suburb;
    public String country;
    public String postcode;
}
