package com.github.khanovmikhail.service.converter;

import com.github.khanovmikhail.model.dto.PositionDetailDto;
import com.github.khanovmikhail.model.dto.PositionDto;
import com.github.khanovmikhail.model.entity.Position;

public interface PositionConverter {
    PositionDto convertPositionToPositionDto(Position position);

    PositionDetailDto convertPositionToPositionDetailDto(Position position);
}
