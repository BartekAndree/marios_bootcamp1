package com.deloitte.ads.marios.component;

import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.service.MariosService;
import com.deloitte.ads.marios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserService userService;
    private final MariosService mariosService;

    @Autowired
    public DataInitializer(UserService userService, MariosService mariosService) {
        this.userService = userService;
        this.mariosService = mariosService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userService.getAllUsers().isEmpty()) {
            initializeData();
        }

    }
    public void initializeData() {
        User u0 = new User("Bartek", "Andree", "BartekAndree", "andree.bartek@gmail.com");
        User u1 = new User("Bartek", "Kowalski","BarKow", "bartekkowalski@gmail.com");
        User u2 = new User("Jan", "Podwalski","JanPod", "janpodwalski@gmail.com");
        User u3 = new User("Adam", "Zagórny","AdaZag", "adamzagorny@gmail.com");
        User u4 = new User("Marek", "Piórko","MarPio", "marekpiorko@gmail.com");

        Marios m1 = new Marios("Mario", "You did great today Jan!", "Good work!", u1, u2);
        Marios m2 = new Marios("Luigi", "You did great today Marek!", "Thanks for your help", u3, u4);
        Marios m3 = new Marios("Wario", "You did great today Marek!", "You are great specialist!", u1, u4);
        Marios m4 = new Marios("Waluigi", "You did great today Adam!", "Your programming skills are awesome!", u2, u3);
        Marios m5 = new Marios("Princess", "You did great today Adam!", "Good good my friend!", u1, u3);
        Marios m6 = new Marios("Mario", "You did great today Bartek!", "Very good!", u1, u0);
        Marios m7 = new Marios("Mario", "You did great today Bartek!", "Very good!", u2, u0);
        Marios m8 = new Marios("Mario", "You did great today Bartek!", "Very good!", u3, u0);
        Marios m9 = new Marios("Mario", "You did great today Bartek!", "Very good!", u4, u0);
        Marios m10 = new Marios("Wario", "You did great today Bartek!", "Gr8 work!", u1, u0);
        Marios m11 = new Marios("Mario", "You did great today Bartek!", "Gr8 work!", u2, u0);
        Marios m12 = new Marios("Mario", "You did great today Bartek!", "Gr8 work!", u3, u0);
        Marios m13 = new Marios("Mario", "You did great today Bartek!", "Gr8 work!", u0, u1);
        Marios m14 = new Marios("Mario", "You did great today Jan!", "Gr8 work!", u0, u2);
        Marios m15 = new Marios("Mario", "You did great today Adam!", "Gr8 work!", u0, u3);
        Marios m16 = new Marios("Mario", "You did great today Marek!", "Gr8 work!", u0, u4);



        userService.addMariosByInitializer(u0);
        userService.addMariosByInitializer(u1);
        userService.addMariosByInitializer(u2);
        userService.addMariosByInitializer(u3);
        userService.addMariosByInitializer(u4);

        mariosService.addMariosByInitializer(m1);
        mariosService.addMariosByInitializer(m2);
        mariosService.addMariosByInitializer(m3);
        mariosService.addMariosByInitializer(m4);
        mariosService.addMariosByInitializer(m5);
        mariosService.addMariosByInitializer(m6);
        mariosService.addMariosByInitializer(m7);
        mariosService.addMariosByInitializer(m8);
        mariosService.addMariosByInitializer(m9);
        mariosService.addMariosByInitializer(m10);
        mariosService.addMariosByInitializer(m11);
        mariosService.addMariosByInitializer(m12);
        mariosService.addMariosByInitializer(m13);
        mariosService.addMariosByInitializer(m14);
        mariosService.addMariosByInitializer(m15);
        mariosService.addMariosByInitializer(m16);


    }
}