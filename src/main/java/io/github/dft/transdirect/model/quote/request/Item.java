package io.github.dft.transdirect.model.quote.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    public String weight;
    public String height;
    public String width;
    public String length;
    public Integer quantity;
    public String description;
}
