CREATE TABLE authorized_clients
(
  id              integer PRIMARY KEY AUTO_INCREMENT,
  account_id      integer      NOT NULL,
  principal_name  varchar(256) NOT NULL,
  registration_id varchar(256) NOT NULL,
  token_value     varchar(256) NOT NULL,
  issued_at       datetime    NOT NULL,
  expires_at      datetime    NOT NULL,
  unique index (registration_id, principal_name),
  foreign key (account_id) references accounts (id)
);
