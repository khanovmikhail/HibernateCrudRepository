package com.github.khanovmikhail.service.converter.impl;

import com.github.khanovmikhail.model.dto.PositionDetailDto;
import com.github.khanovmikhail.model.dto.PositionDto;
import com.github.khanovmikhail.model.entity.Position;
import com.github.khanovmikhail.service.converter.EmployeeConverter;
import com.github.khanovmikhail.service.converter.PositionConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PositionConverterImpl implements PositionConverter {
    private final EmployeeConverter employeeConverter;

    @Override
    public PositionDto convertPositionToPositionDto(Position position) {
        return new PositionDto(position.getId(), position.getName());
    }

    @Override
    public PositionDetailDto convertPositionToPositionDetailDto(Position position) {
        return new PositionDetailDto(
                position.getId(),
                position.getName(),
                position.getEmployees()
                        .stream()
                        .map(employeeConverter::convertEmployeeToEmployeeDto)
                        .toList()
        );
    }
}