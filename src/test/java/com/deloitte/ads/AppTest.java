package com.deloitte.ads;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.deloitte.ads.App.findUserByLastName;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void validateNamesTest1(){
        //given
        String firstName = "Bartek";
        String lastName = "Andree";
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    public void validateNamesTest2(){
        //given
        String firstName = "Bar";
        String lastName = "Andree";
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateNamesTest3(){
        //given
        String firstName = "Bartek";
        String lastName = "And";
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateNamesTest4(){
        //given
        String firstName = "Bartekbartek";
        String lastName = "Andree";
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateNamesTest5(){
        //given
        String firstName = "Bartek";
        String lastName = "Andreeandree";
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateNamesTest6(){
        //given
        String firstName = null;
        String lastName = null;
        //when
        boolean result = App.validateNames(firstName, lastName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateTeamNamesTest1(){
        //given
        String teamName = "Winners";
        //when
        boolean result = App.validateTeamName(teamName);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    public void validateTeamNamesTest2(){
        //given
        String teamName = "Win";
        //when
        boolean result = App.validateTeamName(teamName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateTeamNamesTest3(){
        //given
        String teamName = "WinnersWinnersWinners";
        //when
        boolean result = App.validateTeamName(teamName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void validateTeamNamesTest4() {
        //given
        String teamName = null;
        //when
        boolean result = App.validateTeamName(teamName);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    public void findUserByLastNameTest1(){
        User user = new User("Bartek", "Andree");
        List<User> allUser = new ArrayList<>();
        allUser.add(user);
        String lastName = "And";

        User newUser = findUserByLastName(lastName, allUser);

        Assertions.assertNull(newUser);
    }
    @Test
    public void findUserByLastNameTest2(){
        User user = new User("Bartek", "Andree");
        List<User> allUser = new ArrayList<>();
        allUser.add(user);
        String lastName = "Andree";

        User newUser = findUserByLastName(lastName, allUser);

        Assertions.assertEquals(newUser,user);
    }

}
