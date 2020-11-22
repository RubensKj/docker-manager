package com.rubenskj.core.server.configuration;

import com.rubenskj.core.server.impl.JavaGenerator;
import com.rubenskj.core.server.repository.IContentGenerator;
import com.rubenskj.core.server.service.DockerFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfiguration {

    private final DockerFileService dockerfileService;

    public GeneratorConfiguration(DockerFileService dockerfileService) {
        this.dockerfileService = dockerfileService;
    }

    @Bean
    public IContentGenerator getGenerator() {
        return new JavaGenerator(
                null,
                dockerfileService
        );
    }
}
