package com.example.stand.dto;

import com.example.stand.models.Stand;
import org.springframework.hateoas.RepresentationModel;

public class ClientDTO extends RepresentationModel<ClientDTO> {

    String clientNameDTO;
    String clientAddressDTO;
    String clientPhoneNumberDTO;
    Integer clientNifDTO;
    String clientEmailAddressDTO;
    Stand stand;

    public ClientDTO(String clientNameDTO, String clientAddressDTO, String clientPhoneNumberDTO, Integer clientNifDTO, String clientEmailAddressDTO, Stand stand) {
        this.clientNameDTO = clientNameDTO;
        this.clientAddressDTO = clientAddressDTO;
        this.clientPhoneNumberDTO = clientPhoneNumberDTO;
        this.clientNifDTO = clientNifDTO;
        this.clientEmailAddressDTO = clientEmailAddressDTO;
        this.stand = stand;
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

    public Stand getStand() {
        return stand;
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

    public void setStand(Stand stand) {
        this.stand = stand;
    }
}
