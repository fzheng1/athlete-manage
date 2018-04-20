# --- !Ups

create table sport (
  id                            integer auto_increment not null,
  name                          varchar(255),
  point_value                   integer,
  constraint pk_sport primary key (id)
);


# --- !Downs

drop table if exists sport;

