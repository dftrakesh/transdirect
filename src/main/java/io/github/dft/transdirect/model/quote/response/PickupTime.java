package io.github.dft.transdirect.model.quote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupTime {
    public String from;
    public String to;
}
