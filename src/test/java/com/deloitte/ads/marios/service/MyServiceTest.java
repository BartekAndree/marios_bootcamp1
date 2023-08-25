package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.controller.MariosController;
import com.deloitte.ads.marios.controller.UserController;
import com.deloitte.ads.marios.repository.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MyServiceTest {
    @Autowired
    private MyService myService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addMariosSuccessful() {
        int count = myService.getAllMarios().size();

        int senderId = 1;
        int receiverId = 2;
        String type = "Good job!";
        String comment = "Top top";

        myService.addMarios(senderId, receiverId, type, comment);
        int countAfter = myService.getAllMarios().size();
        assertEquals(count + 1, countAfter);
    }
    @Test
    void addMariosFailed1() {
        int count = myService.getAllMarios().size();

        int senderId = 1;
        int receiverId = 2;
        String type = null;
        String comment = "Top top";

        myService.addMarios(senderId, receiverId, type, comment);
        int countAfter = myService.getAllMarios().size();
        assertEquals(count, countAfter);
    }
    @Test
    void addMariosFailed2() {
        int count = myService.getAllMarios().size();

        int senderId = 1;
        int receiverId = 1;
        String type = "Great job!";
        String comment = "Top top";

        myService.addMarios(senderId, receiverId, type, comment);
        int countAfter = myService.getAllMarios().size();
        assertEquals(count, countAfter);
    }


    @Test
    void addMarios() {
        int initialSize = myService.getAllMarios().size();
        myService.addMarios(1, 2, "Bravo", "Well done");
        assertEquals(initialSize + 1, myService.getAllMarios().size());
    }
    @Test
    void testAddMariosWithSameSenderReceiver() {
        int initialSize = myService.getAllMarios().size();
        myService.addMarios(1, 1, "Bravo", "Well done");
        assertEquals(initialSize, myService.getAllMarios().size()); // should remain the same
    }

    @Test
    void addUser() {
        int initialSize = myService.getAllUsers().size();
        myService.addUser("John", "Doe");
        assertEquals(initialSize + 1, myService.getAllUsers().size());
    }
    @Test
    void testFindUserById() {
        User user = myService.findUserById(1);
        assertNotNull(user);
        assertEquals("Bartek", user.getFirstName());
    }


}