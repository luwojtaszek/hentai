package eu.solidcraft.film.domain;

import eu.solidcraft.film.dto.FilmDto;
import eu.solidcraft.infrastructure.metrics.logging.Log;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Transactional
@Log
@RequiredArgsConstructor
public class FilmFacade {
    private final FilmRepository filmRepository;
    private final FilmCreator filmCreator;

    public FilmDto add(@NonNull FilmDto filmDto) {
        Film film = filmCreator.from(filmDto);
        film = filmRepository.save(film);
        return film.dto();
    }

    public Optional<FilmDto> show(@NonNull String filmDto) {
        return filmRepository.findOne(filmDto)
                .map(Film::dto);
    }

    public void delete(@NonNull String... titles) {
        Arrays.stream(titles).forEach(filmRepository::delete);
    }

    public Page<FilmDto> findAll(@NonNull Pageable pageable) {
        return filmRepository
                .findAll(pageable)
                .map(Film::dto);
    }
}
