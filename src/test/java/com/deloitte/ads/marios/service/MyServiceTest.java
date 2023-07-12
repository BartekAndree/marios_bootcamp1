package com.deloitte.ads.marios.service;

import com.deloitte.ads.marios.controller.MariosController;
import com.deloitte.ads.marios.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServiceTest {
    @Autowired
    private MyService myService;

    @Test
    void addMariosSuccessful() {
        int count = myService.getAllMarios().size();

        int senderId = 1;
        int receiverId = 2;
        String type = "Good job!";
        String comment = "Top top";

        myService.addMarios(senderId, receiverId, type, comment);
        int countAfter = myService.getAllMarios().size();
        Assertions.assertEquals(count + 1, countAfter);
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
        Assertions.assertEquals(count, countAfter);
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
        Assertions.assertEquals(count, countAfter);
    }
}