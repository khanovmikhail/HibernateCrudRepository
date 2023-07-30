package com.github.khanovmikhail.service;

import com.github.khanovmikhail.model.dto.PositionDetailDto;
import com.github.khanovmikhail.model.dto.PositionDto;

import java.util.List;

public interface PositionService {
    List<PositionDto> findAll();

    PositionDetailDto findById(long id);

    PositionDetailDto findByName(String name);

    PositionDto addPosition(PositionDto position);

    PositionDetailDto updatePosition(long id, PositionDto position);

    void deletePosition(long id);
}
