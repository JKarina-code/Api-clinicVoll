create table doctors (
        id bigint not null auto_increment,
        name varchar(100) not null,
        email varchar(100) not null unique,
        document varchar(100) not null unique,
        specialty varchar(100) not null,
        street varchar(100) not null,
        district varchar(100) not null,
        complement varchar(100),
        number_ad varchar(100),
        city varchar(100) not null,
        phone varchar(100) not null,
        primary key (id)
    );