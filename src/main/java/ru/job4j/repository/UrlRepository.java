package ru.job4j.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Url;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Integer> {

    Optional<Url> findByLink(String link);

    Optional<Url> findByUrl(String url);

    @Transactional
    @Modifying
    @Query("update Url u set u.count = u.count + 1 where u.id = :id")
    void incrementId(Integer id);
}
