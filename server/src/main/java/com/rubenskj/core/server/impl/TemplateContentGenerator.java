package com.rubenskj.core.server.impl;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.model.Image;
import com.rubenskj.core.server.repository.IContentGenerator;

import java.util.List;

public abstract class TemplateContentGenerator implements IContentGenerator {

    private TemplateContentGenerator iContentGenerator;
    private Type type;

    public TemplateContentGenerator(Type type) {
        this.type = type;
    }

    public TemplateContentGenerator(TemplateContentGenerator iContentGenerator, Type type) {
        this.iContentGenerator = iContentGenerator;
        this.type = type;
    }

    @Override
    public final void generate(Image image) throws Exception {
        if (this.type.equals(image.getType())) {
            execute(image);
        }

        if (this.iContentGenerator != null) {
            this.iContentGenerator.generate(image);
        }
    }

    abstract void execute(Image image) throws Exception;

    public abstract List<String> getDockerFileLines() throws Exception;

    public abstract List<String> getDockerComposeLines() throws Exception;

    public Type getType() {
        return type;
    }
}
