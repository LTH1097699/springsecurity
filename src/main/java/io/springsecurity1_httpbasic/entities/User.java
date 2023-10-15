package io.springsecurity1_httpbasic.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    // If dont use @EntityGraph, must use fetch type eager because
    // getAuthors in SecurityUser use this variables
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_author_map", schema = "public",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorEntity> authors;
}
