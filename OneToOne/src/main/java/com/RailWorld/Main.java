package com.RailWorld;

import com.RailWorld.Model.Passport;
import com.RailWorld.Model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
        EntityManager em = emf.createEntityManager();

        Passport passport = new Passport();
        Person person = new Person();

        System.out.println("Enter Passport Number : ");
        passport.setPassportNumber(scanner.nextLine());

        System.out.println("Enter Person Name : ");
        person.setName(scanner.nextLine());

        person.setPassport(passport);

        em.getTransaction().begin();      


        em.persist(person);
        em.getTransaction().commit();


        // Find Person
//        Person person = new Person();
//        Person foundPerson = em.find(Person.class, person.getId());
//        System.out.println("Person found: " + foundPerson.getName());

        // Update Person
//        em.getTransaction().begin();
//        foundUser.setName("John Smith");
//        em.getTransaction().commit();
//        System.out.println("Updated User Name: " + foundUser.getName());
//
//        // Delete User
//        em.getTransaction().begin();
//        em.remove(foundUser);
//        em.getTransaction().commit();
//        System.out.println("User deleted.");
//
        em.close();
        emf.close();
    }
}