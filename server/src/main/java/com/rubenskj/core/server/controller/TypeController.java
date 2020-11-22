package com.rubenskj.core.server.controller;

import com.rubenskj.core.server.constants.Type;
import com.rubenskj.core.server.dto.TypeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @GetMapping
    public List<TypeDTO> getAllTypes() {
        return TypeDTO.ofAll(Type.values());
    }
}
