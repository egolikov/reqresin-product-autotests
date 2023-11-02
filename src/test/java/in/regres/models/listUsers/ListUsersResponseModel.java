package in.regres.models.listUsers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListUsersResponseModel {
    Integer page;
    @JsonProperty("per_page")
    Integer perPage;
    Integer total;
    @JsonProperty("total_pages")
    Integer totalPages;
    List<ListUsersDataResponseModel> data;
    ListUsersSupportResponseModel support;
}
