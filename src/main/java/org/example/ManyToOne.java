package org.example;

import org.example.entity.manyToMany.Actor;
import org.example.entity.manyToMany.Movie;
import org.example.entity.manyToOne.Employee;
import org.example.entity.manyToOne.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ManyToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<Employee> employees = Arrays.asList(new Employee("Yura S"), new Employee("Dima T"));
        List<Task> tasks = Arrays.asList(new Task("doThisShitNow", employees.get(0)),
                                         new Task("doThatShitAfter", employees.get(1)),
                                         new Task("doNothing", employees.get(0))
        );

        // ДАЛЕЕ ДВА БЛОКА КОДА -> ОДИН ИЗ НИХ ДОЛЖЕН БЫТЬ ЗАКОММЕНТИРОВАН

        // ПИШЕМ ЧИСТЫХ employee
//        try (session) {
//            session.beginTransaction();
//            for (Employee employee : employees) {
//                session.persist(employee);
//            }
//            session.flush();
//        }

        // ПИШЕМ tasks СНАЧАЛА БЕЗ @ManyToOne(cascade = CascadeType.ALL), ПОТОМ С НЕЙ
        try (session) {
            session.beginTransaction();
            for (Task task : tasks) {
                session.persist(task);
            }
            session.flush();
        }
    }
}
