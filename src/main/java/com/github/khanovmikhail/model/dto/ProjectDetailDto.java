package com.github.khanovmikhail.model.dto;

import java.util.List;

public record ProjectDetailDto(
        Long id,
        String name,
        List<EmployeeDto> employees
) {
}