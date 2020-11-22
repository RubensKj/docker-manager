package com.rubenskj.core.server.service;

import com.rubenskj.core.server.dto.ImageDTO;
import com.rubenskj.core.server.exception.NotFoundException;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.repository.IContentGenerator;
import com.rubenskj.core.server.repository.IImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class.getName());

    private final IImageRepository iImageRepository;
    private final FileService fileService;
    private final IContentGenerator iContentGenerator;

    public ImageService(IImageRepository iImageRepository, FileService fileService, IContentGenerator iContentGenerator) {
        this.iImageRepository = iImageRepository;
        this.fileService = fileService;
        this.iContentGenerator = iContentGenerator;
    }

    public Image create(ImageDTO imageDTO) {
        Image image = this.createImageByDTO(imageDTO);

        iContentGenerator.generate(image);

        return this.iImageRepository.save(image);
    }

    private Image createImageByDTO(ImageDTO imageDTO) {
        return new Image(
                this.fileService.generateFileName(imageDTO.getFileName()),
                imageDTO.getName(),
                null,
                null,
                null,
                imageDTO.getType()
        );
    }

    public List<Image> findAll() {
        return this.iImageRepository.findAll();
    }

    public Image findById(String id) throws NotFoundException {
        return this.iImageRepository.findById(id).orElseThrow(() -> new NotFoundException("Cannot find any Image with this id. Id: " + id));
    }

    public List<Image> findAllById(List<String> images) {
        return StreamSupport.stream(this.iImageRepository.findAllById(images).spliterator(), false)
                .collect(Collectors.toList());
    }
}
