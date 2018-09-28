CREATE TABLE repositories
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(512) NOT NULL,
    owner int NOT NULL,
    japanese_contribute boolean DEFAULT false NOT NULL,
    cla_required boolean DEFAULT false NOT NULL,
    registered_at datetime NOT NULL,
    CONSTRAINT repositories_accounts_id_fk FOREIGN KEY (owner) REFERENCES accounts (id)
);
