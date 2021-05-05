create table orders
(
    id           bigserial primary key,
    date         timestamptz default now(),
    customer_id  bigint references customers (id),
    product_name varchar not null unique,
    amount       integer not null
);

create index customer_id_ind on orders(customer_id);