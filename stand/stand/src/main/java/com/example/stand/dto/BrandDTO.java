package com.example.stand.dto;

public class BrandDTO {

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
