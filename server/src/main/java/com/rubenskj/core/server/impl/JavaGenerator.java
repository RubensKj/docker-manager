package com.rubenskj.core.server.impl;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.service.DockerFileService;
import com.rubenskj.core.server.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaGenerator extends TemplateContentGenerator {

    private final DockerFileService dockerfileService;

    public JavaGenerator(TemplateContentGenerator iContentGenerator, DockerFileService dockerfileService) {
        super(iContentGenerator, Type.JAVA);
        this.dockerfileService = dockerfileService;
    }

    @Override
    void execute(Image image) {
        List<String> defaultLinesDocker = getDockerFileLines();
        List<String> defaultComposeLines = getDockerComposeLines();

        List<String> dockerFileLines = this.dockerfileService.createDockerFile(image, image.getType(), defaultLinesDocker);
        List<String> dockerComposeLines = this.dockerfileService.createDockerComposeFromImage(image, image.getType(), defaultComposeLines);

        image.setContentDockerFile(String.join("\n", dockerFileLines));
        image.setContentDockerCompose(String.join("\n", dockerComposeLines));
    }

    @Override
    public List<String> getDockerFileLines() {
        return new ArrayList<>(
                Arrays.asList(
                        "FROM openjdk:latest",
                        "MAINTAINER AUTHOR_NAME",
                        "COPY . /var/www/APPLICATION_FILE.yml",
                        "COPY ./target/*.jar /var/www/JAR_NAME.jar",
                        "WORKDIR /var/www/",
                        "EXPOSE 8080",
                        "ENTRYPOINT java -jar JAR_NAME.jar"
                )
        );
    }

    @Override
    public List<String> getDockerComposeLines() {
        return new ArrayList<>(
                Arrays.asList(
                        FileUtil.TABULATION + "SERVICE_NAME:",
                        FileUtil.DOUBLE_TABULATION + "build:",
                        FileUtil.TRI_TABULATION  + "dockerfile: ./FILE_NAME",
                        FileUtil.TRI_TABULATION  + "context: .",
                        FileUtil.DOUBLE_TABULATION  + "image: IMAGE_NAME",
                        FileUtil.DOUBLE_TABULATION  + "container_name: SERVICE_NAME-1",
                        FileUtil.DOUBLE_TABULATION  + "ports:",
                        FileUtil.TRI_TABULATION + "- \"8080:8080\""
                )
        );
    }
}
