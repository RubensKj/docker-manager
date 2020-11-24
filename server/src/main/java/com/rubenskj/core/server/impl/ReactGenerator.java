package com.rubenskj.core.server.impl;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.service.DockerFileService;
import com.rubenskj.core.server.util.FileUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReactGenerator extends TemplateContentGenerator {

    private final DockerFileService dockerFileService;

    public ReactGenerator(@Qualifier("mongoGenerator") TemplateContentGenerator iContentGenerator, DockerFileService dockerFileService) {
        super(iContentGenerator, Type.REACT);
        this.dockerFileService = dockerFileService;
    }

    @Override
    void execute(Image image) throws Exception {
        List<String> defaultLinesDocker = getDockerFileLines();
        List<String> defaultComposeLines = getDockerComposeLines();

        List<String> dockerFileLines = this.dockerFileService.createDockerFile(image, image.getType(), defaultLinesDocker);
        List<String> dockerComposeLines = this.dockerFileService.createDockerComposeFromImage(image, image.getType(), defaultComposeLines);

        image.setContentDockerFile(String.join("\n", dockerFileLines));
        image.setContentDockerCompose(String.join("\n", dockerComposeLines));
    }

    @Override
    public List<String> getDockerFileLines() throws Exception {
        return new ArrayList<>(
                Arrays.asList(
                        "FROM nginx:latest",
                        "MAINTAINER AUTHOR_NAME",
                        "COPY ./build /var/www/public",
                        "COPY ./nginx.conf /etc/nginx/nginx.conf",
                        "RUN chmod 755 -R /var/www/public",
                        "EXPOSE 80 443",
                        "ENTRYPOINT nginx",
                        "CMD [\"-g\", \"daemon off;\"]"
                )
        );
    }

    @Override
    public List<String> getDockerComposeLines() throws Exception {
        return new ArrayList<>(
                Arrays.asList(
                        FileUtil.TABULATION + "SERVICE_NAME:",
                        FileUtil.DOUBLE_TABULATION + "build:",
                        FileUtil.TRI_TABULATION + "dockerfile: ./FILE_NAME",
                        FileUtil.TRI_TABULATION + "context: .",
                        FileUtil.DOUBLE_TABULATION + "image: IMAGE_NAME",
                        FileUtil.DOUBLE_TABULATION + "container_name: SERVICE_NAME-1",
                        FileUtil.DOUBLE_TABULATION + "ports:",
                        FileUtil.TRI_TABULATION + "- \"80:80\""
                )
        );
    }
}
