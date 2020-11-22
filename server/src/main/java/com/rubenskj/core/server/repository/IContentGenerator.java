package com.rubenskj.core.server.repository;

import com.rubenskj.core.server.model.Image;
import org.springframework.stereotype.Component;

@Component
public interface IContentGenerator {

    void generate(Image image) throws Exception;
}
