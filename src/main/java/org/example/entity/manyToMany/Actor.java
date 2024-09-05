package org.example.entity.manyToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

   // @Column(name = "movies")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actor_movie",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    // В ЧЕМ ОПАСНОСТЬ ИСПОЛЬЗОВАНИЯ HashSet?
    Set<Movie> movies = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

//    @Override
//    public String toString() {
//        return "Actor{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }

}
