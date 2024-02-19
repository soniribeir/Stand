package com.example.stand.dto;

import org.springframework.hateoas.RepresentationModel;

public class StandDTO extends RepresentationModel<StandDTO> {
    long standIdDTO;
    String standNameDTO;
    String standAddressDTO;
    String standPhoneNumberDTO;
    Integer standNifDTO;
    String standEmailAddressDTO;

    public StandDTO(long standIdDTO, String standNameDTO, String standAddressDTO, String standPhoneNumberDTO, Integer standNifDTO, String standEmailAddressDTO) {
        this.standIdDTO = standIdDTO;
        this.standNameDTO = standNameDTO;
        this.standAddressDTO = standAddressDTO;
        this.standPhoneNumberDTO = standPhoneNumberDTO;
        this.standNifDTO = standNifDTO;
        this.standEmailAddressDTO = standEmailAddressDTO;
    }

    public long getStandIdDTO() {
        return standIdDTO;
    }

    public String getStandNameDTO() {
        return standNameDTO;
    }

    public String getStandAddressDTO() {
        return standAddressDTO;
    }

    public String getStandPhoneNumberDTO() {
        return standPhoneNumberDTO;
    }

    public Integer getStandNifDTO() {
        return standNifDTO;
    }

    public String getStandEmailAddressDTO() {
        return standEmailAddressDTO;
    }

    public void setStandNameDTO(String standNameDTO) {
        this.standNameDTO = standNameDTO;
    }

    public void setStandAddressDTO(String standAddressDTO) {
        this.standAddressDTO = standAddressDTO;
    }

    public void setStandPhoneNumberDTO(String standPhoneNumberDTO) {
        this.standPhoneNumberDTO = standPhoneNumberDTO;
    }

    public void setStandNifDTO(Integer standNifDTO) {
        this.standNifDTO = standNifDTO;
    }

    public void setStandEmailAddressDTO(String standEmailAddressDTO) {
        this.standEmailAddressDTO = standEmailAddressDTO;
    }
}
