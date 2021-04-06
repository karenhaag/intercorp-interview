package com.intercorp.interview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.intercorp.interview.model.ClientEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Client {
    @ApiModelProperty(name = "name", dataType = "String", example = "María")
    @NotBlank(message = "Name can't be blank or null")
    private String name;
    @ApiModelProperty(name = "surname", dataType = "String", example = "Perez")
    @NotBlank(message = "Surname can't be blank or null")
    private String surname;
    @ApiModelProperty(name = "age", dataType = "int", example = "25")
    @NotNull
    @Min(value = 16, message = "Age should be greater than 16")
    @Max(value = 100, message = "Age should be less than 16")
    private int age;
    @ApiModelProperty(name = "birthday", dataType = "Date", example = "1991-04-04")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    public Client(){}

    public Client(ClientEntity clientEntity){
        this.name = clientEntity.getName();
        this.surname = clientEntity.getSurname();
        this.age = clientEntity.getAge();
        this.birthday = clientEntity.getBirthdate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
