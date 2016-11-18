# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table person (
  id                            varchar(255) not null,
  name                          varchar(255),
  constraint pk_person primary key (id)
);

create table product (
  id                            bigint not null,
  productname                   varchar(255),
  quantity                      integer,
  description                   varchar(255),
  price                         decimal(38),
  constraint pk_product primary key (id)
);
create sequence product_seq;

create table user (
  id                            bigint not null,
  email                         varchar(255),
  username                      varchar(255),
  pass                          varchar(255),
  passconf                      varchar(255),
  constraint pk_user primary key (id)
);
create sequence user_seq;


# --- !Downs

drop table if exists person;

drop table if exists product;
drop sequence if exists product_seq;

drop table if exists user;
drop sequence if exists user_seq;

