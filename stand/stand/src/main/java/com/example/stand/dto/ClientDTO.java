package com.example.stand.dto;

import com.example.stand.models.Stand;
import org.springframework.hateoas.RepresentationModel;

public class ClientDTO extends RepresentationModel<ClientDTO> {

    long clientIDDTO;
    String clientNameDTO;
    String clientAddressDTO;
    String clientPhoneNumberDTO;
    Integer clientNifDTO;
    String clientEmailAddressDTO;
    Stand standDTO;

    public ClientDTO(long clientIDDTO, String clientNameDTO, String clientAddressDTO, String clientPhoneNumberDTO, Integer clientNifDTO, String clientEmailAddressDTO, Stand standDTO) {
        this.clientIDDTO = clientIDDTO;
        this.clientNameDTO = clientNameDTO;
        this.clientAddressDTO = clientAddressDTO;
        this.clientPhoneNumberDTO = clientPhoneNumberDTO;
        this.clientNifDTO = clientNifDTO;
        this.clientEmailAddressDTO = clientEmailAddressDTO;
        this.standDTO = standDTO;
    }

    public long getClientIDDTO() {
        return clientIDDTO;
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

    public Stand getStandDTO() {
        return standDTO;
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

    public void setStandDTO(Stand standDTO) {
        this.standDTO = standDTO;
    }
}
