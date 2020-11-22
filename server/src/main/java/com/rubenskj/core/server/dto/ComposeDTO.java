package com.rubenskj.core.server.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ComposeDTO {

    @NotNull(message = "Filename cannot be null")
    @NotEmpty(message = "Filename cannot be empty")
    private String fileName;

    @NotNull(message = "Images cannot be null")
    @NotEmpty(message = "Images cannot be empty")
    private List<String> images;

    public ComposeDTO() {
    }

    public ComposeDTO(String fileName, List<String> images) {
        this.fileName = fileName;
        this.images = images;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ComposeDTO{" +
                "fileName='" + fileName + '\'' +
                ", images=" + images +
                '}';
    }
}
