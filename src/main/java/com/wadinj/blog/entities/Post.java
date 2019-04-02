package com.wadinj.blog.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POSTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "CONTENT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POST_DATE")
    private Date date;

}
