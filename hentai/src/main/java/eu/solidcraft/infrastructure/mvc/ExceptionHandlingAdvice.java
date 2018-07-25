package eu.solidcraft.infrastructure.mvc;

import eu.solidcraft.film.dto.FilmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ExceptionHandlingAdvice {

    @ExceptionHandler(FilmNotFoundException.class)
    ResponseEntity<ErrorMessage> handleNotFoundFilms(FilmNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
