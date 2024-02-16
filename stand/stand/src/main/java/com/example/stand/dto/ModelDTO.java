package com.example.stand.dto;

public class ModelDTO {

    long modelIDDTO;
    String modelNameDTO;

    public ModelDTO(long modelIDDTO, String modelNameDTO) {
        this.modelIDDTO = modelIDDTO;
        this.modelNameDTO = modelNameDTO;
    }

    public long getModelIDDTO() {
        return modelIDDTO;
    }

    public String getModelNameDTO() {
        return modelNameDTO;
    }

    public void setModelNameDTO(String modelNameDTO) {
        this.modelNameDTO = modelNameDTO;
    }
}
