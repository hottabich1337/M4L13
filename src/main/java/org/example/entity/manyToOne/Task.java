package org.example.entity.manyToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// MANY to ONE - МНОГО ЗАДАЧ - ОТНОСЯТСЯ - К ОДНОМУ РАБОТНИКУ

@Entity
@Table(name="tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee")
    private Employee employee;

    public Task(String description, Employee employee) {
        this.description = description;
        this.employee = employee;
    }
}

