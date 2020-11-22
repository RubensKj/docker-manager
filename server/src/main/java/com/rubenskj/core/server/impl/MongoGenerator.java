package com.rubenskj.core.server.impl;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.service.DockerFileService;
import com.rubenskj.core.server.util.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MongoGenerator extends TemplateContentGenerator {

    private final DockerFileService dockerfileService;

    public MongoGenerator(DockerFileService dockerfileService) {
        super(Type.MONGO);
        this.dockerfileService = dockerfileService;
    }

    @Override
    void execute(Image image) throws Exception {
        List<String> defaultComposeLines = getDockerComposeLines();

        List<String> dockerComposeLines = this.dockerfileService.createDockerComposeFromImage(image, image.getType(), defaultComposeLines);

        image.setContentDockerCompose(String.join("\n", dockerComposeLines));
    }

    @Override
    public List<String> getDockerFileLines() throws Exception {
        throw new IllegalAccessException("Mongo does not have DockerFileLines");
    }

    @Override
    public List<String> getDockerComposeLines() {
        return new ArrayList<>(
                Arrays.asList(
                        FileUtil.TABULATION + "SERVICE_NAME:",
                        FileUtil.DOUBLE_TABULATION + "image: IMAGE_NAME",
                        FileUtil.DOUBLE_TABULATION + "container_name: SERVICE_NAME-1",
                        FileUtil.DOUBLE_TABULATION + "ports:",
                        FileUtil.TRI_TABULATION + "- \"27017:27017\""
                )
        );
    }
}
