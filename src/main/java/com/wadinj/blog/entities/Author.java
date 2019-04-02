package com.wadinj.blog.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "AUTHORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @GeneratedValue
    @Id
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DESCRIPTION")
    private String description;
}
