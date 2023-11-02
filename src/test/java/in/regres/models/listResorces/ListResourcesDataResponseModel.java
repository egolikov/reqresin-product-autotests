package in.regres.models.listResorces;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListResourcesDataResponseModel {
    Integer id;
    String name;
    Integer year;
    String color;
    @JsonProperty("pantone_value")
    String pantoneValue;
}
