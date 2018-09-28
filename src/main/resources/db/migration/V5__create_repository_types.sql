-- リポジトリの区分
CREATE TABLE repository_types
(
  id   int PRIMARY KEY AUTO_INCREMENT,
  name varchar(512) NOT NULL
);
CREATE UNIQUE INDEX repository_type_name_uindex
  ON repository_types (name);
