package com.rubenskj.core.server.dto;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class ImageDTO {

    private String id;

    @NotNull(message = "Filename cannot be null")
    @NotEmpty(message = "Filename cannot be empty")
    private String fileName;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String contentDockerFile;
    private String contentDockerCompose;

    @NotNull(message = "Type cannot be null")
    private Type type;

    public ImageDTO() {
    }

    public ImageDTO(String id, String fileName, String name, String content, String contentDockerFile, String contentDockerCompose, Type type) {
        this.id = id;
        this.fileName = fileName;
        this.name = name;
        this.contentDockerFile = contentDockerFile;
        this.contentDockerCompose = contentDockerCompose;
        this.type = type;
    }

    public static ImageDTO of(Image image) {
        return new ImageDTO(
                image.getId(),
                image.getFileName(),
                image.getName(),
                image.getContentDockerFile(),
                image.getContentDockerFile(),
                image.getContentDockerCompose(),
                image.getType()
        );
    }

    public static List<ImageDTO> ofAll(List<Image> images) {
        return images.stream().map(ImageDTO::of).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentDockerFile() {
        return contentDockerFile;
    }

    public void setContentDockerFile(String contentDockerFile) {
        this.contentDockerFile = contentDockerFile;
    }

    public String getContentDockerCompose() {
        return contentDockerCompose;
    }

    public void setContentDockerCompose(String contentDockerCompose) {
        this.contentDockerCompose = contentDockerCompose;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
