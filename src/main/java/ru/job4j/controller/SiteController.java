package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Site;
import ru.job4j.service.SiteService;

import javax.validation.Valid;


@RestController
@RequestMapping("/site")
public class SiteController {

    private final SiteService sites;

    public SiteController(SiteService sites) {
        this.sites = sites;
    }

    @PostMapping("/registration")
    public ResponseEntity<Site> signUp(@Valid @RequestBody Site site) {
        if (site.getSite() == null) {
            throw new NullPointerException("Site mustn't be empty");
        }
        return new ResponseEntity<Site>(
                sites.saveSite(site),
                HttpStatus.CREATED
        );
    }
}
