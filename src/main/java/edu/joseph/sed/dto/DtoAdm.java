package edu.joseph.sed.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class DtoAdm {

    private String name;
    private String rg;
    private String cpf;
    private String birthDate;
    private String nationality;
    private String email;
}

