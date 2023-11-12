package com.fernando.microservice.AccountModuleService.rest.dto;

public class ClientDTO {
    private Long clientId;
    private String password;
    private Boolean status;
    private PersonDTO person;

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PersonDTO getPerson() {
        return this.person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

}
