package com.rubenskj.core.server.controller;

import com.rubenskj.core.server.dto.ImageDTO;
import com.rubenskj.core.server.exception.NotFoundException;
import com.rubenskj.core.server.service.ImageService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ImageDTO create(@Valid @RequestBody ImageDTO imageDTO) {
        return ImageDTO.of(this.imageService.create(imageDTO));
    }

    @GetMapping
    public List<ImageDTO> getAllImages() {
        return ImageDTO.ofAll(this.imageService.findAll());
    }

    @GetMapping("/{id}")
    public ImageDTO findById(@PathVariable("id") String id) throws NotFoundException {
        return ImageDTO.of(this.imageService.findById(id));
    }
}
