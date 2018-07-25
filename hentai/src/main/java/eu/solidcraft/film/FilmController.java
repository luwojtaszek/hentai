package eu.solidcraft.film;

import eu.solidcraft.film.domain.FilmFacade;
import eu.solidcraft.film.dto.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static eu.solidcraft.film.dto.FilmExceptionTypes.FILM_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
class FilmController {
    private final FilmFacade filmFacade;

    @GetMapping("films")
    Page<FilmDto> getFilms(Pageable pageable) {
        return filmFacade.findAll(pageable);
    }

    @GetMapping("film/{title}")
    ResponseEntity<?> getFilm(@PathVariable String title) {
        return filmFacade.show(title)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(NOT_FOUND).body(FILM_NOT_FOUND.errorMessage(title)));
    }

}

