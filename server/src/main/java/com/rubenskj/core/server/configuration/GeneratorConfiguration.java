package com.rubenskj.core.server.configuration;

import com.rubenskj.core.server.impl.JavaGenerator;
import com.rubenskj.core.server.repository.IContentGenerator;
import com.rubenskj.core.server.service.DockerfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorConfiguration {

    private final DockerfileService dockerfileService;

    public GeneratorConfiguration(DockerfileService dockerfileService) {
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
