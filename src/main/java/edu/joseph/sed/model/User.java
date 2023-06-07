package edu.joseph.sed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import edu.joseph.sed.model.Enums.Roles;
import edu.joseph.sed.model.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class User {


    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String userName;

    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public void permissionsUser(){
        setStatus(Status.ACTIVE);
        setRole(Roles.ADM);
    }

    public void removepermissions(){
        setRole(null);
        setStatus(Status.INACTIVE);
    }


}