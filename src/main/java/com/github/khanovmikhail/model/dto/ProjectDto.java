package com.github.khanovmikhail.model.dto;

import com.github.khanovmikhail.model.validation.group.ForCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProjectDto (
        Long id,

        @NotBlank(groups = ForCreate.class)
        @Pattern(regexp = NAME_PATTERN)
        String name
) {
    public static final String NAME_PATTERN = "[\\p{Alpha}А-Яа-яЁё][\\p{Alpha}\\d\\sА-Яа-яЁё]{1,49}";
}