package in.regres.models.listResorces;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListResourcesDataResponseModel {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
