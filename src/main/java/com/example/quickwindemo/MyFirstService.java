package com.example.quickwindemo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MyFirstService {

    @PersistenceContext
    private EntityManager entityManager;

    public MyFirstService() {
        System.out.println("test");
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("testEvent");
    }

    static int counter = 0;

    @Transactional
    public HelloDto hello(String user) {
        counter++;
        String helloMessage = String.format("theses application runs %s times for %s", counter, user);
        return new HelloDto(helloMessage + " "  + getVisitorList(user));
    }

    private String getVisitorList(String user) {
        AppVisitorList result = entityManager.find(AppVisitorList.class, 1L);

        if (null == result) {
           AppVisitorList newList = new AppVisitorList();
           result = newList;
           entityManager.persist(newList);
        }

        result.addVisitors(user);

        return result.getListAsString();
    }
}
