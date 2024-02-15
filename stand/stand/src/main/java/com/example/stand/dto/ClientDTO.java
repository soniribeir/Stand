package com.example.stand.dto;

public class ClientDTO {

    String clientNameDTO;
    String clientAddressDTO;
    String clientPhoneNumberDTO;
    Integer clientNifDTO;
    String clientEmailAddressDTO;

    public ClientDTO(String clientNameDTO, String clientAddressDTO, String clientPhoneNumberDTO, Integer clientNifDTO, String clientEmailAddressDTO) {
        this.clientNameDTO = clientNameDTO;
        this.clientAddressDTO = clientAddressDTO;
        this.clientPhoneNumberDTO = clientPhoneNumberDTO;
        this.clientNifDTO = clientNifDTO;
        this.clientEmailAddressDTO = clientEmailAddressDTO;
    }

    public String getClientNameDTO() {
        return clientNameDTO;
    }

    public String getClientAddressDTO() {
        return clientAddressDTO;
    }

    public String getClientPhoneNumberDTO() {
        return clientPhoneNumberDTO;
    }

    public Integer getClientNifDTO() {
        return clientNifDTO;
    }

    public String getClientEmailAddressDTO() {
        return clientEmailAddressDTO;
    }

    public void setClientNameDTO(String clientNameDTO) {
        this.clientNameDTO = clientNameDTO;
    }

    public void setClientAddressDTO(String clientAddressDTO) {
        this.clientAddressDTO = clientAddressDTO;
    }

    public void setClientPhoneNumberDTO(String clientPhoneNumberDTO) {
        this.clientPhoneNumberDTO = clientPhoneNumberDTO;
    }

    public void setClientNifDTO(Integer clientNifDTO) {
        this.clientNifDTO = clientNifDTO;
    }

    public void setClientEmailAddressDTO(String clientEmailAddressDTO) {
        this.clientEmailAddressDTO = clientEmailAddressDTO;
    }
}
