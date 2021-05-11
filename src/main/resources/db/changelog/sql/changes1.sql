ALTER TABLE client DROP COLUMN user_type;

ALTER TABLE staff DROP COLUMN user_type;

CREATE TABLE user (
  id binary(16) not null,
  email varchar(255) not null unique,
  password varchar(255) not null,
  user_role varchar(20) not null,
  primary key (id)
) engine=InnoDB;

ALTER TABLE client ADD FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE staff ADD FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE CASCADE;