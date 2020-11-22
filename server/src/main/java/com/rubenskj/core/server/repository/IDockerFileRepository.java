package com.rubenskj.core.server.repository;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;

import java.util.List;

public interface IDockerFileRepository {

    List<String> createDockerFileByType(Image image, Type type, List<String> defaultLinesDocker) throws Exception;

    List<String> createDockerComposeServiceByType(Image image, Type type, List<String> defaultComposeLines) throws Exception;
}
