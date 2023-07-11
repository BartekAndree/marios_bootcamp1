package com.deloitte.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static Scanner input = new Scanner(System.in);
    private static List<User> allUsers = new ArrayList<>();
    private static List<Team> allTeams = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello Marios!");

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Create Marios");
            System.out.println("3. Create Team");
            System.out.println("4. Add User to Team");
            System.out.println("5. View Users Marios");
            System.out.println("6. View Teams Marios");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("First name:");
                String firstName = input.nextLine();

                System.out.println("Last name:");
                String lastName = input.nextLine();

                if (validateNames(firstName, lastName)) {
                    User User = new User(firstName, lastName);
                    allUsers.add(User);
                    System.out.println("New User: " + User.toString() + " has been created!");
                } else {
                    System.out.println("You can't create that user");
                }
            } else if (choice == 2) {

            } else if (choice == 3) {
                System.out.println("Team name:");
                String teamName = input.nextLine();

                if (validateTeamName(teamName)) {
                    Team team = new Team(teamName);
                    allTeams.add(team);
                    System.out.println("New Team: " + team.toString() + " has been created!");
                } else {
                    System.out.println("You can't create that user");
                }
            } else if (choice == 4) {

            } else if (choice == 5) {
                printUsers();
                System.out.println("Select a user (type last name:");
                String selectedUser = input.nextLine();
                User user = findUserByLastName(selectedUser, allUsers);
                if(user != null){
                    user.showUserReceivedMarios();
                }

            } else if (choice == 6) {

            } else {
                break;
            }
        }

    }

    public static boolean validateNames(String firstName, String lastName) {
        return firstName != null && lastName != null && firstName.length() >= 4 && firstName.length() <= 10 && lastName.length() >= 4 && lastName.length() <= 10;
    }

    public static boolean validateTeamName(String teamName) {
        return teamName != null && teamName.length() >= 4 && teamName.length() <= 20;
    }

    public static void printUsers() {
        int index = 1;
        for (User user : allUsers) {
            System.out.println(index + ". " + user.toString());
            index++;
        }
    }

    public static User findUserByLastName(String lastName, List<User> list) {
        return list.stream()
                .filter(user -> user.getLastName()
                        .equals(lastName))
                .findFirst()
                .orElse(null);
    }


}

