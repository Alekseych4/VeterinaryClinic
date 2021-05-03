-- liquibase formatted sql
-- changeset alekseych:1
create table staff (
                       id BINARY(16) not null,
                       user_type integer not null,
                       name varchar(255),
                       surname varchar(255),
                       position varchar(255),
                       experience varchar(255),
                       primary key (id)
);
-- changeset alekseych:2
create table schedule_item (
                               id BINARY(16) not null,
                               staff_id BINARY(16) not null,
                               description varchar(255),
                               duration bigint not null,
                               time_start datetime not null,
                               primary key (id),
                               foreign key (staff_id) references staff (id)
                                   on delete cascade
                                   on update cascade
) engine=InnoDB;
-- changeset alekseych:3
create table client (
                        id BINARY(16) not null,
                        name varchar(255) not null,
                        surname varchar(255) not null,
                        user_type integer not null,
                        primary key (id)
) engine=InnoDB;
-- changeset alekseych:4
create table patient_card (
                              id BINARY(16) not null,
                              client_id BINARY(16),
                              age integer,
                              animal_type varchar(255),
                              name varchar(255),
                              weight double precision,
                              primary key (id),
                              foreign key (client_id) references client (id)
                                  on delete cascade
                                  on update cascade
) engine=InnoDB;
-- changeset alekseych:5
create table appointment (
                             id BINARY(16) not null,
                             patient_card_id binary(16) not null,
                             schedule_item_id binary(16) not null UNIQUE,
                             primary key (id),
                             foreign key (patient_card_id) references patient_card (id)
                                 on delete cascade
                                 on update cascade,
                             foreign key (schedule_item_id) references schedule_item (id)
                                 on delete cascade
                                 on update cascade
) engine=InnoDB;
-- changeset alekseych:6
create table card_record (
                             id binary(16) not null,
                             patient_card_id binary(16) not null,
                             staff_id BINARY(16) not null,
                             date datetime not null,
                             description varchar(255),
                             diagnose varchar(255) not null,
                             prescription varchar(255),
                             primary key (id),
                             foreign key (patient_card_id) references patient_card (id)
                                 on delete cascade
                                 on update cascade,
                             foreign key (staff_id) references staff (id)
) engine=InnoDB;
-- changeset alekseych:7
create table info_about_clinic (
                                   id BINARY(16) not null,
                                   info varchar(255) not null,
                                   publication_date datetime,
                                   primary key (id)
) engine=InnoDB;