package io.github.dft.transdirect.model.quote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Allied {
    public Double total;
    public Double fee;
    public Double appliedGst;
    public Double insuredAmount;
    public Double priceInsuranceEx;
    public String service;
    public String transitTime;
    public List<Date> pickupDates;
    public PickupTime pickupTime;
}
