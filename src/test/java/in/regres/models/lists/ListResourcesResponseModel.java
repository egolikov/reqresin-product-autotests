package in.regres.models.lists;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListResourcesResponseModel {
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<ListResourcesDataResponseModel> data;
    private ListResourcesSupportResponseModel support;
}
