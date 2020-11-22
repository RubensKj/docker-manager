package com.rubenskj.core.server.impl;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.service.DockerfileService;
import com.rubenskj.core.server.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaGenerator extends TemplateContentGenerator {

    private final DockerfileService dockerfileService;

    public JavaGenerator(TemplateContentGenerator iContentGenerator, DockerfileService dockerfileService) {
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
                        "COPY . /var/www/JAR_NAME.jar",
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
                        "SERVICE_NAME:",
                        FileUtil.TABULATION + "build:",
                        FileUtil.TABULATION  + FileUtil.TABULATION  + "dockerfile: ./FILE_NAME",
                        FileUtil.TABULATION  + FileUtil.TABULATION  + "context: .",
                        FileUtil.TABULATION  + "image: IMAGE_NAME",
                        FileUtil.TABULATION  + "container_name: IMAGE_NAME_container",
                        FileUtil.TABULATION  + "ports:",
                        FileUtil.TABULATION + FileUtil.TABULATION  + "- \"8080:8080\""
                )
        );
    }
}
