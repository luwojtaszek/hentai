package eu.solidcraft.film.dto;

import eu.solidcraft.infrastructure.mvc.ErrorMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FilmExceptionTypes {
    FILM_NOT_FOUND("No film of title %s found");

    private final String msgTemplate;

    public String message(String... args) {
        return String.format(msgTemplate, (Object[]) args);
    }

    public ErrorMessage errorMessage(String args) {
        return new ErrorMessage(message(args));
    }
}
