package com.rubenskj.core.server.service;

import com.rubenskj.core.server.dto.ComposeDTO;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DockerComposeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerComposeService.class);

    private final ImageService imageService;

    public DockerComposeService(ImageService imageService) {
        this.imageService = imageService;
    }

    public String createDockerFile(ComposeDTO composeDTO) {
        List<Image> images = this.imageService.findAllById(composeDTO.getImages());

        List<String> initialLines = getInitialLines();

        images.forEach(image -> initialLines.add(image.getContentDockerCompose()));

        initialLines.addAll(getEndLines());

        return String.join("\n", initialLines);
    }

    public List<String> getInitialLines() {
        return new ArrayList<>(
                Arrays.asList(
                        "version: '3.8'",
                        "services:"
                )
        );
    }

    private List<String> getEndLines() {
        return new ArrayList<>(
                Arrays.asList(
                        "networks:",
                        FileUtil.TABULATION + "production-network:",
                        FileUtil.TABULATION + FileUtil.TABULATION + "driver: bridge"
                )
        );
    }
}
