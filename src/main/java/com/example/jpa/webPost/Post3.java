package com.example.jpa.webPost;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "Post3.findByTitle", query = "select p FROM Post3 as p where p.title = ?1")
public class Post3 {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
