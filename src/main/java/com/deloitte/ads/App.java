package com.deloitte.ads;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Mario!");

        User bartek = new User("Bartek", "Andree");
        User wojtek = new User("Wojtek", "Kowalski");


        Marios exampleMarios = new Marios(
                Marios.MariosType.MARIOS1,
                "Fajnie, że jesteś");

        bartek.giveMariosToUser(wojtek,exampleMarios);

        System.out.println(wojtek.showUserReceivedMarios().toString());

    }
}
