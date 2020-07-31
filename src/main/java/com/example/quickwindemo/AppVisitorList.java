package com.example.quickwindemo;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppVisitorList {

    @Id
    public long id = 1L;

    @ElementCollection
    private Set<String> visitors = new HashSet<>();

    public void addVisitors(String visitor) {
        this.visitors.add(visitor);
    }

    public String getListAsString() {
        return  String.join(",", visitors);
    }
}
