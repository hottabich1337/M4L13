package org.example;

import org.example.entity.manyToMany.Actor;
import org.example.entity.manyToMany.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class ManyToManyExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // ТУТ ВАЖНО КАК БЫЛИ ПРОСТАВЛЕНЫ АННОТАЦИИ НАД ПОЛЯМИ СУЩНОСТЕЙ, ИМЕННО ТАМ ВСЯ МАГИЯ
        // А ТАКЖЕ КАК СФОРМИРОВАНЫ ТАБЛИЦЫ
        try (session) {
            Movie movie = session.get(Movie.class, "2");
            Set<Actor> actors = movie.getActors();
            System.out.println(movie);
            System.out.println(actors);
        }
    }

}
