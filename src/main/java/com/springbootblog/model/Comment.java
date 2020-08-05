package com.springbootblog.model;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Comment {

    @Id
    public long id = 1L;

    @Lob
    @Basic(fetch=LAZY)
    @Column(name="CONTENT")
    private String content;

    @Column(name="UPDATED")
    private LocalDateTime updated;

    @Column(name="CREATED")
    private LocalDateTime created;

    public long getId() {
        return id;
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

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
