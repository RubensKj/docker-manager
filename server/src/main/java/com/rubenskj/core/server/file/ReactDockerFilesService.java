package com.rubenskj.core.server.file;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.repository.IDockerFileRepository;
import com.rubenskj.core.server.util.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReactDockerFilesService implements IDockerFileRepository {
    @Override
    public List<String> createDockerFileByType(Image image, Type type, List<String> defaultLinesDocker) throws Exception {
        List<String> dockerFileLines = new ArrayList<>();

        defaultLinesDocker.forEach(line -> {
            line = line.replace("AUTHOR_NAME", image.getName());

            dockerFileLines.add(line);
        });

        return dockerFileLines;
    }

    @Override
    public List<String> createDockerComposeServiceByType(Image image, Type type, List<String> defaultComposeLines) throws Exception {
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
