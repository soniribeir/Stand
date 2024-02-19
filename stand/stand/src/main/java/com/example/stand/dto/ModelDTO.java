package com.example.stand.dto;

import org.springframework.hateoas.RepresentationModel;

public class ModelDTO extends RepresentationModel<ModelDTO> {

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
