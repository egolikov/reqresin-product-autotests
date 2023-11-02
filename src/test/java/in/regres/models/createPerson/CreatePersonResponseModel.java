package in.regres.models.createPerson;

import lombok.Data;

@Data
public class CreatePersonResponseModel {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
