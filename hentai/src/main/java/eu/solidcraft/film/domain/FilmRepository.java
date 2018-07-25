package eu.solidcraft.film.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface FilmRepository extends Repository<Film, String> {
    Film save(Film film);

    Optional<Film> findOne(String title);

    void delete(String title);

    Page<Film> findAll(Pageable pageable);

}
