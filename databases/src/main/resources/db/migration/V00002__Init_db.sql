   create table product (
        id  bigserial not null,
        product_name varchar(255) not null,
        price float not null,
        status boolean not null,
        production_year bigint not null,
        type_id bigint not null,
        primary key (id)
    );

   create table type (
       id bigserial not null,
       type_name varchar(255) not null,
       primary key (id)
   );


    alter table if exists product add constraint type_id foreign key (type_id) references type;
    insert into type(id, type_name) values(1, 'home');
    insert into type(id, type_name) values(2, 'kitchen');
    insert into product(id, product_name, price, status, production_year, type_id) values(1, 'plate', 192.2, true, 2023, 2);
    insert into product(id, product_name, price, status, production_year, type_id) values(2, 'plate', 142.2, true, 2022, 2);
    insert into type(id, type_name) values(3, 'bathroom');
    insert into product(id, product_name, price, status, production_year, type_id) values(3, 'towel', 500.2, true, 2023, 3);
    insert into product(id, product_name, price, status, production_year, type_id) values(4, 'brick', 142.2, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(5, 'shampoo', 192.2, true, 2023, 3);
    insert into product(id, product_name, price, status, production_year, type_id) values(6, 'brick', 142.2, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(7, 'brick', 2000.2, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(8, 'brick', 1150.2, true, 2012, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(9, 'brick', 150.3, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(10, 'brick', 50.4, true, 2023, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(11, 'brick', 220.9, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(12, 'brick', 320.8, true, 2021, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(13, 'brick', 564.9, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(14, 'brick', 130.5, true, 2022, 1);
    insert into product(id, product_name, price, status, production_year, type_id) values(15, 'brick', 402.3, true, 2022, 1);





