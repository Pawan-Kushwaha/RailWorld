package com.RailWorld.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
        EntityManager em = emf.createEntityManager();

//         Create User
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        // Persist User
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
//
        // Find User
//        User foundUser = em.find(User.class, user.getId());
//        System.out.println("User found: " + foundUser.getName());
//
        // Update User
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