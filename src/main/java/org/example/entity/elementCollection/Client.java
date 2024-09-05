package org.example.entity.elementCollection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    @Id
    @Column(name = "id")
    //@GeneratedValue
    private UUID id;

    @Column(name = "client_name")
    private String name;

    @ElementCollection
    // ДАННАЯ АННОТАЦИЯ НАПРЯМУЮ ОПРЕДЕЛЯЕТ ИМЯ ТАБЛИЦЫ ДЛЯ ЗАВИСИМЫХ СУЩНОСТЕЙ
    //@CollectionTable(name = "builded_by_me_cl_emails")
   // @Column(name = "emails")
    private List<String> emails;
}


