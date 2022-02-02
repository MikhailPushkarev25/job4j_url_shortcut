package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.model.Url;
import ru.job4j.service.UrlService;

import javax.validation.Valid;

@RestController
@RequestMapping("/line")
public class UrlConvertController {

    private final UrlService urlService;

    public UrlConvertController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/convert")
    public ResponseEntity<Url> saveUrl(@Valid @RequestBody Url url) {
        if (url.getLink() == null) {
            throw new NullPointerException("Link mustn't be empty");
        }
        return new ResponseEntity<Url>(
                urlService.saveUrl(url),
                HttpStatus.CREATED
        );
    }
}
