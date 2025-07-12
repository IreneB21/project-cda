package com.hello.neighbors.entity.dto;

import java.time.LocalDate;

public class UserGetForVisitorDto {

    private Long id;
    private String lastname;
    private String firstname;
    private String pseudonym;
    private String introduction;
    private String picture;
    private LocalDate registrationDate;

    ///////////// Constructors /////////////////

    public UserGetForVisitorDto() {}

    public UserGetForVisitorDto(Long id, String lastname, String firstname, String pseudonym,
                                String introduction, String picture, LocalDate registrationDate) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.pseudonym = pseudonym;
        this.introduction = introduction;
        this.picture = picture;
        this.registrationDate = registrationDate;
    }

    ///////////// Getters /////////////////

    public Long getId() { return id; }
    public String getLastname() { return lastname; }
    public String getFirstname() { return firstname; }
    public String getPseudonym() { return pseudonym; }
    public String getIntroduction() { return introduction; }
    public String getPicture() { return picture; }
    public LocalDate getRegistrationDate() { return registrationDate; }
}

