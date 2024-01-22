package io.github.dft.transdirect.model.quote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {
    public Integer id;
    public String description;
    public Integer weight;
    public Integer length;
    public Integer width;
    public Integer height;
    public Integer quantity;
    public Boolean sku;
}
