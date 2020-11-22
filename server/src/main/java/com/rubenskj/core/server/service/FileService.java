package com.rubenskj.core.server.service;

import com.rubenskj.core.server.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    public String generateFileName(String fileName) {
        LOGGER.info("Validating filename..");

        if (fileName.equalsIgnoreCase(FileUtil.DOCKERFILE)) {
            return fileName;
        }

        if (fileName.endsWith(FileUtil.DOCKERFILE_EXTENSION)) {
            return fileName;
        }

        return fileName.concat(FileUtil.DOCKERFILE_EXTENSION);
    }
}
