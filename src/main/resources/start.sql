CREATE SCHEMA M4L13;

USE M4L13;

CREATE TABLE clients
(
    id          BINARY(16) PRIMARY KEY,
    client_name VARCHAR(255) DEFAULT NULL
);

CREATE TABLE client_emails
(
    client_id BINARY(16),
    emails    VARCHAR(255) DEFAULT NULL,
    FOREIGN KEY (client_id) REFERENCES clients (id)
);

DROP TABLE client_emails;

DROP TABLE clients;

CREATE TABLE `actors`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;

CREATE TABLE `movies`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 18
  DEFAULT CHARSET = utf8;

CREATE TABLE `actor_movie`
(
    `actor_id` INT NOT NULL,
    `movie_id` INT NOT NULL,
    PRIMARY KEY (`actor_id`, `movie_id`),
    KEY `movie_id` (`movie_id`),
    CONSTRAINT `actor_movie_ibfk_1`
        FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
    CONSTRAINT `actor_movie_ibfk_2`
        FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
);

INSERT INTO movies (id, name)
VALUES (1, 'Die Hard'),
       (2, 'Harry Potter');

INSERT INTO actors(id, name)
VALUES (1, 'Bruce Willis'),
       (2, 'Bonnie Bedelia'),
       (3, 'Rupert Grint'),
       (4, 'Alan Rickman');

INSERT INTO actor_movie (actor_id, movie_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 1),
       (4, 2);