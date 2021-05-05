create table customers
(
    id           bigserial primary key,
    name         varchar not null,
    surname      varchar not null,
    age          smallint check ( age > 0 and age < 100 ),
    phone_number bigint unique
);