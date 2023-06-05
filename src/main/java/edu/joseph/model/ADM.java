package edu.joseph.model;

import edu.joseph.model.Enums.Roles;
import edu.joseph.model.Enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
public class ADM extends Person{

    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String userName;

    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String password;

    private Status status;

    private Roles role;

}
