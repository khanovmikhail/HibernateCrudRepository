package com.github.khanovmikhail.model.dto;

public record ErrorInfoDto(
        String errorClass,
        String errorMessage
) {
}