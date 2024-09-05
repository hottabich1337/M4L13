package org.example;

import org.example.entity.elementCollection.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ElementCollectionExample {

    public static void main(String[] args) {
        //        SessionFactory sessionFactory = new Configuration()
        //                                          .addAnnotatedClass(Client.class)
        //                                          .buildSessionFactory();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        List<String> emails = Arrays.asList("steve@apple.com", "ive.j@apple.com");
        Client client = new Client(UUID.randomUUID(), "Petya M", emails);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        }

//        try (Session session = sessionFactory.openSession()){
//            Client client1 = session.find(Client.class, UUID.fromString("0fb5615e-c845-46e7-9952-8d201f961afd"));
//            System.out.println(client1);
//        }
    }
}