package me.soulyana.springsecuritybasic;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToMany
    private Set<AppUser> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }
}
