package ru.job4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.model.Url;
import ru.job4j.service.UrlService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/all")
public class UrlFindAll {

    private final UrlService urlService;

    public UrlFindAll(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/statistic")
    public List<Url> findAll() {
        return new ArrayList<>(urlService.findAll());
    }
}
