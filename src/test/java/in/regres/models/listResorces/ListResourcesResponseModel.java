package in.regres.models.listResorces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListResourcesResponseModel {
    Integer page;
    @JsonProperty("per_page")
    Integer perPage;
    Integer total;
    @JsonProperty("total_pages")
    Integer totalPages;
    List<ListResourcesDataResponseModel> data;
    ListResourcesSupportResponseModel support;
}
