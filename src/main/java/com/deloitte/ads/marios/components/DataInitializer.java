package com.deloitte.ads.marios.components;

import com.deloitte.ads.marios.repository.Marios;
import com.deloitte.ads.marios.repository.User;
import com.deloitte.ads.marios.service.MyService;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final MyService myService;


    @Autowired
    public DataInitializer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeData();


    }
    public void initializeData() {
        User u1 = new User(1, "Bartek", "Andree");
        User u2 = new User(2, "Kinga", "Banach");
        User u3 = new User(3, "Mateusz", "Zwierzlak");
        User u4 = new User(4, "Bartek", "Szymanski");

        Marios m1 = new Marios(1, "Good job", "You are the best", u1, u2);
        Marios m2 = new Marios(2, "Thanks", "You are the best", u1, u3);
        Marios m3 = new Marios(3, "Nice to have you", "You are the best", u1, u4);
        Marios m4 = new Marios(4, "Good job", "You are the best", u2, u1);
        Marios m5 = new Marios(5, "Thanks", "You are the best", u2, u3);

        this.myService.userSet = Sets.newHashSet(u1,u2,u3,u4);
        this.myService.mariosSet = Sets.newHashSet(m1,m2,m3,m4,m5);


    }
}