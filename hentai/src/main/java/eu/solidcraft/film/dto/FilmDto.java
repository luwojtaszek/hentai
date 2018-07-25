package eu.solidcraft.film.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FilmDto {
    private String title;
    private FilmTypeDto type;

}
