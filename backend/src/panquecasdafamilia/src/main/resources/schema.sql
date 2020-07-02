drop table if exists client;

create table client(
  id_client bigint not null auto_increment,
  name varchar(100) not null,
  street varchar(100) not null,
  neighborhood varchar(100) not null,
  house_number int not null,
  primary key(id_client));