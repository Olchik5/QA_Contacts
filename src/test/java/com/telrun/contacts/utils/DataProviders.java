package com.telrun.contacts.utils;

import com.telrun.contacts.models.Contact;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Jeck", "Braun", "12345678889", "jeck@gm.com", "Berlin", "IT"});
        list.add(new Object[]{"Jeck", "Braun", "12345678822", "jeck+1@gm.com", "Berlin", "IT"});
        list.add(new Object[]{"Jeck", "Braun", "12345678833", "jeck+2@gm.com", "Berlin", "IT"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0])
                    .setSureName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    public Iterator<Object[]> addNewUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Pet.com", "Hh123456ß?"});
        list.add(new Object[]{"Pe", "Hh123456ß?"});
        list.add(new Object[]{"@gmail.com", "Hh123456ß?"});
        return list.iterator();

    }

}
