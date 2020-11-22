package com.rubenskj.core.server.file;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.repository.IDockerFileRepository;
import com.rubenskj.core.server.util.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDockerFilesGenerator implements IDockerFileRepository {

    @Override
    public List<String> createDockerFileByType(Image image, Type type, List<String> defaultLinesDocker) throws Exception {
        throw new IllegalAccessException("Mongo does not have DockerFile to be generated.");
    }

    @Override
    public List<String> createDockerComposeServiceByType(Image image, Type type, List<String> defaultComposeLines) {
        List<String> dockerFileLines = new ArrayList<>();

        defaultComposeLines.forEach(line -> {
            line = line.replace("SERVICE_NAME", image.getFileName().replace(FileUtil.DOCKERFILE_EXTENSION, ""));
            line = line.replace("IMAGE_NAME", image.getName());

            dockerFileLines.add(line);
        });

        return dockerFileLines;
    }
}
