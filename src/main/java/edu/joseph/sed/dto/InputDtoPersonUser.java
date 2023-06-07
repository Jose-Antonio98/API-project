package edu.joseph.sed.dto;

import edu.joseph.sed.model.Adm;
import edu.joseph.sed.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class InputDtoPersonUser {

    private Adm person;
    private User user;

}
