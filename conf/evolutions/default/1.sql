# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table sport (
  id                            integer auto_increment not null,
  created_at                    timestamp,
  updated_at                    timestamp,
  name                          varchar(255),
  point_value                   integer,
  constraint pk_sport primary key (id)
);


# --- !Downs

drop table if exists sport;

