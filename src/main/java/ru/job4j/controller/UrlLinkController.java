package ru.job4j.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.service.UrlService;

import javax.validation.Valid;

@RestController
@RequestMapping("/link")
public class UrlLinkController {

    private final UrlService urlService;

    public UrlLinkController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/sdr/{url}")
    public ResponseEntity<Void> findByUrl(@Valid @PathVariable String url) {
        String res = urlService.findByUrl(url);
        if (res != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("url", url);
            return new ResponseEntity<Void>(
                    headers,
                    HttpStatus.MOVED_PERMANENTLY
            );
        }
        return new ResponseEntity<Void>(
                HttpStatus.NOT_FOUND
        );
    }
}
