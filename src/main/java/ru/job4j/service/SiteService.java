package ru.job4j.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.model.Site;
import ru.job4j.repository.SiteRepository;

@Service
public class SiteService {

    private final SiteRepository sites;
    private final BCryptPasswordEncoder encoder;
    private final StringGenerator generator;

    public SiteService(SiteRepository sites, BCryptPasswordEncoder encoder, StringGenerator generator) {
        this.sites = sites;
        this.encoder = encoder;
        this.generator = generator;
    }

    public Site saveSite(Site site) {
        if (sites.findBySite(site.getSite()) == null) {
            site.setLogin(generator.newLogin());
            String password = generator.newPassword();
            site.setPassword(encoder.encode(password));
            sites.save(site);
            site.setPassword(password);
        }
        return site;
    }
}
