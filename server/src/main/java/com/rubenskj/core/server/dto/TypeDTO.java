package com.rubenskj.core.server.dto;

import com.rubenskj.core.server.constants.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeDTO {

    private String label;
    private String value;

    public TypeDTO() {
    }

    public TypeDTO(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static List<TypeDTO> ofAll(Type[] values) {
        List<TypeDTO> typeDTOs = new ArrayList<>();

        for (Type type : values) {
            typeDTOs.add(new TypeDTO(type.getLabel(), type.name()));
        }

        return typeDTOs;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}
