package com.hello.neighbors.entity;

import com.hello.neighbors.entity.enums.WithdrawalReason;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Subscriber extends User {

    private String city;
    private String postalCode;
    private String street;
    private LocalDate birthdate;
    private String introduction;
    private String phone;
    private int notificationPreferences;
    private List<Long> contacts;
    private LocalDate registrationDate;
    private LocalDate withdrawalDate;
    @Enumerated(EnumType.STRING)
    private WithdrawalReason withdrawalReason;
    private LocalDate lastActivityDate;

    ///////////// Constructors ////////////////////

    public Subscriber() { }

    public Subscriber(
            String lastname, String firstname, String pseudonym, String password,
            String email, String picture, List<Role> roles, String city,
            String postalCode, String street, LocalDate birthdate, String introduction,
            String phone, int notificationPreferences, List<Long> contacts,
            LocalDate registrationDate, LocalDate withdrawalDate, WithdrawalReason withdrawalReason,
            LocalDate lastActivityDate)
    {
        super(null, lastname, firstname, pseudonym, password, email, picture, roles);
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.birthdate = birthdate;
        this.introduction = introduction;
        this.phone = phone;
        this.notificationPreferences = notificationPreferences;
        this.contacts = contacts;
        this.registrationDate = registrationDate;
        this.withdrawalDate = withdrawalDate;
        this.withdrawalReason = withdrawalReason;
        this.lastActivityDate = null;
    }

    ///////////// Getters ////////////////////

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPhone() {
        return phone;
    }

    public int getNotificationPreferences() {
        return notificationPreferences;
    }

    public List<Long> getContacts() {
        return contacts;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public WithdrawalReason getWithdrawalReason() {
        return withdrawalReason;
    }

    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }
}
