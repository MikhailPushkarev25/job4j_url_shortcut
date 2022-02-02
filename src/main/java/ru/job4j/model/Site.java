package ru.job4j.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id must be non null")
    private int id;

    @NotBlank(message = "site not found")
    private String site;

    @Size(min = 6, max = 50, message = "name is too long or short")
    private String login;

    @Size(min = 5, message = "password is too short")
    private String password;

    public static Site of(String site) {
        Site site1 = new Site();
        site1.site = site;
        return site1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site1 = (Site) o;
        return id == site1.id && Objects.equals(site, site1.site) && Objects.equals(login, site1.login) && Objects.equals(password, site1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, site, login, password);
    }
}
