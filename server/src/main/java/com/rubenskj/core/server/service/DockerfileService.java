package com.rubenskj.core.server.service;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DockerfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerfileService.class);

    public List<String> createDockerFile(Image image, Type type, List<String> defaultLinesDocker) {
        List<String> dockerFileLines = new ArrayList<>();

        defaultLinesDocker.forEach(line -> {
            line = line.replace("AUTHOR_NAME", image.getName());
            line = line.replace("IMAGE_NAME", image.getName());
            line = line.replace("APPLICATION_FILE", "application");
            line = line.replace("JAR_NAME", "application");

            dockerFileLines.add(line);
        });

        return dockerFileLines;
    }

    public List<String> createDockerComposeFromImage(Image image, Type type, List<String> defaultComposeLines) {
        List<String> dockerFileLines = new ArrayList<>();

        defaultComposeLines.forEach(line -> {
            line = line.replace("SERVICE_NAME", image.getFileName().replace(FileUtil.DOCKERFILE_EXTENSION, ""));
            line = line.replace("FILE_NAME", image.getFileName());
            line = line.replace("IMAGE_NAME", image.getName());

            dockerFileLines.add(line);
        });

        return dockerFileLines;
    }
}
