package com.springbootblog.model;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Lob
    @Basic(fetch=LAZY)
    @Column(name="CONTENT")
    private String content;

    @Column(name="UPDATED")
    private LocalDateTime updated;

    @Column(name="CREATED")
    private LocalDateTime created;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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
        updated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
