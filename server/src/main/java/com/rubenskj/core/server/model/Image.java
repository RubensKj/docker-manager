package com.rubenskj.core.server.model;

import com.rubenskj.core.server.constants.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Image {

    @Id
    private String id;
    private String fileName;
    private String name;
    private String contentDockerFile;
    private String contentDockerCompose;
    private byte[] file;
    private Type type;

    public Image(String fileName, String name, String contentDockerFile, String contentDockerCompose, byte[] file, Type type) {
        this.fileName = fileName;
        this.name = name;
        this.contentDockerFile = contentDockerFile;
        this.contentDockerCompose = contentDockerCompose;
        this.file = file;
        this.type = type;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
