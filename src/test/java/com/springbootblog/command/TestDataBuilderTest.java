//package com.springbootblog.command;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.persistence.EntityManager;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class TestDataBuilderTest {
//
//    @Test
//    public void runTest()
//    {
//        try {
//            TestDataBuilder testDataBuilder = new TestDataBuilder();
//            testDataBuilder.entityManager   = mock(EntityManager.class);
//            testDataBuilder.logger          = mock(Logger.class);
//
//            verify(testDataBuilder.entityManager).persist(anyObject());
//            verify(testDataBuilder.entityManager).flush();
//
//            testDataBuilder.run();
//        } catch (Exception e) {
//            fail();
//        }
//    }
//}
