package com.example.stand.dto;

import org.springframework.hateoas.RepresentationModel;

public class BrandDTO extends RepresentationModel<BrandDTO> {

    long brandIDDTO;
    String brandNameDTO;

    public BrandDTO(long brandIDDTO, String brandNameDTO) {
        this.brandIDDTO = brandIDDTO;
        this.brandNameDTO = brandNameDTO;
    }

    public long getBrandIDDTO() {
        return brandIDDTO;
    }

    public String getBrandNameDTO() {
        return brandNameDTO;
    }

    public void setBrandNameDTO(String brandNameDTO) {
        this.brandNameDTO = brandNameDTO;
    }
}
