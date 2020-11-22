package com.rubenskj.core.server.controller;

import com.rubenskj.core.server.dto.ComposeDTO;
import com.rubenskj.core.server.service.DockerComposeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/compose")
public class ComposeController {

    private final DockerComposeService dockerComposeService;

    public ComposeController(DockerComposeService dockerComposeService) {
        this.dockerComposeService = dockerComposeService;
    }

    @PostMapping
    public String createDockerCompose(@Valid @RequestBody ComposeDTO composeDTO) {
        return this.dockerComposeService.createDockerFile(composeDTO);
    }
}
