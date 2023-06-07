package edu.joseph.sed.dto;

import edu.joseph.sed.model.Enums.Roles;
import edu.joseph.sed.model.Enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DtoUser {

    private String userName;
    private Status status;
    private Roles role;

}
