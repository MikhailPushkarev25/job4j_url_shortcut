package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Url;
import ru.job4j.repository.SiteRepository;
import ru.job4j.repository.UrlRepository;

import java.util.List;

@Service
public class UrlService {

    private final StringGenerator generator;
    private final UrlRepository urlRepository;
    private final SiteRepository siteRepository;

    public UrlService(StringGenerator generator, UrlRepository urlRepository, SiteRepository siteRepository) {
        this.generator = generator;
        this.urlRepository = urlRepository;
        this.siteRepository = siteRepository;
    }

    public Url saveUrl(Url url) {
        url = urlRepository.findByLink(url.getLink()).orElse(url);
        if (url.getId() == 0) {
            url.setUrl(generator.newUrl());
            url.setLink(url.getLink());
            url = urlRepository.save(url);
        }
        return url;
    }

    public String findByUrl(String url) {
        Url count = urlRepository.findByUrl(url).orElse(new Url());
        if (count.getId() != 0) {
            urlRepository.incrementId(count.getId());
        }
        return count.getLink();
    }

    public List<Url> findAll() {
        return (List<Url>) urlRepository.findAll();
    }
}
