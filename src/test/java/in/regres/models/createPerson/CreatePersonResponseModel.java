package in.regres.models.createPerson;

import lombok.Data;

@Data
public class CreatePersonResponseModel {
    String name;
    String job;
    String id;
    String createdAt;
}
