-- フレームワーク・ライブラリの種類
CREATE TABLE frameworks
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(512) NOT NULL
);
CREATE UNIQUE INDEX frameworks_name_uindex ON frameworks (name);
