package com.rubenskj.core.server.service;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.repository.IDockerFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerFileService.class);

    private final IDockerFileRepository iDockerFileRepository;

    public DockerFileService(@Qualifier("javaDockerFilesService") IDockerFileRepository iDockerFileRepository) {
        this.iDockerFileRepository = iDockerFileRepository;
    }

    public List<String> createDockerFile(Image image, Type type, List<String> defaultLinesDocker) throws Exception {
        LOGGER.info("Creating Docker File for Type: {}", type);

        return this.iDockerFileRepository.createDockerFileByType(image, type, defaultLinesDocker);
    }

    public List<String> createDockerComposeFromImage(Image image, Type type, List<String> defaultComposeLines) throws Exception {
        LOGGER.info("Creating Docker Compose Service for Type: {}", type);

        return this.iDockerFileRepository.createDockerComposeServiceByType(image, type, defaultComposeLines);
    }
}
