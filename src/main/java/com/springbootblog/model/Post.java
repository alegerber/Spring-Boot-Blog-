package com.springbootblog.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Post {

    @Id
    public long id = 1L;

    @Column(name="TITLE", length=50, nullable=false)
    private String title;

    @Lob @Basic(fetch=LAZY)
    @Column(name="CONTENT")
    private String content;

    @Column(name="UPDATED")
    private LocalDateTime updated;

    @Column(name="CREATED")
    private LocalDateTime created;

    @ElementCollection
    private ArrayList<Comment> comments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
