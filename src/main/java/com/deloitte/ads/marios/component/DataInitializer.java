//package com.deloitte.ads.marios.component;
//
//import com.deloitte.ads.marios.entity.Marios;
//import com.deloitte.ads.marios.entity.User;
//import com.deloitte.ads.marios.service.MariosService;
//import com.deloitte.ads.marios.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    private final UserService userService;
//    private final MariosService mariosService;
//
//    @Autowired
//    public DataInitializer(UserService userService, MariosService mariosService) {
//        this.userService = userService;
//        this.mariosService = mariosService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (userService.getAllUsers().isEmpty()) {
//            initializeData();
//        }
//
//    }
//    public void initializeData() {
//        User u1 = new User("Bartek", "Kowalski","BarKow", "bartekkowalski@gmail.com");
//        User u2 = new User("Jan", "Podwalski","JanPod", "janpodwalski@gmail.com");
//        User u3 = new User("Adam", "Zagórny","AdaZag", "adamzagorny@gmail.com");
//        User u4 = new User("Marek", "Piórko","MarPio", "marekpiorko@gmail.com");
//
//        Marios m1 = new Marios("Mario", "Good work!", u1, u2);
//        Marios m2 = new Marios("Luigi", "Thanks for your help", u3, u4);
//        Marios m3 = new Marios("Wario", "You are great specialist!", u1, u4);
//        Marios m4 = new Marios("Waluigi", "Your programming skills are awesome!", u2, u3);
//        Marios m5 = new Marios("Princess", "Good good my friend!", u1, u3);
//
//        userService.addMariosByInitializer(u1);
//        userService.addMariosByInitializer(u2);
//        userService.addMariosByInitializer(u3);
//        userService.addMariosByInitializer(u4);
//
//        mariosService.addMariosByInitializer(m1);
//        mariosService.addMariosByInitializer(m2);
//        mariosService.addMariosByInitializer(m3);
//        mariosService.addMariosByInitializer(m4);
//        mariosService.addMariosByInitializer(m5);
//    }
//}