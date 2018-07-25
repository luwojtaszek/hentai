package eu.solidcraft.film.domain;

import eu.solidcraft.film.dto.FilmDto;
import lombok.NonNull;

class FilmCreator {
    Film from(@NonNull FilmDto filmDto) {
        return Film.builder()
                .title(filmDto.getTitle())
                .type(FilmType.valueOf(filmDto.getType().name()))
                .build();
    }
}
