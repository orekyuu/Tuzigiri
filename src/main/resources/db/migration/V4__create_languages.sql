-- 選択可能なプログラミング言語のマスタ
CREATE TABLE languages
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(512) NOT NULL
);
CREATE UNIQUE INDEX languages_name_uindex ON languages (name);
